package com.recreate.tibco.runtime.demo;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
// import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class StartupApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger LOGGER = Logger.getLogger(StartupApplicationListener.class.getName());

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        // Step : 1 : Initialise input
        // Step 2 : Process Default variables
        // Step 3 : Process Shared resources
        // Step 2 : Process processes
        LOGGER.info("Application refresh event");
    }
}
