package pl.edu.uj.kognitywistyka.model;

public class Kadra
{
    private int Id;
    private String Imie;
    private String Nazwisko;
    private String Tytul;
    private String Opis;
    private Stanowiska Stanowisko;
    private String Zdjecie;

    public void setId(int Id){
    	this.Id = Id;
    }
    
    public int getId(){
    	return this.Id;
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
    
    public void setTytul(String Tytul){
    	this.Tytul = Tytul;
    }
    
    public String getTytul(){
    	return this.Tytul;
    }
    
    public void setOpis(String Opis){
    	this.Opis = Opis;
    }
    
    public String getOpis(){
    	return this.Opis;
    }
    
    public void setStanowisko(Stanowiska Stanowisko){
    	this.Stanowisko = Stanowisko;
    }
    
    public Stanowiska getStanowisko(){
    	return this.Stanowisko;
    }
    
    public void setZdjecie(String Zdjecie){
    	this.Zdjecie = Zdjecie;
    }
    
    public String getZdjecie(){
    	return this.Zdjecie;
    }
    
    
    
    
    
    
}