package com.hsbc.corebanking.lending.lendingservice;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class LendingOnlineServiceListener implements MessageListener {

    @Override
    public void onMessage(Message message) {
        TextMessage textMessage=(TextMessage)message;
        try {
            System.out.println("接收消息："+textMessage.getText());
            System.out.println( Thread.currentThread( ).getName() );
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
