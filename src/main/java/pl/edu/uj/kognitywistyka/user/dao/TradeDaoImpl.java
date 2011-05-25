package pl.edu.uj.kognitywistyka.user.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import pl.edu.uj.kognitywistyka.user.model.Trade;

public class TradeDaoImpl extends HibernateDaoSupport implements TradeDao{

	@SuppressWarnings("unchecked")
	public List<Trade> getTradesList() {
		return getHibernateTemplate().find("from Trade order by tradeName asc");
	}
}