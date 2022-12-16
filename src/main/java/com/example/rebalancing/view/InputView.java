package com.example.rebalancing.view;

import com.example.rebalancing.contanct.Constant;
import com.example.rebalancing.controller.InputController;

public class InputView {
	public static String inputStartDate() {
		System.out.println(Constant.INPUT_START_DATE_MSG);
		return InputController.readLine();
	}

	public static String inputEndDate() {
		System.out.println(Constant.INPUT_END_DATE_MSG);
		return InputController.readLine();
	}

	public static Float inputCash() {
		System.out.println(Constant.INPUT_CASH);
		return Float.parseFloat(InputController.readLine());
	}

//	public static String inputPrice() {
//		System.out.println(Constant.INPUT_PRICE);
//		return InputController.readLine();
//	}
//
//	public static String inputAmount() {
//		System.out.println(Constant.INPUT_AMOUNT);
//		return InputController.readLine();
//	}
}
