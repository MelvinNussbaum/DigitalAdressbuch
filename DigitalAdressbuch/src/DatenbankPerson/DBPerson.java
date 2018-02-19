package DatenbankPerson;


public class DBPerson {
	
	private int id;
	private String vorname;
	private String nachname;
	private String geschlecht;
	private String telefonnummer;
	private String geburtstag;
	private String email;
	private String profilbild;
	private String notizen;
	
	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getGeschlecht() {
		return geschlecht;
	}

	public void setGeschlecht(String geschlecht) {
		this.geschlecht = geschlecht;
	}

	public String getTelefonnummer() {
		return telefonnummer;
	}

	public void setTelefonnummer(String telefonnummer) {
		this.telefonnummer = telefonnummer;
	}

	public String getGeburtstag() {
		return geburtstag;
	}

	public void setGeburtstag(String geburtstag) {
		this.geburtstag = geburtstag;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProfilbild() {
		return profilbild;
	}

	public void setProfilbild(String profilbild) {
		this.profilbild = profilbild;
	}

	public String getNotizen() {
		return notizen;
	}

	public void setNotizen(String notizen) {
		this.notizen = notizen;
	}

	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getVorname() {
		return vorname;
	}
	
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	

	
	public String toString(){
		String result = "";
		result += this.id + " ";
		result += this.vorname + " ";
		result += this.nachname + " ";
		result += this.geschlecht + " ";
		result += this.telefonnummer + " ";
		result += this.geburtstag + " ";
		result += this.email + " ";
		result += this.profilbild + " ";
		result += this.notizen + " ";
		return result;
	}
}