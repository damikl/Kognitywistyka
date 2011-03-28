package pl.edu.uj.kognitywistyka.model;

import java.sql.Date;

public class OProjekcie{
	private int Id;
	private String Opis;
	private Date Data;
	
	public void setId(int Id){
		this.Id = Id;
	}
	
	public int getId(){
		return this.Id;
	}
	
	public void setOpis(String Opis){
		this.Opis = Opis;
	}
	
	public String getOpis(){
		return this.Opis;
	}
		
	public void setData(Date Data){
		this.Data = Data;
	}
	
	public Date getData(){
		return this.Data;
	}
}