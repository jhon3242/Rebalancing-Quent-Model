package com.example.rebalancing;

import com.example.rebalancing.controller.MainController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;

public class RebalancingApplication {

	public static void main(String[] args) {
		MainController mainController = new MainController();
		mainController.run();
	}

}
