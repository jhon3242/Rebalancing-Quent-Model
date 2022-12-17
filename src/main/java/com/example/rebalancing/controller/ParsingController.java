package com.example.rebalancing.controller;

import com.example.rebalancing.Util;
import com.example.rebalancing.domain.DateInfo;
import com.example.rebalancing.repository.StockRepository;
import com.example.rebalancing.view.OutputView;
import com.example.rebalancing.view.ReadFileView;

import java.util.List;

public class ParsingController {
	private static final StockRepository stockRepository = StockRepository.getInstance();

	public void parsing(String path) {
		List<String> readFile = readFile(path);
		readFile.remove(0);
		readFile.stream()
				.map(ParsingController::getDateInfo)
				.forEach(stockRepository::addNewData);
	}

	private static DateInfo getDateInfo(String line) {
		List<String> split = Util.removeColon(line.split(","));
		return new DateInfo(split);
	}

	private List<String> readFile(String path) {
		try {
			return ReadFileView.readFile(path);
		} catch (Exception e) {
			OutputView.printError(e);
			return null;
		}
	}
}
