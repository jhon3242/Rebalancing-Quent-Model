package com.example.rebalancing;

import com.example.rebalancing.controller.InputController;
import com.example.rebalancing.controller.ParsingController;
import com.example.rebalancing.domain.User;
import com.example.rebalancing.service.RebalancingService;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class RebalancingTest {

	@Test
	void rebalancingTest() {
		String TEST_PATH = "/Users/choewonjun/Documents/coding/project/Rebalancing-Quent-Model/src/main/resources/test.csv";
		ParsingController parsingController = new ParsingController();
		RebalancingService rebalancingService = new RebalancingService();
		parsingController.parsing(TEST_PATH);
		LocalDate startDate = LocalDate.of(2022, 11, 28);
		LocalDate endDate = LocalDate.of(2022, 12, 14);
		rebalancingService.initUser(startDate, 10000f);
//		System.out.println(rebalancingService.getUser());
		rebalancingService.calculate(startDate, endDate);
//		System.out.println(rebalancingService.getUser());
	}
}
