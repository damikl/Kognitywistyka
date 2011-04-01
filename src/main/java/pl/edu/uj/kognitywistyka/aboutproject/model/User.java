package pl.edu.uj.kognitywistyka.aboutproject.model;

import java.sql.Date;

public class User{
	
	private int userId;
	private String login;
	private String password;
	private String email;
	private Date date;
	private String firstName;
	private String lastName;
	private String TytulSpecjalizacja;
	private String NazwaUczelniLabor;
	private String Branza;
	private String Miejscowosc;
	private String Wojewodztwo;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
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
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
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
	public String getTytulSpecjalizacja() {
		return TytulSpecjalizacja;
	}
	public void setTytulSpecjalizacja(String tytulSpecjalizacja) {
		TytulSpecjalizacja = tytulSpecjalizacja;
	}
	public String getNazwaUczelniLabor() {
		return NazwaUczelniLabor;
	}
	public void setNazwaUczelniLabor(String nazwaUczelniLabor) {
		NazwaUczelniLabor = nazwaUczelniLabor;
	}
	public String getBranza() {
		return Branza;
	}
	public void setBranza(String branza) {
		Branza = branza;
	}
	public String getMiejscowosc() {
		return Miejscowosc;
	}
	public void setMiejscowosc(String miejscowosc) {
		Miejscowosc = miejscowosc;
	}
	public String getWojewodztwo() {
		return Wojewodztwo;
	}
	public void setWojewodztwo(String wojewodztwo) {
		Wojewodztwo = wojewodztwo;
	}
	
	
	
}