package pl.edu.uj.kognitywistyka.request.mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import pl.edu.uj.kognitywistyka.request.bo.RequestBo;
import pl.edu.uj.kognitywistyka.request.model.Request;

@ManagedBean
@RequestScoped
public class RequestBunchBean implements Serializable{

	private static final long serialVersionUID = 20110608L;
	private List<Request> allRequests;
	
	@ManagedProperty(name="requestBo", value="#{requestBo}")
	private RequestBo requestBo;

	public List<Request> getAllRequests() {
		if(allRequests == null)
			allRequests = requestBo.findAllRequests();
		return allRequests;
	}
	
	public void setAllRequests(List<Request> allRequests) {
		this.allRequests = allRequests;
	}

	public void setRequesBo(RequestBo requestBo) {
		this.requestBo = requestBo;
	}
	
}
