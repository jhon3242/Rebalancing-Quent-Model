package com.example.rebalancing.controller;

import com.example.rebalancing.UserDto;
import com.example.rebalancing.Util;
import com.example.rebalancing.domain.User;
import com.example.rebalancing.repository.StockRepository;
import com.example.rebalancing.service.RebalancingService;
import com.example.rebalancing.view.InputView;
import com.example.rebalancing.view.OutputView;

import java.time.LocalDate;

import static com.example.rebalancing.view.InputView.inputEndDate;
import static com.example.rebalancing.view.InputView.inputStartDate;

public class RebalancingController {
	private static final RebalancingService rebalancingService = new RebalancingService();

	public void run() {
//		콘솔을 통해 입력시 주석 해제
//		LocalDate startDate = Util.StringToLocalDate(inputStartDate());
//		LocalDate endDate = Util.StringToLocalDate(inputEndDate());
//		Float cash = InputView.inputCash();

		LocalDate startDate = LocalDate.of(2021, 1, 4);
		LocalDate endDate = LocalDate.of(2022, 12, 15);
		Float cash = 82800f;

		rebalancingService.initUser(startDate, cash);
		UserDto userDtoStart = rebalancingService.getUserDto();
		OutputView.printUserInfo(userDtoStart);
		System.out.println();

		rebalancingService.calculate(startDate, endDate);
		UserDto userDtoEnd = rebalancingService.getUserDto();
		OutputView.printTotalResult(userDtoStart, userDtoEnd);

	}


}
