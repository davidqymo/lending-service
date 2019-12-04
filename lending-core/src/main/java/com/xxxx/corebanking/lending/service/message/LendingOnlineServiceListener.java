package com.xxxx.corebanking.lending.service.message;

import com.xxxx.corebanking.lending.service.message.support.MessageHandlerFactory;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.*;

public class LendingOnlineServiceListener implements MessageListener {

    MessageHandlerFactory factory;
    JmsTemplate template;

    @Override
    public void onMessage(Message message) {

        MessageHandler handle = factory.getInstance( message );
        String result = handle.processRequest( message );
        try {
            template.setDefaultDestination( message.getJMSReplyTo( ) );
            template.send( session -> session.createTextMessage( result ) );

        } catch (JMSException e) {
            e.printStackTrace( );
        }
    }

    public MessageHandlerFactory getFactory() {
        return factory;
    }

    public void setFactory(MessageHandlerFactory factory) {
        this.factory = factory;
    }

    public JmsTemplate getTemplate() {
        return template;
    }

    public void setTemplate(JmsTemplate template) {
        this.template = template;
    }
}
