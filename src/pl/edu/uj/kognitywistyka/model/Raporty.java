package pl.edu.uj.kognitywistyka.model;

import java.sql.Date;

public class Raporty{
	private int Id;
	private String Tytul;
	private Date Data;
	private String Tresc;
	
	public void setId(int Id){
		this.Id = Id;
	}
	
	public int getId(){
		return this.Id;
	}
	
	public void setTytul(String Tytul){
		this.Tytul = Tytul;
	}
	
	public String getTytul(){
		return this.Tytul;
	}
		
	public void setData(Date Data){
		this.Data = Data;
	}
	
	public Date getData(){
		return this.Data;
	}
	
	public void setTresc(String Tresc){
		this.Tresc = Tresc;
	}
	
	public String getTresc(){
		return this.Tresc;
	}
}