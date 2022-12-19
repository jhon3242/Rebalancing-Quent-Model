package com.example.rebalancing.controller;

import com.example.rebalancing.contanct.Constant;
import com.example.rebalancing.repository.StockRepository;

public class MainController {
	private static final StockRepository stockRepository = StockRepository.getInstance();
	private static final ParsingController parsingController = new ParsingController();
	private static final RebalancingController rebalancingController = new RebalancingController();

	public void run() {
		parsingController.parsing(Constant.TSLA_PATH);
		rebalancingController.run();
	}


}
