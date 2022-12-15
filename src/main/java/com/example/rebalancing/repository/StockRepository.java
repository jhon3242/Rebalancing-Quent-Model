package com.example.rebalancing.repository;

import com.example.rebalancing.domain.DateInfo;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StockRepository {
	private static final StockRepository instance = new StockRepository();
	Map<LocalDate, DateInfo> repository = new HashMap<>();

	private StockRepository() {};

	public static StockRepository getInstance() {
		return instance;
	}

	public void addNewData(DateInfo info) {
		repository.put(info.getDate(), info);
	}
}
