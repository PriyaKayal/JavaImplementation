package com.recreate.tibco.runtime.demo;

import com.recreate.tibco.runtime.demo.model.interfaces.RunnableActivity;
import com.recreate.tibco.runtime.demo.model.runnable.JDBCSelectActivity;
import com.recreate.tibco.runtime.demo.model.runnable.Process;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ImportResource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Logger;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@ImportResource("RuntimeInputBean.xml")
public class DemoApplication {

    private static final Logger LOGGER = Logger.getLogger(DemoApplication.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        /*for (String dataSourceBean : context.getBeanNamesForType(JDBCDataSource.class)) {
            ((JDBCDataSource) context.getBean(dataSourceBean)).instantiateDataSource();
        }*/
        // LOGGER.info(((JDBCSelectActivity) ((Process) context.getBean("ConvertZulToLoc")).getActivityMap().get("GetLocalAdjustments")).getSelectQuery());
        Arrays.asList(context.getBeanDefinitionNames()).forEach(LOGGER::info);
        ((Process) context.getBean("ConvertZulToLoc")).run();
        // LOGGER.info(context.getBeanDefinition("JdbcConnectionForCommonDb"));
    }
}
