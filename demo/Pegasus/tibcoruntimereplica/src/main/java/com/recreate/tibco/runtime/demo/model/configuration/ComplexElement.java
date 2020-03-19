package com.recreate.tibco.runtime.demo.model.configuration;

import com.recreate.tibco.runtime.demo.model.interfaces.Element;
import org.springframework.cglib.beans.BeanGenerator;
import org.springframework.cglib.core.NamingPolicy;
import org.springframework.cglib.core.Predicate;

import java.util.Map;

public class ComplexElement implements Element<Map<String, Element>> {
    private String name;
    private Map<String, Element> value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Element getValueForKey(String key) {
        return this.value.get(key);
    }

    public void setValueForKey(String key, Object value) {
        // TODO : Test mutation
        this.value.get(key).setValue(value);
    }

    @Override
    public Map<String, Element> getValue() {
        return value;
    }

    @Override
    public void setValue(Map<String, Element> value) {
        this.value = value;
    }

    @Override
    public Class getClassDefinition() {
        BeanGenerator generator = new BeanGenerator();
        generator.setNamingPolicy(new NamingPolicy() {
            @Override
            public String getClassName(String s, String s1, Object o, Predicate predicate) {
                return name;
            }
        });
        this.value.forEach((s, element) -> {
            generator.addProperty(s, element.getClassDefinition());
        });
        return (Class) generator.createClass();
    }

    @Override
    public String toString() {
        return "ComplexElement{" +
                "name='" + name + '\'' +
                ", entities=" + String.join(",", value.keySet()) +
                '}';
    }
}
