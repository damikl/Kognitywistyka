package pl.edu.uj.kognitywistyka.visitor;

import java.util.ArrayList;

public class UserInfo implements Storable {
	private String email;
	private String firstName;
	private String lastName;
	private String company;
	private String position;
	private String city;
	private String state;
	private String trade;
	private String companyDescription;
	private String password;
	private String type;

	private ArrayList<StoredItem> clipboard;
	private ArrayList<Announcement> orders;
	private ArrayList<Announcement> offers;

	public UserInfo() {
		clipboard = new ArrayList<StoredItem>();
	}

	public UserInfo(String email, String firstName, String lastName,
			String company, String position, String city, String state,
			String trade, String companyDescription, String type,
			ArrayList<StoredItem> clipboard, ArrayList<Announcement> orders,
			ArrayList<Announcement> offers) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.company = company;
		this.position = position;
		this.city = city;
		this.state = state;
		this.trade = trade;
		this.companyDescription = companyDescription;
		this.type = type;
		this.clipboard = clipboard;
		this.orders = orders;
		this.offers = offers;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getTrade() {
		return trade;
	}

	public void setTrade(String trade) {
		this.trade = trade;
	}

	public String getCompanyDescription() {
		return companyDescription;
	}

	public void setCompanyDescription(String companyDescription) {
		this.companyDescription = companyDescription;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public ArrayList<StoredItem> getClipboard() {
		return clipboard;
	}

	public void setStoredItem(StoredItem item) {
		clipboard.add(item);
	}

	public ArrayList<Announcement> getOrders() {
		return orders;
	}

	public void setOrder(Announcement order) {
		orders.add(order);
	}

	public ArrayList<Announcement> getOffers() {
		return offers;
	}

	public void setOffer(Announcement offer) {
		offers.add(offer);
	}

	@Override
	public String getDisplayedName() {
		return getFirstName() + " " + getLastName();
	}

	@Override
	public String getType() {
		return type;
	}

}
