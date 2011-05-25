package pl.edu.uj.kognitywistyka.user.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Trade implements Serializable{

	private static final long serialVersionUID = 2835082229996970967L;
	private long tradeId;
	private String tradeName;
	private Set<User> users = new HashSet<User>(0);
	
	
	public Trade(){
		
	}
	
	public Trade(String tradeName){
		this.tradeName = tradeName;
	}
	
	
	public long getTradeId() {
		return tradeId;
	}
	public void setTradeId(long tradeId) {
		this.tradeId = tradeId;
	}
	public String getTradeName() {
		return tradeName;
	}
	public void setTradeName(String tradeName) {
		this.tradeName = tradeName;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
	
	
}
