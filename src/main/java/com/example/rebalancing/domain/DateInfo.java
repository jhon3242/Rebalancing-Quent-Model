package com.example.rebalancing.domain;

import com.example.rebalancing.Util;
import com.example.rebalancing.contanct.Constant;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.rebalancing.contanct.Constant.*;

public class DateInfo {
	private LocalDate date;
	private float price;
	private float open;
	private float high;
	private float low;
	private String vol;
	private String change;

	public DateInfo(List<String> info) {
		this.date = convertToDate(parsingDate(info.get(DATE_IDX)));
		this.price = Float.parseFloat(info.get(PRICE_IDX));
		this.open = Float.parseFloat(info.get(OPEN_IDX));
		this.high = Float.parseFloat(info.get(HIGH_IDX));
		this.low = Float.parseFloat(info.get(LOW_IDX));
		this.vol = info.get(VOL_IDX);
		this.change = info.get(CHANGE_IDX);
	}

	/**
	 * "12/05/2022" -> List.of(2022, 12, 5) 타입으로 바꿔주는 함수
	 */
	private List<Integer> parsingDate(String date) {
//		System.out.println("date = " + date);
		String[] split = date.split("/");
		Util.swap(split, 0, 2);
		Util.swap(split, 1, 2);
		return Arrays.stream(split)
				.map(Integer::parseInt)
				.collect(Collectors.toList());
	}

	private LocalDate convertToDate(List<Integer> date) {
		return LocalDate.of(date.get(0), date.get(1), date.get(2));
	}

	public LocalDate getDate() {
		return date;
	}
}
