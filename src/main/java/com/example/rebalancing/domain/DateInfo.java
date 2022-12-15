package com.example.rebalancing.domain;

import java.time.LocalDate;
import java.util.List;

public class DateInfo {
	private LocalDate date;
	List<Float> info;

	public DateInfo(LocalDate date, List<Float> info) {
		this.date = date;
		this.info = info;
	}

	public LocalDate getDate() {
		return date;
	}
}
