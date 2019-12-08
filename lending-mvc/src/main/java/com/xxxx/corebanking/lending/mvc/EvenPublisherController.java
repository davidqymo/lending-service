package com.xxxx.corebanking.lending.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EvenPublisherController {

    @Autowired
    ApplicationContext ac;

    @RequestMapping("/publish")
    @ResponseBody
    public String publishEvent() {

        ApplicationEvent event = new ApplicationEvent( "This my Event" ) {
            @Override
            public Object getSource() {
                return super.getSource( );
            }

            @Override
            public String toString() {
                return super.toString( );
            }
        };
        ac.publishEvent( event );

        return "Event Publish completed";
    }
}
