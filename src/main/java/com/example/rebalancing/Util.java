package com.example.rebalancing;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Util {

	public static void swap(String[] arr, int idx1, int idx2) {
		String tmp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = tmp;
	}

	public static List<String> removeColon(String[] list) {
		return Arrays.stream(list)
				.map(word -> word.substring(1, word.length() - 1))
				.collect(Collectors.toList());
	}

	public static LocalDate StringToLocalDate(String src) {
		return convertToDate(parsingDate(src));
	}

	/**
	 * "12/05/2022" -> List.of(2022, 12, 5) 타입으로 바꿔주는 함수
	 */
	private static List<Integer> parsingDate(String date) {
//		System.out.println("date = " + date);
		String[] split = date.split("/");
		Util.swap(split, 0, 2);
		Util.swap(split, 1, 2);
		return Arrays.stream(split)
				.map(Integer::parseInt)
				.collect(Collectors.toList());
	}

	private static LocalDate convertToDate(List<Integer> date) {
		return LocalDate.of(date.get(0), date.get(1), date.get(2));
	}

	public static Float getChange(Float start, Float end) {
		return (float)Math.round(((end / start) - 1) * 10000) / 10000;
	}

	public static Float getRound(Float target) {
		return (float) (Math.round((target) * 100) / 100.0);
	}

	public static Float getRateDiv(Float dec, Float src) {
		return (float) (Math.round((dec - src) * 100) / 100.0);
	}
}
