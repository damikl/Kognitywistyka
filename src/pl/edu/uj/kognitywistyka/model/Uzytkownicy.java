package pl.edu.uj.kognitywistyka.model;

import java.sql.Date;

public class Uzytkownicy{
	
	private int Id;
	private String Login;
	private String Haslo;
	private String Email;
	private String Sol;
	private Date DataRejestracji;
	private String Imie;
	private String Nazwisko;
	private String TytulSpecjalizacja;
	private String NazwaUczelniLabor;
	private String Branza;
	private String Miejscowosc;
	private String Wojewodztwo;
	
	public void setId(int Id){
		this.Id = Id;
	}
	
	public int getId(){
		return this.Id;
	}
	
	public void setLogin(String Login){
		this.Login = Login;
	}
	
	public String getLogin(){
		return this.Login;
	}
		
	public void setHaslo(String Haslo){
		this.Haslo = Haslo;
	}
	
	public String getHaslo(){
		return this.Haslo;
	}
	
	public void setEmail(String Email){
		this.Email = Email;
	}
	
	public String getEmail(){
		return this.Email;
	}
	public void setSol(String Sol){
		this.Sol = Sol;
	}
	
	public String getSol(){
		return this.Sol;
	}
		
	public void setDataRejestracji(Date DataRejestracji ){
		this.DataRejestracji = DataRejestracji;
	}
	
	public Date getDataRejestracji(){
		return this.DataRejestracji;
	}
	
	public void setImie(String Imie){
		this.Imie = Imie;
	}
	
	public String getImie(){
		return this.Imie;
	}
	public void setNazwisko(String Nazwisko){
		this.Nazwisko = Nazwisko;
	}
	
	public String getNazwisko(){
		return this.Nazwisko;
	}
	
	public String getTytulSpecjalizacja() {
		return this.TytulSpecjalizacja;
	}

	public void setTytulSpecjalizacja(String TytulSpecjalizacja) {
		this.TytulSpecjalizacja = TytulSpecjalizacja;
	}

	public String getNazwaUczelniLabor() {
		return this.NazwaUczelniLabor;
	}

	public void setNazwaUczelniLabor(String NazwaUczelniLabor) {
		this.NazwaUczelniLabor = NazwaUczelniLabor;
	}

	public String getBranza() {
		return this.Branza;
	}

	public void setBranza(String Branza) {
		this.Branza = Branza;
	}

	public String getMiejscowosc() {
		return this.Miejscowosc;
	}

	public void setMiejscowosc(String Miejscowosc) {
		this.Miejscowosc = Miejscowosc;
	}

	public String getWojewodztwo() {
		return this.Wojewodztwo;
	}

	public void setWojewodztwo(String Wojewodztwo) {
		this.Wojewodztwo = Wojewodztwo;
	}
	
	
}