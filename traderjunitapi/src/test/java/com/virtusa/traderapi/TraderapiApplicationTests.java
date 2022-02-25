package com.virtusa.traderapi;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.boot.test.context.SpringBootTest;

import com.virtusa.traderapi.models.FullName;
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
	@ParameterizedTest
    @ValueSource(strings = { "user1", "user84587", "test485874" })
    void hasTexts(String firstName) {
		trader.setName(new FullName(firstName,"",""));
        Assert.assertTrue(trader.getName().getFirstName().startsWith("t"));
    }
	

}
