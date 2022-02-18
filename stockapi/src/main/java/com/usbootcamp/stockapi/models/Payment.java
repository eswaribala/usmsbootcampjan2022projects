package com.usbootcamp.stockapi.models;

import org.springframework.data.annotation.Id;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Payment {
 
	private long transactionId;
	private String transactionDate;	
	private PaymentMode paymentMode;	
	private Order order;
}
