package com.example.rebalancing.view;

import com.example.rebalancing.contanct.Constant;
import com.example.rebalancing.controller.InputController;

public class InputView {
	public static String inputStartDate() {
		System.out.println(Constant.INPUT_START_DATE_MSG);
		return InputController.readLine();
	}
}
