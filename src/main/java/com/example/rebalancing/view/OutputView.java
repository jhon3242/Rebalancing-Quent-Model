package com.example.rebalancing.view;

import com.example.rebalancing.UserDto;
import com.example.rebalancing.Util;
import com.example.rebalancing.contanct.Constant;

public class OutputView {

	public static void printError(Exception e) {
		System.out.println(Constant.ERROR_PREFIX + e);
	}

	public static void printTotalResult(UserDto start, UserDto end) {
		Float change = Util.getChange(start.getTotalValue(), end.getTotalValue());
		System.out.println(Constant.START_USER_MSG);
		printUserInfo(start);
		System.out.println();

		System.out.println(Constant.END_USER_MSG);
		printUserInfo(end);
		System.out.println();
		System.out.println(Constant.TOTAL_PROFIT_MSG + change * 100 + "%");
	}

	public static void printUserInfo(UserDto userDto) {
		System.out.println(Constant.EVALUATION_ASSET_MSG + userDto.getTotalValue());
		System.out.println(Constant.STOCK_AMOUNT_MSG + userDto.getAmount());
		System.out.println(Constant.CASH_ASSET_MSG + userDto.getCash());
	}
}
