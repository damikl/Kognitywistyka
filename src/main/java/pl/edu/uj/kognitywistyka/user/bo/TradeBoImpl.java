package pl.edu.uj.kognitywistyka.user.bo;

import java.util.List;

import pl.edu.uj.kognitywistyka.user.dao.TradeDao;
import pl.edu.uj.kognitywistyka.user.model.Trade;


public class TradeBoImpl implements TradeBo {

	private TradeDao tradeDao;
	
	
	public void setTradeDao(TradeDao tradeDao) {
		this.tradeDao = tradeDao;
	}


	public List<Trade> getTradeNamesList(){
		return tradeDao.getTradesList();
	}
}
