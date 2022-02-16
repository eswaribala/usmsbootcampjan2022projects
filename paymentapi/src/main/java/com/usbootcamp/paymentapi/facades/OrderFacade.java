package com.usbootcamp.paymentapi.facades;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
//defining message channel
public interface OrderFacade {
   String output="order-out";
	@Output(output)
	MessageChannel outChannel();
}
