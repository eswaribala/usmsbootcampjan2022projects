package com.usbootcamp.stockapi.facades;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
//defining message channel
public interface StockFacade {
   String output="stock-out";
   String input="payment-in";
   @Input(input)
	MessageChannel inChannel();
	@Output(output)
	MessageChannel outChannel();
}
