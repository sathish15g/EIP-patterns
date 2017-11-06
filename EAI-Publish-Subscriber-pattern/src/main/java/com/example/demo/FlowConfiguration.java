package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.messaging.MessageChannel;

@Configuration
public class FlowConfiguration {

	@Bean
	public MessageChannel publishchannel() {
		PublishSubscribeChannel channel = new PublishSubscribeChannel();
		channel.subscribe(new SubscriberOne());
		channel.subscribe(new SubscriberTwo());
		return channel;

	}

	@Bean
	public IntegrationFlow publishFlow() {
		return IntegrationFlows
				.from(publishchannel())
				.log()
				.get();
	}

}
