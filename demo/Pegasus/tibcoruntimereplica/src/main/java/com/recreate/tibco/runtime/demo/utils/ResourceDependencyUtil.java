package com.recreate.tibco.runtime.demo.utils;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;

public class ResourceDependencyUtil {
    public static boolean doesDependencyExist(String value) {
        return value.startsWith("%%");
    }

    public static void addPropertyBinding(BeanDefinitionBuilder builder, String name, String config) {
        if (ResourceDependencyUtil.doesDependencyExist(config)) {
            builder.addPropertyReference(name, config);
        } else {
            builder.addPropertyValue(name, config);
        }
    }
}
