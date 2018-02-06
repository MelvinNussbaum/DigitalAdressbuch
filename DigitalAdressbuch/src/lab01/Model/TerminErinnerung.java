package lab01.Model;

public abstract class TerminErinnerung {
	private String titel = "Neuer Eintrag";
	private String datetime = null;
	
	
	public String getTitel() {
		return titel;
	}
	public void setTitel(String titel) {
		this.titel = titel;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
}
