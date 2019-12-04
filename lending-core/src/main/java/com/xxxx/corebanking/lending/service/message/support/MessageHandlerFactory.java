package com.xxxx.corebanking.lending.service.message.support;

import com.xxxx.corebanking.lending.service.message.MessageHandler;
import org.springframework.context.ApplicationContext;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class MessageHandlerFactory {

    private final int START_POS_TRANSACTIONCODE = 4;
    private final int END_POS_TRANSACTIONCODE = 10;
    private Map<String, MessageHandler> map = new ConcurrentHashMap<String, MessageHandler>( );
    private ApplicationContext ac;


    public void init() {
        Map<String, Object> beanswithAnnocations = ac.getBeansWithAnnotation( TransactionTypeAnnotation.class );
        for (Object bean : beanswithAnnocations.values( )) {
            TransactionTypeAnnotation annotation = bean.getClass( ).getAnnotation( TransactionTypeAnnotation.class );
            map.put( annotation.value( ), (MessageHandler) bean );
        }
    }

    public MessageHandler getInstance(Message message) {
        String transactionCode = getTransactionCode( message );
        if (transactionCode != null) {
            return map.get( transactionCode );
        }
        return null;
    }

    private String getTransactionCode(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {
            String body = textMessage.getText( );
            return body.substring( START_POS_TRANSACTIONCODE, END_POS_TRANSACTIONCODE );
        } catch (JMSException e) {
            e.printStackTrace( );
        }
        return null;
    }

    public ApplicationContext getAc() {
        return ac;
    }

    public void setAc(ApplicationContext ac) {
        this.ac = ac;
    }
}
