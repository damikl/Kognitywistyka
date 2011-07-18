package pl.edu.uj.kognitywistyka.request.dao;

import java.util.List;

import pl.edu.uj.kognitywistyka.request.model.Request;

public interface RequestDao {
	void addRequest(Request request);
	void removeRequest(Request request);
	void updateRequest(Request request);
	List<Request> findAllRequests();
	Request getRequest(long Id);
}
