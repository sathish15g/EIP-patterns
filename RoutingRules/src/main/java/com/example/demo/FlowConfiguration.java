package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

@Configuration
public class FlowConfiguration {

	@Bean
    public MessageChannel inputChannel(){
        return new DirectChannel();
    }

	
	@Bean
    public MessageChannel bookingSuccessChannel(){
        return new DirectChannel();
    }

	@Bean
    public MessageChannel bookingCancelChannel(){
        return new DirectChannel();
    }

	@Bean
    public MessageChannel bookingPendingChannel(){
        return new DirectChannel();
    }

	

    @Bean
    public IntegrationFlow pendingFlow(){

        return IntegrationFlows.from(bookingPendingChannel())
                .handle( (Message<?> message) ->{
                    System.out.println("MESSAGE RECEIVED "+message+"  STATUS : PENDING");
                }).get();
    }
    
    
    @Bean
    public IntegrationFlow cancelFlow(){

        return IntegrationFlows.from(bookingCancelChannel())
                .handle( (Message<?> message) ->{
                    System.out.println("MESSAGE RECEIVED "+message+"  STATUS : CANCEL");
                }).get();
    }
    
    @Bean
    public IntegrationFlow bookedFlow(){

        return IntegrationFlows.from(bookingSuccessChannel())
                .handle( (Message<?> message) ->{
                    System.out.println("MESSAGE RECEIVED "+message+"  STATUS : SUCCESS");
                }).get();
    }
	
}
