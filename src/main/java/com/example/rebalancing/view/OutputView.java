package com.example.rebalancing.view;

import com.example.rebalancing.contanct.Constant;

public class OutputView {

	public static void printError(Exception e) {
		System.out.println(Constant.ERROR_PREFIX + e);
	}
}
