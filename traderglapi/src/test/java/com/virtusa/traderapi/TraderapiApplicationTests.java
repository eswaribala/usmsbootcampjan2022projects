package com.virtusa.traderapi;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.virtusa.traderapi.models.Trader;

@SpringBootTest
class TraderapiApplicationTests {

	private static Trader trader;
	@BeforeAll
	 static void createTraderInstance() {
		trader=new Trader();
	}
	@Test
	void testTraderInstanceNotNull() {
	 Assert.assertNotNull(trader);
	}

}
