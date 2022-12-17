package com.example.rebalancing.repository;

import com.example.rebalancing.contanct.Constant;
import com.example.rebalancing.domain.DateInfo;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class StockRepository {
	private static final StockRepository instance = new StockRepository();
	Map<LocalDate, DateInfo> repository = new HashMap<LocalDate, DateInfo>();

	private StockRepository() {}

	public static StockRepository getInstance() {
		return instance;
	}

	public void addNewData(DateInfo info) {
		repository.put(info.getDate(), info);
	}

	public Float getPrice(LocalDate date) {
		return repository.get(date).getPrice();
	}

	public LocalDate getNextDate(LocalDate nowDate, LocalDate endDate) {
		int i = 1;
		while (true) {
			if (repository.containsKey(nowDate.plusDays(i))) {
				return nowDate.plusDays(i);
			}
			if (!nowDate.plusDays(i).isBefore(endDate)) {
				throw new RuntimeException(Constant.ERROR_AFTER_END_DATE);
			}
			i++;
		}
	}

	public LocalDate getPastDate(LocalDate nowDate) {
		int i = 1;
		while (true) {
			if (repository.containsKey(nowDate.minusDays(i))) {
				return nowDate.minusDays(i);
			}
			i++;
		}
	}
}
