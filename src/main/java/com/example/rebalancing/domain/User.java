package com.example.rebalancing.domain;

import com.example.rebalancing.Util;
import com.example.rebalancing.contanct.Constant;

import java.util.Arrays;
import java.util.List;

public class User {
	private Float purchaseAmount;
	private Float evaluationAmount;
	private Float cash;
	private int amount;
	private List<Integer> sellList;

	public User(Float price, Float cash) {
		this.amount = (int)Math.floor(cash / price);
		this.purchaseAmount = price * amount;
		this.evaluationAmount = purchaseAmount;
		this.cash = cash - purchaseAmount;
		setSellList();
	}

	private void setSellList() {
		int sellAmount = (int) (this.amount * Constant.SELL_RATIO);
		this.sellList = Arrays.asList(sellAmount, sellAmount, sellAmount, sellAmount, sellAmount, sellAmount, sellAmount, sellAmount, sellAmount, sellAmount);
	}

	public Float getMeanPrice() {
		return Util.getFloorPrice(purchaseAmount / amount);
	}

	/**
	 * 전량 매수
	 */
	public void buyStock(Float price, int amount) {
		if (cash >= price * amount) {
			this.purchaseAmount += price * amount;
			this.amount += amount;
			this.cash -= price * amount;
			setSellList();
		}
	}

	public void sellStock(Float price, int amount) {
		int sellAmount = Math.min(this.amount, amount);
		this.purchaseAmount -= price * sellAmount;
		this.amount -= sellAmount;
		this.cash += price * sellAmount;
	}

	/**
	 * 구매 가능한 최대 주식 수
	 */
	public int getMaximumAmount(Float price) {
		if (cash >= price) {
			return (int)(cash / price);
		}
		return 0;
	}

	/**
	 * 매도해야 하는 주식 수
	 */
	public int getAmountByChange(Float change) {
		int sellIdx = getSellIdxByChange(change);
		if (sellIdx < 0) {
			return 0;
		}
		int result = 0;
		for (int i = 0; i < sellList.size() && i <= sellIdx; i++) {
			result += sellList.get(i);
			sellList.set(i, 0);
		}
		return result;
	}

	private int getSellIdxByChange(Float change) {
		if (change > -Constant.SELL_CHANGE_RATIO) {
			return -1;
		}
		return (int)(Math.abs(change) / Constant.SELL_CHANGE_RATIO) - 1;
	}

	public void updateEvaluationAmount(Float price) {
		this.evaluationAmount = price * amount;
	}

	@Override
	public String toString() {
		return "purchaseAmount=" + purchaseAmount +
				", cash=" + cash +
				", amount=" + amount +
				", sellList=" + sellList;
	}

	public Float getPurchaseAmount() {
		return purchaseAmount;
	}

	public Float getCash() {
		return cash;
	}

	public int getAmount() {
		return amount;
	}

	public Float getEvaluationAmount() {
		return evaluationAmount;
	}
}
