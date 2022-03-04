package com.vusbc.globalinsurance.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;


import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class PolicySearchService {

	@Value("${policy.topic.name}")
    private String policyTopicName;
	 @Autowired
	 private KafkaTemplate<String, Long> kafkaTemplate;
	 public void  publishPolicyNo(long policyId) {
	    	
	    
	    	
			ListenableFuture<SendResult<String, Long>> future 
				= this.kafkaTemplate.send(policyTopicName, policyId);
			
			future.addCallback(new ListenableFutureCallback<SendResult<String,Long>>() {
	            @Override
	            public void onSuccess(SendResult<String, Long> result) {
	            	log.info("Sent message: " + policyId 
	            			+ " with offset: " + result.getRecordMetadata().offset());
	            	System.out.println("Sent message: " + policyId
	            			+ " with offset: " + result.getRecordMetadata().offset());
	           // status=true;
	            }
	            

	            @Override
	            public void onFailure(Throwable ex) {
	            	log.error("Unable to send Policy Id : " + policyId, ex);
	              // status=false;
	            }
	       });
			
		}
}
