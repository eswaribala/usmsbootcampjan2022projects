package com.usbootcamp.camundaorderapi;

import java.time.LocalDate;
import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.usbootcamp.camundaorderapi.models.Order;

/**
 * This is an easy adapter implementation
 * illustrating how a Java Delegate can be used
 * from within a BPMN 2.0 Service Task.
 */
@Component("orderlogger")
public class OrderLoggerDelegate implements JavaDelegate {
 @Autowired
 private RestTemplate restTemplate;	
 @Value("${serviceUrl}")
 private String serviceUrl;
  private final Logger LOGGER = Logger.getLogger(OrderLoggerDelegate.class.getName());
  
   private boolean status;
  public void execute(DelegateExecution execution) throws Exception {
    
    LOGGER.info("\n\n  ... LoggerDelegate invoked by "
            + "activityName='" + execution.getCurrentActivityName() + "'"
            + ", activityId=" + execution.getCurrentActivityId()
            + ", processDefinitionId=" + execution.getProcessDefinitionId()
            + ", processInstanceId=" + execution.getProcessInstanceId()
            + ", businessKey=" + execution.getProcessBusinessKey()
            + ", executionId=" + execution.getId()
            + ", variables=" + execution.getVariables()
            + " \n\n");
    
    Order order = new Order();
    order.setOrderId(Long.parseLong(execution.getVariable("orderId").toString()));    
    order.setOrderAmount(Long.parseLong(execution.getVariable("orderAmount").toString()));
    order.setProductId(Long.parseLong(execution.getVariable("productId").toString()));
    order.setOrderDate(LocalDate.parse(execution.getVariable("dop").toString()));
   
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity request = new HttpEntity<>(order,headers);
    //rest api call
   ResponseEntity<String> response= restTemplate.
     postForEntity(serviceUrl+"orders/?version=1.0",request, String.class);
   LOGGER.info("Response"+response.getBody());
   if(response.getBody().contains("Order Published"))
	   status=true;
   execution.setVariable("status", status);
   
  }

}
