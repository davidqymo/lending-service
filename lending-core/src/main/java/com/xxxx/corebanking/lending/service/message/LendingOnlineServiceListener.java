package com.xxxx.corebanking.lending.service.message;

import com.xxxx.corebanking.lending.service.message.support.MessageHandlerFactory;
import com.xxxx.corebanking.lending.service.message.support.TransactionTypeAnnotation;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.time.Duration;
import java.time.LocalTime;


public class LendingOnlineServiceListener implements MessageListener {

    MessageHandlerFactory factory;
    JmsTemplate template;

    @Override
    public void onMessage(Message message) {

        Logger logger = LoggerFactory.getLogger( Thread.currentThread( ).getName( ) );
        MessageHandler handler = factory.getInstance( message );

        //使用动态代理，增强收集性能信息，减少入侵

        MessageHandler proxyObject = (MessageHandler) Proxy.newProxyInstance( this.getClass( ).getClassLoader( ), new Class[]{MessageHandler.class},
                (proxy, method, args) -> {

                    LocalTime t1 = LocalTime.now( );

                    Object object = method.invoke( handler, args );

                    TransactionTypeAnnotation annotation = handler.getClass( ).getAnnotation( TransactionTypeAnnotation.class );
                    Duration duration = Duration.between( t1, LocalTime.now( ) );
                    logger.info( "Transaction Type {} Process Duration {} ms", annotation.value( ), duration.toMillis( ) );

                    return object;
                } );


        String result = proxyObject.processRequest( message );

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
