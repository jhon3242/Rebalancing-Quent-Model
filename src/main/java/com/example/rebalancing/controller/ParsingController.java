package com.example.rebalancing.controller;

import com.example.rebalancing.Util;
import com.example.rebalancing.domain.DateInfo;
import com.example.rebalancing.repository.StockRepository;

import java.util.List;

public class ParsingController {
	private static final StockRepository stockRepository = StockRepository.getInstance();

	public void parsing(List<String> readFile) {
		readFile.remove(0);
		readFile.stream()
				.map(ParsingController::getDateInfo)
				.forEach(stockRepository::addNewData);
	}

	private static DateInfo getDateInfo(String line) {
//		System.out.println("Parsing.getDateInfo");
		List<String> split = Util.removeColon(line.split(","));
		return new DateInfo(split);
	}
}
