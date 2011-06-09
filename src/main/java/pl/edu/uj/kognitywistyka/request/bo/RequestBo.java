package pl.edu.uj.kognitywistyka.request.bo;

import java.util.List;

import pl.edu.uj.kognitywistyka.request.model.Request;

public interface RequestBo {
	void addRequest(Request request);
	void removeRequest(Request request);
	void removeRequest(long requestId);
	void updateRequest(Request request);
	List<Request> findAllRequests();
	Request getRequest(long requestId);
}
