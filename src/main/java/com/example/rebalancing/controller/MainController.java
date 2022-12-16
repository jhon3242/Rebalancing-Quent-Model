package com.example.rebalancing.controller;

import com.example.rebalancing.contanct.Constant;
import com.example.rebalancing.repository.StockRepository;
import com.example.rebalancing.view.OutputView;
import com.example.rebalancing.view.ReadFileView;

import java.util.List;

public class MainController {
	private static final StockRepository stockRepository = StockRepository.getInstance();
	private static final ParsingController parsingController = new ParsingController();

	public void run() {
		parsingController.parsing(readFile());
	}

	private List<String> readFile() {
		try {
			return ReadFileView.readFile(Constant.APPL_PATH);
		} catch (Exception e) {
			OutputView.printError(e);
			return null;
		}
	}
}
