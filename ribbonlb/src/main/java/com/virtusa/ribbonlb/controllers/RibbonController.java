package com.virtusa.ribbonlb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class RibbonController {

	@Autowired
	private DiscoveryClient discoveryClient;
	@Autowired
	private RestTemplate restTemplate;
	
    @Autowired
    private LoadBalancerClient loadBalancer;   

	@Value("${serviceId}")
	private String serviceId;
	
	@GetMapping("/traders")
    public String getTraders() {
 
      
 
        // (Need!!) eureka.client.fetchRegistry=true
        List<ServiceInstance> instances = this.discoveryClient.getInstances(serviceId);
 
        if (instances == null || instances.isEmpty()) {
            return "No instances for service: " + serviceId;
        }
        String html = "<h2>Instances for Service Id: " + serviceId + "</h2>";
 
        for (ServiceInstance serviceInstance : instances) {
            html += "<h3>Instance :" + serviceInstance.getUri() + "</h3>";
        }
 
        
 
        html += "<br><h4>Call /trader of service: " + serviceId + "</h4>";
 
        try {
            // May be throw IllegalStateException (No instances available)
        	//will pick up any instance based on algorithm
            ServiceInstance serviceInstance = this.loadBalancer.choose(serviceId);
 
            html += "<br>===> Load Balancer choose: " + serviceInstance.getUri();
 
            String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/traders/?version=1.0";
 
            html += "<br>Make a Call: " + url;
            html += "<br>";
 
            String result = restTemplate.getForObject(url, String.class);
 
            html += "<br>Result: " + result;
        } catch (IllegalStateException e) {
            html += "<br>loadBalancer.choose ERROR: " + e.getMessage();
            e.printStackTrace();
        } catch (Exception e) {
            html += "<br>Other ERROR: " + e.getMessage();
            e.printStackTrace();
        }
        return html;
    }

}
