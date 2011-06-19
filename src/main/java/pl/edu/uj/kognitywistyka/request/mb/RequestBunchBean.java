package pl.edu.uj.kognitywistyka.request.mb;

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

import pl.edu.uj.kognitywistyka.request.bo.RequestBo;
import pl.edu.uj.kognitywistyka.request.model.Request;
import pl.edu.uj.kognitywistyka.user.model.FilterAndSortData;

@ManagedBean
@SessionScoped
public class RequestBunchBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5770692808580703852L;

	private List<Request> allRequests;
	
	@ManagedProperty(name="requestBo", value="#{requestBo}")
	RequestBo requestBo;
	
	public List<Request> getRequestList() {
		if(allRequests == null)
			allRequests = requestBo.findAllRequests();
		return allRequests;
	}
	
	private FilterAndSortData<Request> filter;

	public void setFilter(FilterAndSortData<Request> filter) {
		filter = new FilterAndSortData<Request>(new ListDataModel<Request>(
				getRequestList()));
	}
	
	public void reset() {
		filter = new FilterAndSortData<Request>(new ListDataModel<Request>(this.allRequests));
	}
	
	public void setAllRequest(List<Request> requests)
	{
		setAllRequest();
	}
	
	private void setAllRequest()
	{
		this.allRequests = this.requestBo.findAllRequests();
	}
	
	public String sortByCompanyAsc() {
		filter.sortBy(new Comparator<Request>() {
			public int compare(Request n1, Request n2) {
				return n1.getCompany().compareTo(n2.getCompany());
			}
		});
		return null;
	}

	public String sortByCompanyDesc() {
		filter.sortBy(new Comparator<Request>() {
			public int compare(Request n1, Request n2) {
				return n2.getCompany().compareTo(n1.getCompany());
			}
		});
		return null;
	}

	public void setRequestBo(RequestBo requestBo) {
		this.requestBo = requestBo;
	}

	public DataModel<Request> getAllRequests() {
		if (filter == null) {
			filter = new FilterAndSortData<Request>(new ListDataModel<Request>(
					this.getRequestList()));
		}
		return this.filter;
	}

	private HtmlDataTable dataTable;
	private Request dataItem = new Request();
	private HtmlInputHidden dataItemId = new HtmlInputHidden();

	public String editDataItem() {
		dataItem = (Request) dataTable.getRowData();
		dataItemId.setValue(dataItem.getRequestId());
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

	public Request getDataItem() {
		return dataItem;
	}

	public HtmlInputHidden getDataItemId() {
		return dataItemId;
	}

	public void setDataTable(HtmlDataTable dataTable) {
		this.dataTable = dataTable;

	}

	public void setDataItem(Request dataItem) {
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

	
}
