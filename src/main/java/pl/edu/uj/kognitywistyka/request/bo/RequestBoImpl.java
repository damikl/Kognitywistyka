package pl.edu.uj.kognitywistyka.request.bo;

import java.io.Serializable;
import java.util.List;

import pl.edu.uj.kognitywistyka.request.dao.RequestDao;
import pl.edu.uj.kognitywistyka.request.model.Request;

public class RequestBoImpl implements RequestBo, Serializable {

	private static final long serialVersionUID = 20110608L;
	RequestDao requestDao;

	public void setRequestDao(RequestDao requestDao) {
		this.requestDao = requestDao;
	}

	public void addRequest(Request request) {
		requestDao.addRequest(request);
	}

	public void removeRequest(Request request) {
		requestDao.removeRequest(request);
	}

	public void removeRequest(long requestId) {
		for (Request request : findAllRequests()) {
			if (request.getRequestId() == requestId)
				removeRequest(request);
		}
	}

	public void updateRequest(Request request) {
		requestDao.updateRequest(request);
	}

	public List<Request> findAllRequests() {
		return requestDao.findAllRequests();
	}

	public Request getRequest(long requestId) {
		return requestDao.getRequest(requestId);
	}
}
