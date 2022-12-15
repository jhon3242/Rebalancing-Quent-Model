package com.example.rebalancing.view;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFileView {

	public static List<String> readFile(String path) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(path));
		List<String> readResult = new ArrayList<>();
		while (true) {
			String line = br.readLine();
			if (line == null) {
				break;
			}
			readResult.add(line);
		}
		return readResult;
	}
}
