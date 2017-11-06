package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.NullChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.support.Transformers;
import org.springframework.messaging.MessageChannel;

@Configuration
public class FlowConfiguration {

	@Bean
	public MessageChannel inputChannel(){
		return new DirectChannel();
	}
	
	@Bean
	public MessageChannel outputChannel(){
		return new DirectChannel();
	}
	
	@Bean
	public MessageChannel nullChannel1(){
		return new NullChannel();
	}
	
	@Bean
	public IntegrationFlow transformToJsonString(){
		return IntegrationFlows
				.from(inputChannel())
				.transform(Transformers.toJson())
				.handle("inputServiceHandler","toJson")
				.channel(outputChannel())
				.get();
	}
	
	@Bean
	public IntegrationFlow transformFromJsonString(){
		return IntegrationFlows
				.from(outputChannel())
				.transform(Transformers.fromJson())
				.handle("inputServiceHandler","fromJson")
				.channel(nullChannel1())
				.get();
	}
	
}
