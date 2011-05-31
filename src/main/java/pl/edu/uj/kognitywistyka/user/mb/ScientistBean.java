package pl.edu.uj.kognitywistyka.user.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.component.html.HtmlInputHidden;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import pl.edu.uj.kognitywistyka.user.bo.ScientistBo;
import pl.edu.uj.kognitywistyka.user.bo.TradeBo;
import pl.edu.uj.kognitywistyka.user.model.FilterAndSortData;
import pl.edu.uj.kognitywistyka.user.model.Trade;
import pl.edu.uj.kognitywistyka.user.model.User;
import pl.edu.uj.kognitywistyka.util.Predicate;

@ManagedBean
@SessionScoped
public class ScientistBean implements Serializable {
	// TODO: Na podstawie PublicationBean
	private static final long serialVersionUID = 153476492772637L;

	@ManagedProperty(name = "scientistBo", value = "#{scientistBo}")
	private ScientistBo scientistBo;

	@ManagedProperty(name = "tradeBo", value = "#{tradeBo}")
	private TradeBo tradeBo;

	private Long trade = null;
	private List<Trade> allTrades;
	private Map<String, List<User>> map;

	private List<User> usersList;
	private FilterAndSortData<User> filter;

	public void setFilter(FilterAndSortData<User> filter) {
		filter = new FilterAndSortData<User>(new ListDataModel<User>(
				getAllScientist()));
	}
	
	private void setFilter() {
		filter = new FilterAndSortData<User>(new ListDataModel<User>(usersList));
	}

	public void filterBy(final String tradeName) {
		Predicate<User> tradeNamePredicate = new Predicate<User>() {

			@Override
			public boolean apply(User type) {

				for (Trade trade : type.getTrades()) {
					if (trade.getTradeName().equals(tradeName)) {
						return true;
					}
				}
				return false;
			}
		};

		setUsersList();
		setFilter();
		filter.filterBy(tradeNamePredicate);
	}
	
	public void setUsersList(List<User> users)
	{
		this.usersList = this.scientistBo.findAllScientist();
	}
	
	private void setUsersList()
	{
		this.usersList = this.scientistBo.findAllScientist();
	}
	
	public String sortByLastNameAsc() {
		filter.sortBy(new Comparator<User>() {
			public int compare(User n1, User n2) {
				return n1.getLastName().compareTo(n2.getLastName());
			}
		});
		return null;
	}

	public String sortByLastNameDesc() {
		filter.sortBy(new Comparator<User>() {
			public int compare(User n1, User n2) {
				return n2.getLastName().compareTo(n1.getLastName());
			}
		});
		return null;
	}

	public void setScientistBo(ScientistBo scientistBo) {
		this.scientistBo = scientistBo;
	}

	public DataModel<User> getUsersList() {
		if (filter == null) {
			filter = new FilterAndSortData<User>(new ListDataModel<User>(
					getAllScientist()));
		}
		return this.filter;
	}

	public List<User> getAllScientist() {
		if (usersList == null)
			usersList = this.scientistBo.findAllScientist();
		System.out.println(usersList.size());
		return usersList;
	}

	public void setTrade(Long tradeId) {
		this.trade = tradeId;
	}

	public Long getTrade() {
		return trade;
	}

	public List<User> getScientistForSetTrade() {
		if (trade == null) {
			trade = this.getAllTrades().get(0).getTradeId();
		}
		return getScientistFor(trade);
	}

	public List<User> getScientistBy(String tradeName) {
		System.out.println("Input: " + tradeName);
		Trade t = null;
		for (Trade trade : allTrades) {
			if (trade.getTradeName().equals(tradeName)) {
				t = trade;
			}
		}
		if (t == null)
			System.out.println("Znowu ten b³¹d");
		return this.getScientistFor(t.getTradeId());
	}

	public Map<String, List<User>> getMap() {
		if (map == null) {
			map = new TreeMap<String, List<User>>();
			for (Trade trade : getAllTrades()) {
				List<User> userslist = this.getScientistFor(trade.getTradeId());
				map.put(trade.getTradeName(), userslist);
			}
		}
		System.out.println(map.size());
		for (String tradeName : map.keySet()) {
			System.out.println(tradeName);

			for (User user : map.get(tradeName)) {
				System.out.println(user.getLastName());
			}
		}
		return map;
	}

	public List<String> getMapKeys() {
		List<String> ret = new ArrayList<String>();
		for (String s : getMap().keySet())
			ret.add(s);
		return ret;
	}

	public List<User> getScientistFor(Long trade) {
		return scientistBo.findScientistFor(trade);
	}

	public List<Trade> getAllTrades() {
		if (allTrades == null || allTrades.isEmpty())
			allTrades = this.tradeBo.getTradeNamesList();
		return allTrades;
	}

	public User getScientist(long id) {
		return this.scientistBo.getScientist(id);
	}

	private HtmlDataTable dataTable;
	private User dataItem = new User();
	private HtmlInputHidden dataItemId = new HtmlInputHidden();

	public String editDataItem() {
		dataItem = (User) dataTable.getRowData();
		dataItemId.setValue(dataItem.getUserId());
		return "publication";
	}

	public HtmlDataTable getDataTable() {
		if (dataTable == null) {
			HtmlDataTable newdataTable = new HtmlDataTable();
			newdataTable.setRows(50);
			setDataTable(newdataTable);
		}

		return dataTable;
	}

	public User getDataItem() {
		return dataItem;
	}

	public HtmlInputHidden getDataItemId() {
		return dataItemId;
	}

	public void setDataTable(HtmlDataTable dataTable) {
		this.dataTable = dataTable;

	}

	public void setDataItem(User dataItem) {
		this.dataItem = dataItem;
	}

	public void setDataItemId(HtmlInputHidden dataItemId) {
		this.dataItemId = dataItemId;
	}

	public void pageFirst() {
		dataTable.setFirst(0);
	}

	public void pagePrevious() {
		dataTable.setFirst(dataTable.getFirst() - dataTable.getRows());
	}

	public void pageNext() {
		dataTable.setFirst(dataTable.getFirst() + dataTable.getRows());
	}

	public void pageLast() {
		int count = dataTable.getRowCount();
		int rows = dataTable.getRows();
		dataTable.setFirst(count - ((count % rows != 0) ? count % rows : rows));
	}

	public int getCurrentPage() {
		int rows = dataTable.getRows();
		int first = dataTable.getFirst();
		int count = dataTable.getRowCount();
		return (count / rows) - ((count - first) / rows) + 1;
	}

	public int getTotalPages() {
		int rows = dataTable.getRows();
		int count = dataTable.getRowCount();
		return (count / rows) + ((count % rows != 0) ? 1 : 0);
	}

	public void setTradeBo(TradeBo tradeBo) {
		this.tradeBo = tradeBo;
	}

}
