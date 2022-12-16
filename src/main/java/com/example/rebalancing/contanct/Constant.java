package com.example.rebalancing.contanct;

import java.time.LocalDate;

public class Constant {
	public static final String APPL_PATH = "/Users/choewonjun/Documents/coding/project/rebalancing/src/main/resources/AAPL Historical Data.csv";

	//"Date","Price","Open","High","Low","Vol.","Change %"
	public static final int DATE_IDX = 0;
	public static final int PRICE_IDX = 1;
	public static final int OPEN_IDX = 2;
	public static final int HIGH_IDX = 3;
	public static final int LOW_IDX = 4;
	public static final int VOL_IDX = 5;
	public static final int CHANGE_IDX = 6;

	public static final String ERROR_PREFIX = "[ERROR] : ";
	public static final String INPUT_START_DATE_MSG = "시작날을 입력해주세요.";
//	public static final LocalDate START_DATE = LocalDate.of(2014, 1, 15);
}
