package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.NullChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.messaging.MessageChannel;

@Configuration
public class FlowConfiguration {

	@Bean
	public MessageChannel inputChannel() {	
		return new DirectChannel();		
	}

	@Bean
	public IntegrationFlow messageFlow(InputHandler handler){
		
		return IntegrationFlows
					.from(inputChannel())
					.handle(handler)
					.get();
	}

}
