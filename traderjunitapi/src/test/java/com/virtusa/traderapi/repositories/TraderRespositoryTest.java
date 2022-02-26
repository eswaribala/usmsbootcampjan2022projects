package com.virtusa.traderapi.repositories;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.virtusa.traderapi.models.FullName;
import com.virtusa.traderapi.models.Trader;
import com.virtusa.traderapi.services.TraderService;

@SpringBootTest
public class TraderRespositoryTest {
    @Mock
	private TraderRepo traderRepo;
    @InjectMocks
    private TraderService traderService;	
    @BeforeEach
    public void createMockResponse() {
    	Trader trader=new Trader();
    	trader.setTraderId(935798);
    	trader.setName(new FullName("Trader1","",""));
    	trader.setDob(LocalDate.of(1987, 2, 2));
    	trader.setEmail("trader1@gmail.com");
    	trader.setTradingLimit(450743);
    	trader.setBank(null);
    	//stub--preconfigured response
    	Optional<Trader> traderObj=Optional.of(trader);
    	when(traderRepo.findById(3568036L)).thenReturn(traderObj);
    	
    }
    
    @Test
    public void testTraderMailId() {
    	assertEquals("trader1@gmail.com",traderService.getTraderById(3568036).getEmail());
    }
    
    
}
