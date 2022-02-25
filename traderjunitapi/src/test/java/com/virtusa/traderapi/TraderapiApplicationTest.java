package com.virtusa.traderapi;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import com.virtusa.traderapi.models.FullName;
import com.virtusa.traderapi.models.Trader;
import com.virtusa.traderapi.repositories.TraderRepo;

@SpringBootTest
@AutoConfigureTestEntityManager

class TraderapiApplicationTest {
	@Autowired
	private TestEntityManager entityManager;
	 
	@Autowired
	private TraderRepo traderRepo;
	
	private static Trader trader;
	@BeforeAll
	 static void createTraderInstance() {
		trader=new Trader();
	}
	@Test
	@RepeatedTest(5)
	void testTraderInstanceNotNull() {
	 Assert.assertNotNull(trader);
	}
	@ParameterizedTest
    @ValueSource(strings = { "user1", "user84587", "test485874" })
    void hasTexts(String firstName) {
		trader.setName(new FullName(firstName,"",""));
        Assert.assertTrue(trader.getName().getFirstName().startsWith("t"));
    }
	@ParameterizedTest
	@Timeout(unit = TimeUnit.NANOSECONDS,value = 5)
    @CsvFileSource(resources = "./trader2022.csv", numLinesToSkip = 1)
    void testWithCsvFileSource(String firstName, String lastName) {
		trader.setName(new FullName(firstName,"",lastName));
        Assert.assertTrue(trader.getName().getFirstName().length()>5);
    }

	//test db level transaction
	@Test
	@DisplayName("Trader test with db")
	@Transactional
	void whenFindByTraderId_thenReturnTrader() {
		//Given
		trader.setBank(null);
		trader.setDob(LocalDate.of(1980, 1, 1));
		trader.setEmail("trader@gmail.com");
		trader.setName(new FullName("trader","",""));
		trader.setTradingLimit(49735697);
	    entityManager.persist(trader);
	    entityManager.flush();
	 
	    // when
	   Trader found = traderRepo.findTraderByEmail(trader.getEmail());
	 
	    // then
	    Assert.assertEquals(found.getDob(),trader.getDob());
	}
	
}
