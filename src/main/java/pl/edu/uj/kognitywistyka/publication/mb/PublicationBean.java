package pl.edu.uj.kognitywistyka.publication.mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.component.html.HtmlInputHidden;

import pl.edu.uj.kognitywistyka.publication.bo.PublicationBo;
import pl.edu.uj.kognitywistyka.publication.model.Publication;

@ManagedBean
@RequestScoped
public class PublicationBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(name = "publicationBo", value = "#{publicationBo}")
	private PublicationBo publicationBo;

	public void setPublicationBo(PublicationBo publicationBo) {
		this.publicationBo = publicationBo;
	}

	public List<Publication> getAllPublication() {
		return publicationBo.findAllPublication();
	}

	public Publication getPublication(long id) {
		return publicationBo.getPublication(id);
	}

    private HtmlDataTable dataTable;
    private Publication dataItem = new Publication();
    private HtmlInputHidden dataItemId = new HtmlInputHidden();

    public String editDataItem() {
        dataItem = (Publication) dataTable.getRowData();
        dataItemId.setValue(dataItem.getPublicationId());
        return "publication";
    }

    public HtmlDataTable getDataTable() {
        return dataTable;
    }
    
    public Publication getDataItem() {
        return dataItem;
    }
    
    public HtmlInputHidden getDataItemId() {
        return dataItemId;
    }
    
    public void setDataTable(HtmlDataTable dataTable) {
        this.dataTable = dataTable;
    }
    
    public void setDataItem(Publication dataItem) {
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
