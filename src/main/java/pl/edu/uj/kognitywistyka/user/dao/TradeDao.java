package pl.edu.uj.kognitywistyka.user.dao;

import java.util.List;

import pl.edu.uj.kognitywistyka.user.model.Trade;

public interface TradeDao {
	List<Trade> getTradesList();
}
