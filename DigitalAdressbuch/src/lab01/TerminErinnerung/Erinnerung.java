package lab01.TerminErinnerung;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Erinnerung extends TerminErinnerung {
	private boolean erledigt = false;

	public Erinnerung(String title) {
		this.setTitel(title);
	}

	public JPanel createEPanel() {
		JPanel ePanel = new JPanel();
		ePanel.add(new JLabel(this.getTitel()));
		ePanel.setSize(100, 100);
		return ePanel;
	}

	public boolean isErledigt() {
		return erledigt;
	}

	public void setErledigt(boolean erledigt) {
		this.erledigt = erledigt;
	}

}
