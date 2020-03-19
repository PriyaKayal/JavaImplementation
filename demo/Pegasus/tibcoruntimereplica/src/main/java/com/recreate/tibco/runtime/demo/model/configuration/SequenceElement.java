package com.recreate.tibco.runtime.demo.model.configuration;

import com.recreate.tibco.runtime.demo.model.interfaces.Element;
import org.springframework.cglib.beans.BeanGenerator;
import org.springframework.cglib.core.NamingPolicy;
import org.springframework.cglib.core.Predicate;

import java.util.ArrayList;
import java.util.List;

public class SequenceElement implements Element<List<Element>> {
    private String name;
    private List<Element> value;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public List<Element> getValue() {
        return this.value;
    }

    @Override
    public void setValue(List<Element> value) {
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
        generator.setSuperclass(ArrayList.class);
        return (Class) generator.createClass();
    }
}
