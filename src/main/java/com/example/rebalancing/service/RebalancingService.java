package com.example.rebalancing.service;

import com.example.rebalancing.UserDto;
import com.example.rebalancing.Util;
import com.example.rebalancing.contanct.Constant;
import com.example.rebalancing.domain.User;
import com.example.rebalancing.repository.StockRepository;
import com.example.rebalancing.view.OutputView;

import java.time.LocalDate;

import static com.example.rebalancing.Util.getRound;
import static com.example.rebalancing.contanct.Constant.BUY_CHANGE_RATIO;
import static com.example.rebalancing.contanct.Constant.SELL_CHANGE_RATIO;

public class RebalancingService {
	private static final StockRepository repository = StockRepository.getInstance();
	private User user;
	private Float STANDARD_PRICE; // 기준이 되는 가격

	public void initUser(LocalDate startDate, Float cash) {
		user = new User(repository.getPrice(repository.getPastDate(startDate)), cash);
		STANDARD_PRICE = repository.getPrice(repository.getPastDate(startDate));
	}

	/**
	 * 퀀트 매매를 하는 함수
	 */
	public void calculate(LocalDate startDate, LocalDate endDate) {
		LocalDate nowDate = startDate;
		Float minPrice = STANDARD_PRICE;
		Float buyPrice = STANDARD_PRICE;
		while (!nowDate.isEqual(endDate)) {
			Float nowPrice = repository.getPrice(nowDate);
			minPrice = Math.min(minPrice, nowPrice);
			Float nowChange = Util.getChange(STANDARD_PRICE, nowPrice); // 표준가로 부터 현재 가격의 변동%
			Float minChange = Util.getChange(STANDARD_PRICE, minPrice); // 표준가로 부터 최소 가격의 변동%
			Float buyChange = Util.getChange(STANDARD_PRICE, buyPrice); // 표준가로 부터 구매 가격의 변동%
			if (isBuyTime(minChange, nowChange) && user.canBuy(nowPrice)) {
				System.out.println(nowDate +"\n매수 : " + nowPrice); // TODO 지울것
				buyStock(nowPrice, user.getMaximumAmount(nowPrice)); // buy
				minPrice = nowPrice;
				buyPrice = nowPrice;

				OutputView.printUserInfo(new UserDto(user));
				System.out.println();
			} else if (isSellTime(buyChange, nowChange, minChange) && user.isFirstSold(getRound(buyChange - nowChange))) {
				System.out.println(nowDate +"\n매도 : " + nowPrice); // TODO 지울것
				Float div = (float) (Math.round((buyChange - nowChange) * 100) / 100.0);
				sellStock(nowPrice, user.getAmountByChange(getRound(buyChange - nowChange))); // sell

				OutputView.printUserInfo(new UserDto(user));
				System.out.println();
			}
			nowDate = repository.getNextDate(nowDate, endDate);
			user.updateEvaluationAmount(nowPrice);

		}
	}

	/**
	 * 매수 해야하는 시점
	 */
	private boolean isBuyTime(Float minChange, Float nowChange) {
		Float div = (float) (Math.round((nowChange - minChange) * 100) / 100.0);
		return Float.compare(div, BUY_CHANGE_RATIO) >= 0;
	}

	public void buyStock(Float price, int amount) {
		user.buyStock(price, amount);
	}

	/**
	 * 매도 해야하는 시점
	 */
	private boolean isSellTime(Float buyChange, Float nowChange, Float minChange) {
		Float div = (float) (Math.round((buyChange - nowChange) * 100) / 100.0);
		return Float.compare(div, SELL_CHANGE_RATIO) >= 0 && minChange >= nowChange;
	}

	public void sellStock(Float price, int amount) {
		user.sellStock(price, amount);
	}

	public UserDto getUserDto() {
		UserDto userDto = new UserDto(user);
		return userDto;
	}
}
