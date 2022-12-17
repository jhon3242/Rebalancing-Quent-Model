package com.example.rebalancing.contanct;

public class Constant {
	public static final String APPL_PATH = "/Users/choewonjun/Documents/coding/project/rebalancing/src/main/resources/AAPL Historical Data.csv";

	public static final Float SELL_CHANGE_RATIO = 0.025f; // 판매할 시점 비율
	public static final Float BUY_CHANGE_RATIO = SELL_CHANGE_RATIO * 2; // 구매할 시점 비율
	public static final Float SELL_RATIO = 0.1f; // 판매시 주식 매도 비율

	//"Date","Price","Open","High","Low","Vol.","Change %"
	public static final int DATE_IDX = 0;
	public static final int PRICE_IDX = 1;
	public static final int OPEN_IDX = 2;
	public static final int HIGH_IDX = 3;
	public static final int LOW_IDX = 4;
	public static final int VOL_IDX = 5;
	public static final int CHANGE_IDX = 6;

	public static final String ERROR_PREFIX = "[ERROR] : ";
	public static final String INPUT_START_DATE_MSG = "시작날을 입력해주세요. (MM/DD/YYYY)" ;
	public static final String INPUT_END_DATE_MSG = "종료날을 입력해주세요. (MM/DD/YYYY)" ;
	public static final String INPUT_CASH = "보유 현금을 입력해주세요.";
//	public static final String INPUT_PRICE = "평단 가격을 입력해주세요.";
//	public static final String INPUT_AMOUNT= "주식 개수를 입력해주세요.";
//	public static final LocalDate START_DATE = LocalDate.of(2014, 1, 15);

	public static final String ERROR_AFTER_END_DATE = "범위 내에 거래날이 없습니다.";
	public static final String START_USER_MSG = "매매 시작시 정보";
	public static final String END_USER_MSG = "매매 종료후 정보";
	public static final String EVALUATION_ASSET_MSG = "추정 자산 : ";
	public static final String CASH_ASSET_MSG = "보유 현금 : ";
	public static final String STOCK_AMOUNT_MSG = "보유 주식 수 : ";
	public static final String TOTAL_PROFIT_MSG = "최종 수악률 : ";
}
