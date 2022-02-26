package com.virtusa.traderapi;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.virtusa.traderapi.controllers.TraderController;

@ExtendWith(SpringExtension.class)
public class TraderControllerTest {

	@Autowired
	private TraderController traderController;
	
	@Test
	public void contextLoads() {
		Assertions.assertThat(traderController).isNot(null);
	}
}
