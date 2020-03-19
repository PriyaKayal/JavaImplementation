package com.recreate.tibco.runtime.demo;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class ApplicationConfiguration {
    @Bean
    static CustomBeanDefinitionProcessor customBeanDefinitionProcessor() {
        return new CustomBeanDefinitionProcessor();
    }

    /*@Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("oracle.jdbc.OracleDriver");
        dataSourceBuilder.url("jjdbc:oracle:thin:@ldap://oid.inf.fedex.com:3060/IFAOD_APPS_SVC1_LVL2,cn=OracleContext,dc=ute,dc=fedex,dc=com");
        dataSourceBuilder.username("IFAOD_PEGASUS_APP");
        dataSourceBuilder.password("IfaODpEgaSusLvl2");
        return dataSourceBuilder.build();
    }*/
}
