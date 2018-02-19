package lab01.Datenbank.Erinnerung;


public class DBErinnerung {
	
	private int id;
	private String zeit;
	private String datum;
	private String erinnerungsname;


	public String toString(){
		String result = "";
		result += this.id + " ";
		result += this.zeit + " ";
		result += this.datum + " ";
		result += this.erinnerungsname + " ";
		return result;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getZeit() {
		return zeit;
	}

	public void setZeit(String zeit) {
		this.zeit = zeit;
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	public String getErinnerungsname() {
		return erinnerungsname;
	}

	public void setErinnerungsname(String erinnerungsname) {
		this.erinnerungsname = erinnerungsname;
	}
}