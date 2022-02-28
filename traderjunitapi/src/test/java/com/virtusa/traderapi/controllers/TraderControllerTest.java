package com.virtusa.traderapi.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.hamcrest.Matchers;
import com.virtusa.traderapi.controllers.TraderController;
import com.virtusa.traderapi.models.FullName;
import com.virtusa.traderapi.models.Trader;
import com.virtusa.traderapi.services.BankService;
import com.virtusa.traderapi.services.TraderService;


@WebMvcTest
public class TraderControllerTest {

	 @Autowired
	    private MockMvc mockMvc;	  

	    @MockBean
	    TraderService traderService;
	    @MockBean
	    BankService bankService;

	    @Test
		public void getTradersTest() throws Exception
		{
			Mockito.when(traderService.getAllTraders()).thenReturn(getTraders());
			mockMvc.perform(get("/traders/?version=1.0")).andExpect(status().isOk())
			.andExpect(jsonPath("$", Matchers.hasSize(100)))
			.andExpect(jsonPath("$[0].name.firstName", Matchers.startsWith("trader0")));
			
		}

	    //fake mocking
	    private List<Trader> getTraders()
		{
			List<Trader> traderList=new ArrayList<Trader>();
			Trader trader=null;
			for(int i=0;i<100;i++)
			{
				trader=new Trader();
				trader.setTraderId(new Random().nextInt(10000));
				trader.setName(new FullName("trader"+i,"",""));
				trader.setEmail("trader"+1+"@gmail.com");
				trader.setTradingLimit(new Random().nextInt(1000000));
				trader.setDob(LocalDate.of(1900+new Random().nextInt(100),1, 12));
				trader.setBank(null);
				traderList.add(trader);
			}
			
			return traderList;
		}
}
