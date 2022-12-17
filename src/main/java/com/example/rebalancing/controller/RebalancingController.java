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
	private static final StockRepository repository = StockRepository.getInstance();
	private static final RebalancingService rebalancingService = new RebalancingService();

	public void run() {
//		LocalDate startDate = Util.StringToLocalDate(inputStartDate());
//		LocalDate endDate = Util.StringToLocalDate(inputEndDate());
//		Float cash = InputView.inputCash();

		LocalDate startDate = LocalDate.of(2022, 1, 3);
		LocalDate endDate = LocalDate.of(2022, 12, 14);
		Float cash = 10000f;

		rebalancingService.initUser(startDate, cash);
		UserDto userDtoStart = rebalancingService.getUserDto();
		OutputView.printUserInfo(userDtoStart);
		rebalancingService.calculate(startDate, endDate);
		UserDto userDtoEnd = rebalancingService.getUserDto();
		OutputView.printTotalResult(userDtoStart, userDtoEnd);

	}


}
