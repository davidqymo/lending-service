package com.xxxx.corebanking.lending.service;

import com.xxxx.corebanking.lending.config.PackageConfig;
import com.xxxx.corebanking.lending.service.message.LendingOnlineServiceListener;
import com.xxxx.corebanking.lending.service.message.support.TransactionCode;
import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jms.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PackageConfig.class)
public class MessageProcessorTest {

    @Autowired
    @Qualifier(value = "ConnectionFactory")
    ConnectionFactory connectionFactory;

    @Autowired
    LendingOnlineServiceListener listener;

    @Autowired
    JmsTemplate template;

    @Test
    public void process() throws JMSException {

        StringBuilder sb = new StringBuilder( );
        sb.append( "    " );
        sb.append( TransactionCode.ACCOUNT_OVERVIEW );
        sb.append( "Body" );
        String accountOverviewRequestMessage = sb.toString( );


        final Queue testQueue = new ActiveMQQueue( "Lending_service_OUT" );

        final String ResultAccountOverview = "--->Response from LoanAccountOverview";

        Session session = connectionFactory.createConnection( ).createSession( false, Session.AUTO_ACKNOWLEDGE );

        TextMessage msg = session.createTextMessage( accountOverviewRequestMessage );
        msg.setJMSReplyTo( testQueue );

        listener.onMessage( msg );
        //receive the message
        String result = ((TextMessage) template.receive( testQueue )).getText( );

        System.out.println( "Result is -->" + result );

        Assert.assertEquals( result, ResultAccountOverview );

        //=========================

        final String ResultAccountEnquiry = "--->Response from LoanAccountEnquiry";

        sb = new StringBuilder( );
        sb.append( "    " );
        sb.append( TransactionCode.ACCOUNT_ENQUIRY );
        sb.append( "Body" );
        String accountEnquiryRequestMessage = sb.toString( );

        msg = session.createTextMessage( accountEnquiryRequestMessage );
        msg.setJMSReplyTo( testQueue );
        listener.onMessage( msg );

        //receive the message

        result = ((TextMessage) template.receive( testQueue )).getText( );

        System.out.println( "Result is -->" + result );

        Assert.assertEquals( result, ResultAccountEnquiry );


    }
}
