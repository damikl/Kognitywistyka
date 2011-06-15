package pl.edu.uj.kognitywistyka.request.mb;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import pl.edu.uj.kognitywistyka.request.bo.RequestBo;
import pl.edu.uj.kognitywistyka.request.model.Request;

@ManagedBean
@RequestScoped
public class RequestBean implements Serializable {

	private static final long serialVersionUID = 20110608L;
	private long requestId;
	private String title;
	private Date date;
	private String company;
	private String person;
	private String tags;
	private String content;
	
	private List<Request> allRequests;
	
	// Dependency injection
	@ManagedProperty(name="requestBo", value="#{requestBo}")
	RequestBo requestBo;
	
	@PostConstruct
	@SuppressWarnings("unused")
	private void init() {
		Map<String, String> requestMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String requestId = requestMap.get("requestid");
		if(requestId != null)
			preinitializeBean(new Long(requestId));
	}
	
	private void preinitializeBean(long requestId) {
		Request request = requestBo.getRequest(requestId);
		if(request != null) {
			this.requestId = request.getRequestId();
			this.title = request.getTitle();
			this.date = request.getDate();
			this.company = request.getCompany();
			this.person = request.getPerson();
			this.tags = request.getTags();
			this.content = request.getContent();
		}
	}
	
	public List<Request> getAllRequests() {
		if(allRequests == null)
			allRequests = requestBo.findAllRequests();
		return allRequests;
	}
	
	public long getRequestId() {
		return requestId;
	}

	public void setRequestId(long requestId) {
		this.requestId = requestId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}
	
	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setRequestBo(RequestBo requestBo) {
		this.requestBo = requestBo;
	}
	
//	public void setRequestBunchBean(RequestBunchBean requestBunchBean) {
//		this.requestBunchBean = requestBunchBean;
//	}
	
	public String addRequest() {
		Request request = new Request();
		request.setTitle(title);
		request.setDate(new Date());
		request.setCompany(company);
		request.setPerson(person);
		request.setTags(tags);
		request.setContent(content);
		
		requestBo.addRequest(request);
		
		resetView();
		return "";
	}
	
	public String updateRequest() {
		Request request = new Request();
		request.setTitle(title);
		request.setDate(date);
		request.setCompany(company);
		request.setPerson(person);
		request.setTags(tags);
		request.setContent(content);
		
		requestBo.updateRequest(request);
		
		resetView();
		return "success";
	}
	
	public String removeRequest(long requestId) {
		requestBo.removeRequest(requestId);
		
		resetView();
		return "";
	}

	private void resetView() {
		setRequestId(0);
		setContent("");
		setDate(null);
		setTitle("");
	}
}
