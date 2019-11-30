package com.xxxx.corebanking.lending.config;

import com.xxxx.corebanking.lending.service.jms.LendingOnlineServiceListener;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.SingleConnectionFactory;
import org.springframework.jms.listener.DefaultMessageListenerContainer;

import javax.jms.ConnectionFactory;


@Configuration
@ComponentScan("com.xxxx.corebanking*")
public class MqConfig {

    @Bean(name ="ConnectionFactory")
    public ConnectionFactory getActiveMQConnectionFactory() {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
        factory.setBrokerURL( "tcp://localhost:61617" );
        factory.setUserName( "admin" );
        factory.setPassword( "admin" );

        return factory;
    }

    @Bean(name = "SingleJMSFactory")
    public SingleConnectionFactory getSingleConnectionFactory() {
        SingleConnectionFactory sft = new SingleConnectionFactory();
        sft.setTargetConnectionFactory(getActiveMQConnectionFactory());
        return sft;
    }

    @Bean(name = "InQueue")
    public ActiveMQQueue getInputQueue()
    {
        return new ActiveMQQueue("Lending_Service_IN");
    }

    //consumer

    @Bean(name = "LendingOnlineServiceListner")
    public LendingOnlineServiceListener getListener() {
        return new LendingOnlineServiceListener();
    }

    @Bean
    public DefaultMessageListenerContainer getDefaultMessageListener() {
        DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
        container.setConnectionFactory( getSingleConnectionFactory() );
        container.setMessageListener( getListener() );
        container.setDestination( getInputQueue() );
        return container;
    }

    @Bean
    public DefaultMessageListenerContainer getDefaultMessageListener2() {
        DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
        container.setConnectionFactory( getSingleConnectionFactory() );
        container.setMessageListener( getListener() );
        container.setDestination( getInputQueue() );
        return container;
    }

}
