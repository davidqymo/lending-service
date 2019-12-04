package com.xxxx.corebanking.lending.config;

import com.xxxx.corebanking.lending.service.message.LendingOnlineServiceListener;
import com.xxxx.corebanking.lending.service.message.support.MessageHandlerFactory;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.pool.PooledConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.stereotype.Component;

import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;


@Component
public class MqConfig {

    @Autowired
    ApplicationContext ac;

    @Bean(name = "ConnectionFactory")
    public ConnectionFactory getActiveMQConnectionFactory() {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory( );
        factory.setBrokerURL( "tcp://localhost:61617" );
        factory.setUserName( "admin" );
        factory.setPassword( "admin" );
        return factory;
    }


    @Bean(name = "poolConnectionFactory")
    public PooledConnectionFactory getPoolConnectionFactory() {
        PooledConnectionFactory pooledConnectionFactory = new PooledConnectionFactory( );
        pooledConnectionFactory.setConnectionFactory( getActiveMQConnectionFactory( ) );
        pooledConnectionFactory.setMaxConnections( 20 );
        return pooledConnectionFactory;
    }

    @Bean(name = "InQueue")
    public ActiveMQQueue getInputQueue() {
        return new ActiveMQQueue( "Lending_Service_IN" );
    }

    //consumer

    @Bean("JmsTemplate")
    public JmsTemplate getTemplate() {
        JmsTemplate template = new JmsTemplate( );
        template.setConnectionFactory( getPoolConnectionFactory( ) );
        template.setDeliveryMode( DeliveryMode.NON_PERSISTENT );
        return template;
    }

    @Bean
    public MessageHandlerFactory getMessageHandlerFactory() {
        MessageHandlerFactory factory = new MessageHandlerFactory( );
        factory.setAc( ac );
        factory.init( );
        return factory;
    }


    @Bean
    public LendingOnlineServiceListener getLendingOnlineServiceListener() {
        LendingOnlineServiceListener lendingOnlineServiceListener = new LendingOnlineServiceListener( );
        lendingOnlineServiceListener.setFactory( getMessageHandlerFactory( ) );
        lendingOnlineServiceListener.setTemplate( getTemplate( ) );
        return lendingOnlineServiceListener;
    }

    @Bean
    public DefaultMessageListenerContainer getDefaultMessageListener() {
        DefaultMessageListenerContainer container = new DefaultMessageListenerContainer( );
        container.setConnectionFactory( getPoolConnectionFactory( ) );
        container.setMessageListener( getLendingOnlineServiceListener( ) );
        container.setDestination( getInputQueue( ) );
        return container;
    }

}
