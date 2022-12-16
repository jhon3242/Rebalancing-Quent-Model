package com.example.rebalancing;

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
}
