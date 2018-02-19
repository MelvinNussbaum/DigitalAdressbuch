package lab01.Datenbank.Adresse;


public class DBAdresse {
	
	private int id;
	private String strasse;
	private String postleitzahl;
	private String ort;
	private String land;


	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getStrasse() {
		return strasse;
	}



	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}



	public String getPostleitzahl() {
		return postleitzahl;
	}



	public void setPostleitzahl(String postleitzahl) {
		this.postleitzahl = postleitzahl;
	}



	public String getOrt() {
		return ort;
	}



	public void setOrt(String ort) {
		this.ort = ort;
	}



	public String getLand() {
		return land;
	}



	public void setLand(String land) {
		this.land = land;
	}



	public String toString(){
		String result = "";
		result += this.id + " ";
		result += this.strasse + " ";
		result += this.postleitzahl + " ";
		result += this.ort + " ";
		result += this.land + " ";
		return result;
	}
}