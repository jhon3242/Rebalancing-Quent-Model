package com.example.rebalancing.controller;

import com.example.rebalancing.contanct.Constant;
import com.example.rebalancing.view.ReadFileView;

import java.util.List;

public class MainController {
	public void run() {
		try {
			List<String> readFile = ReadFileView.readFile(Constant.APPL_PATH);

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
