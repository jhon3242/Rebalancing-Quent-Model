package com.example.rebalancing;

import com.example.rebalancing.controller.InputController;
import com.example.rebalancing.controller.ParsingController;
import com.example.rebalancing.domain.User;
import com.example.rebalancing.service.RebalancingService;
import com.example.rebalancing.view.OutputView;
import org.assertj.core.api.Assertions;
import org.assertj.core.internal.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.stream.Stream;

public class RebalancingTest {
	private static final String TEST_PATH = "/Users/choewonjun/Documents/coding/project/Rebalancing-Quent-Model/src/main/resources/test.csv";
	private static final String TEST_PATH2 = "/Users/choewonjun/Documents/coding/project/Rebalancing-Quent-Model/src/main/resources/test2.csv";

	@ParameterizedTest
	@MethodSource("generateRebalancingArgument")
	void rebalancingTest(LocalDate endDate, Float profit) {
		ParsingController parsingController = new ParsingController();
		RebalancingService rebalancingService = new RebalancingService();
		parsingController.parsing(TEST_PATH);

		LocalDate startDate = LocalDate.of(2022, 11, 28);
		rebalancingService.initUser(startDate, 10000f);
		UserDto start = rebalancingService.getUserDto();
		OutputView.printUserInfo(start);
		System.out.println();
		rebalancingService.calculate(startDate, endDate);
		UserDto end = rebalancingService.getUserDto();
		OutputView.printUserInfo(end);
		System.out.println();
		Assertions.assertThat(Util.getChange(start.getTotalValue(), end.getTotalValue())).isEqualTo(profit);
	}

	private static Stream<Arguments> generateRebalancingArgument() {
		return Stream.of(
				Arguments.of(LocalDate.of(2022, 12, 14), -0.523f),
				Arguments.of(LocalDate.of(2022, 12, 2), -0.05f),
				Arguments.of(LocalDate.of(2022, 12, 5), -0.185f)
		);
	}

	@ParameterizedTest
	@MethodSource("generateChangStandardRebalancingArgument")
	void changeStandardRebalancingTest(LocalDate endDate, Float profit) {
		ParsingController parsingController = new ParsingController();
		RebalancingService rebalancingService = new RebalancingService();
		parsingController.parsing(TEST_PATH2);

		LocalDate startDate = LocalDate.of(2022, 11, 28);
		rebalancingService.initUser(startDate, 10000f);
		UserDto start = rebalancingService.getUserDto();
		OutputView.printUserInfo(start);
		System.out.println();
		rebalancingService.calculate(startDate, endDate);
		UserDto end = rebalancingService.getUserDto();
		OutputView.printUserInfo(end);
		System.out.println();
		Assertions.assertThat(Util.getChange(start.getTotalValue(), end.getTotalValue())).isEqualTo(profit);
	}

	private static Stream<Arguments> generateChangStandardRebalancingArgument() {
		return Stream.of(
				Arguments.of(LocalDate.of(2022, 12, 14), -0.523f),
				Arguments.of(LocalDate.of(2022, 12, 2), -0.05f),
				Arguments.of(LocalDate.of(2022, 12, 5), -0.185f)
		);
	}
}
