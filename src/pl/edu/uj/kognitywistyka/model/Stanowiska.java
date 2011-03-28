package pl.edu.uj.kognitywistyka.model;

public class Stanowiska{
	private int Id;
	private String Nazwa;
	
	public void setId(int Id){
		this.Id = Id;
	}
	
	public int getId(){
		return this.Id;
	}
	
	public void setNazwa(String Nazwa){
		this.Nazwa = Nazwa;
	}
	
	public String getNazwa(){
		return this.Nazwa;
	}
}