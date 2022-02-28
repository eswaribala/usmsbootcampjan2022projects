package com.virtusa.traderapi.controllers;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.tomakehurst.wiremock.junit.WireMockRule;

import com.virtusa.traderapi.models.Trader;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(classes = RestClientDemoApplicationTests.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles(value = "integration")

public class TraderWiremockController {
	@Rule
	public WireMockRule wireMockRule = new WireMockRule(8089); 
	
	  @Autowired
	  private TestRestTemplate testRestTemplate;

	    @Before
	    public void setUp() {
	        mockRemoteService();
	    }

	    @Test
	    public void testAllStudents() {
	        ResponseEntity<List<Trader>> responseEntity = testRestTemplate.exchange("http://localhost:7078/traders/?version=1.0", HttpMethod.GET,null,
	                new ParameterizedTypeReference<List<Trader>>(){}
	        );
	        List<Trader> traderList = responseEntity.getBody();
	        System.out.println("TraderList--->" +traderList.size());
	    }

	    private void mockRemoteService() {
	        stubFor(get(urlEqualTo("/all-traders"))
	                .willReturn(aResponse()
	                        .withStatus(200)
	                        .withHeader("Content-Type", "application/json")
	                        .withBodyFile("response.json")
	                ));
	    }
	    
}
