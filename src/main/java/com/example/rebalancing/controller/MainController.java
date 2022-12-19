package com.example.rebalancing.controller;

import com.example.rebalancing.contanct.Constant;

public class MainController {
	private static final ParsingController parsingController = new ParsingController();
	private static final RebalancingController rebalancingController = new RebalancingController();

	public void run() {
		final String PATH = Constant.TSLA_PATH;
		parsingController.parsing(PATH);
		rebalancingController.run();
	}


}
