package pl.edu.uj.kognitywistyka.user.mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.component.html.HtmlInputHidden;

import pl.edu.uj.kognitywistyka.user.bo.ScientistBo;
import pl.edu.uj.kognitywistyka.user.bo.TradeBo;
import pl.edu.uj.kognitywistyka.user.model.Trade;
import pl.edu.uj.kognitywistyka.user.model.User;

@ManagedBean
@RequestScoped
public class ScientistBean implements Serializable{
	//TODO: Na podstawie PublicationBean
	private static final long serialVersionUID = 153476492772637L;
	
	@ManagedProperty(name = "scientistBo", value = "#{scientistBo}")
	private ScientistBo scientistBo;
	
	@ManagedProperty(name = "tradeBo", value = "#{tradeBo}")
	private TradeBo tradeBo;
	
	private Long trade = null;
	
	public void setScientistBo(ScientistBo scientistBo) {
		this.scientistBo = scientistBo;
	}
	
	public List<User> getAllScientist() {
		return this.scientistBo.findAllScientist();
	}
	
	public void setTrade(Long tradeId)
	{
		this.trade = tradeId;
	}
	
	public Long getTrade()
	{
		return trade;
	}
	
	public List<User> getScientistForSetTrade()
	{
		if(trade == null)
		{
			trade = this.getAllTrades().get(0).getTradeId();
		}
		return getScientistFor(trade);
	}
	public List<User> getScientistFor(Long trade)
	{
		return scientistBo.findScientistFor(trade);
	}
	
	public List<Trade> getAllTrades()
	{
		return this.tradeBo.getTradeNamesList();
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
