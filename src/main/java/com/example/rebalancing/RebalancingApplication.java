package com.example.rebalancing;

import com.example.rebalancing.controller.MainController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;

public class RebalancingApplication {

	public static void main(String[] args) {
		String s = "12/05/2022";
		String t = "2022-12-05";
		String t2 = "2022-12-06";
		LocalDate of = LocalDate.of(2022, 12, 5);
		LocalDate of2 = LocalDate.of(2022, 12, 6);
		boolean after = of.isBefore(of2);
		System.out.println(after);


//		MainController mainController = new MainController();
//		mainController.run();
	}

}
