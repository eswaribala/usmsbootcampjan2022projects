package com.virtusa.ribbonlb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.virtusa.ribbonlb.configurations.RibbonConfiguration;

@SpringBootApplication
@RibbonClient(name = "VIRTUSA-RIBBON",configuration = RibbonConfiguration.class)
@EnableEurekaClient
public class RibbonlbApplication {

	public static void main(String[] args) {
		SpringApplication.run(RibbonlbApplication.class, args);
	}
    @Bean 
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
