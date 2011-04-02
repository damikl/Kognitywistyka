package pl.edu.uj.kognitywistyka.aboutproject.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import pl.edu.uj.kognitywistyka.aboutproject.model.Position;



public class PositionDaoImpl extends HibernateDaoSupport
	implements PositionDao{

	@SuppressWarnings("unchecked")
	public List<Position> findAllPositions() {
		return getHibernateTemplate().find("from Position");
	}
	


}