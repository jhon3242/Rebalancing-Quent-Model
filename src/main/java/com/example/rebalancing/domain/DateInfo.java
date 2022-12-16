package com.example.rebalancing.domain;

import com.example.rebalancing.Util;

import java.time.LocalDate;
import java.util.List;

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
		this.date = Util.StringToLocalDate(info.get(DATE_IDX));
		this.price = Float.parseFloat(info.get(PRICE_IDX));
		this.open = Float.parseFloat(info.get(OPEN_IDX));
		this.high = Float.parseFloat(info.get(HIGH_IDX));
		this.low = Float.parseFloat(info.get(LOW_IDX));
		this.vol = info.get(VOL_IDX);
		this.change = info.get(CHANGE_IDX);
	}



	public LocalDate getDate() {
		return date;
	}

	public float getPrice() {
		return price;
	}
}
