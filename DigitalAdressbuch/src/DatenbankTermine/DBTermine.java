package DatenbankTermine;

public class DBTermine {

	private int id;
	private String datum;
	private String startzeit;
	private String endzeit;
	private String terminname;
	private String farbe;
	private String relevanz;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	public String getStartzeit() {
		return startzeit;
	}

	public void setStartzeit(String startzeit) {
		this.startzeit = startzeit;
	}

	public String getEndzeit() {
		return endzeit;
	}

	public void setEndzeit(String endzeit) {
		this.endzeit = endzeit;
	}

	public String getTerminname() {
		return terminname;
	}

	public void setTerminname(String terminname) {
		this.terminname = terminname;
	}

	public String getFarbe() {
		return farbe;
	}

	public void setFarbe(String farbe) {
		this.farbe = farbe;
	}

	public String getRelevanz() {
		return relevanz;
	}

	public void setRelevanz(String relevanz) {
		this.relevanz = relevanz;
	}

	public String toString() {
		String result = "";
		result += this.id + " ";
		result += this.startzeit + " ";
		result += this.endzeit + " ";
		result += this.terminname + " ";
		result += this.relevanz + " ";
		return result;
	}

}