package com.example.rebalancing;

import com.example.rebalancing.domain.User;

public class UserDto {
	private Float purchaseAmount;
	private Float evaluationAmount;
	private Float cash;
	private int amount;

	public UserDto(User user) {
		this.purchaseAmount = user.getPurchaseAmount();
		this.evaluationAmount = user.getEvaluationAmount();
		this.cash = user.getCash();
		this.amount = user.getAmount();
	}

	public Float getTotalValue() {
		return evaluationAmount + cash;
	}

	public int getAmount() {
		return amount;
	}

	public Float getCash() {
		return cash;
	}
}
