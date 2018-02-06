package lab01.TerminErinnerung;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Erinnerung extends TerminErinnerung {
	private boolean erledigt = false;
	private JPanel ePanel;

	
	public Erinnerung(String title, JPanel southPanel) {
		this.setTitel(title);
		ePanel = new JPanel();
		ePanel.add(new JLabel(this.getTitel()));
		ePanel.setPreferredSize(new Dimension(southPanel.getWidth() - 1, 50));
		ePanel.setBorder(BorderFactory.createLineBorder(Color.black));
		southPanel.add(ePanel);
	}

	public boolean isErledigt() {
		return erledigt;
	}

	public void setErledigt(boolean erledigt) {
		this.erledigt = erledigt;
	}

}
