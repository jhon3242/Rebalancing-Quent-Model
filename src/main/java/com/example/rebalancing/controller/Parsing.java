package com.example.rebalancing.controller;

import com.example.rebalancing.Util;
import com.example.rebalancing.contanct.Constant;
import com.example.rebalancing.domain.DateInfo;
import com.example.rebalancing.repository.StockRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.rebalancing.contanct.Constant.DATE_IDX;

public class Parsing {
	StockRepository stockRepository = StockRepository.getInstance();

	public void parsing(List<String> readFile) {
		readFile.remove(0);

		readFile.stream()
				.map(Parsing::getDateInfo)
				.forEach(dateInfo -> stockRepository.addNewData(dateInfo));
	}

	private static DateInfo getDateInfo(String line) {
		String[] split = line.split(",");
		LocalDate localDate = convertToDate(parsingDate(split[DATE_IDX]));
		List<Float> info = getInfo(split);
		return new DateInfo(localDate, info);
	}

	private static List<Float> getInfo(String[] split) {
		List<String> splitList = new ArrayList<>(Arrays.asList(split));
		splitList.remove(DATE_IDX);
		return splitList.stream().map(Float::parseFloat).collect(Collectors.toList());
	}


	/**
	 * "12/05/2022" -> List.of(2022, 12, 5) 타입으로 바꿔주는 함수
	 */
	private static List<Integer> parsingDate(String date) {
		String[] split = date.split("/");
		Util.swap(split, 0, 2);
		return Arrays.stream(split)
				.map(Integer::parseInt)
				.collect(Collectors.toList());
	}

	private static LocalDate convertToDate(List<Integer> date) {
		return LocalDate.of(date.get(0), date.get(1), date.get(2));
	}
}
