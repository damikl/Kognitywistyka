package pl.edu.uj.kognitywistyka.user.mb;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.component.html.HtmlInputHidden;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import pl.edu.uj.kognitywistyka.user.bo.BusinessmanBo;
import pl.edu.uj.kognitywistyka.user.bo.TradeBo;
import pl.edu.uj.kognitywistyka.user.model.FilterAndSortData;
import pl.edu.uj.kognitywistyka.user.model.Trade;
import pl.edu.uj.kognitywistyka.user.model.User;
import pl.edu.uj.kognitywistyka.util.Predicate;

@ManagedBean
@SessionScoped
public class BusinessmanBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4558450268371941431L;

	@ManagedProperty(name = "businessmanBo", value = "#{businessmanBo}")
	private BusinessmanBo businessmanBo;

	@ManagedProperty(name = "tradeBo", value = "#{tradeBo}")
	private TradeBo tradeBo;
	
	private List<Trade> allTrades;

	private List<User> usersList;
	private FilterAndSortData<User> filter;

	public void setFilter(FilterAndSortData<User> filter) {
		filter = new FilterAndSortData<User>(new ListDataModel<User>(
				this.getAllBusinessman()));
	}
	
	public void reset() {
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
		reset();
		filter.filterBy(tradeNamePredicate);
	}
	
	public void setUsersList(List<User> users)
	{
		this.usersList = this.businessmanBo.findAllBusinessman();
	}
	
	private void setUsersList()
	{
		this.usersList = this.businessmanBo.findAllBusinessman();
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

	public void setBusinessmanBo(BusinessmanBo businessmanBo) {
		this.businessmanBo = businessmanBo;
	}

	public DataModel<User> getUsersList() {
		if (filter == null) {
			filter = new FilterAndSortData<User>(new ListDataModel<User>(
					getAllBusinessman()));
		}
		return this.filter;
	}

	public List<User> getAllBusinessman() {
		if (usersList == null)
			usersList = this.businessmanBo.findAllBusinessman();
		System.out.println(usersList.size());
		return usersList;
	}

	public List<User> getBusinessmanBy(String tradeName) {
		System.out.println("Input: " + tradeName);
		Trade t = null;
		for (Trade trade : allTrades) {
			if (trade.getTradeName().equals(tradeName)) {
				t = trade;
			}
		}
		if (t == null)
			System.out.println("Znowu ten b³¹d");
		return this.getBusinessmanFor(t.getTradeId());
	}

	public List<User> getBusinessmanFor(Long trade) {
		return this.businessmanBo.findBusinessmanFor(trade);
	}

	public List<Trade> getAllTrades() {
		if (allTrades == null || allTrades.isEmpty())
			allTrades = this.tradeBo.getTradeNamesList();
		return allTrades;
	}

	public User getBusinessman(long id) {
		return this.businessmanBo.getBusinessman(id);
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
