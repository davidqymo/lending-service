package com.xxxx.corebanking.lending.mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EventHandler implements ApplicationListener {
    private static Logger logger = LoggerFactory.getLogger( Thread.currentThread( ).getName( ) );

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        logger.info( "Received the event {}", applicationEvent );
    }
}
