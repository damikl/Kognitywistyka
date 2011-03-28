package pl.edu.uj.kognitywistyka.model;

public class Linki{
	private int Id;
	private String Naglowek;
	private String Url;
	private String Opis;
	
	public void setId(int Id){
		this.Id = Id;
	}
	
	public int getId(){
		return this.Id;
	}
	
	public void setNaglowek(String Naglowek){
		this.Naglowek = Naglowek;
	}
	
	public String getNaglowek(){
		return this.Naglowek;
	}
	
	public void setUrl(String Url){
		this.Url = Url;
	}
	
	public String getUrl(){
		return this.Url;
	}
	
	public void setOpis(String Opis){
		this.Opis = Opis;
	}
	
	public String getOpis(){
		return this.Opis;
	}
}