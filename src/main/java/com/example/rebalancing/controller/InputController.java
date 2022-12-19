package com.example.rebalancing.controller;

import com.example.rebalancing.view.OutputView;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InputController {
	public static String readLine(){
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			return br.readLine();
		} catch (Exception e) {
			OutputView.printError(e);
			return readLine();
		}
	}
}
