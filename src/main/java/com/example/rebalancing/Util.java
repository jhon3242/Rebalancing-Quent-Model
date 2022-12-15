package com.example.rebalancing;

public class Util {

	public static void swap(String[] arr, int idx1, int idx2) {
		String tmp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = tmp;
	}
}
