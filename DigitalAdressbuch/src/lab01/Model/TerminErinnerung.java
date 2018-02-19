package lab01.Model;

public abstract class TerminErinnerung {
	private String titel = "Neuer Eintrag";
	private String date = "";
	private String time = "";
	
	
	public String getTitel() {
		return titel;
	}
	public void setTitel(String titel) {
		this.titel = titel;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
}
