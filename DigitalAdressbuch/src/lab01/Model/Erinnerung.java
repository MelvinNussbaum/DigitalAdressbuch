package lab01.Model;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Erinnerung extends TerminErinnerung {
	private boolean erledigt = false;
	private JPanel ePanel;

	
	public Erinnerung(String title, JPanel southPanel) {
		this.setTitel(title);
		JLabel titelLabel = new JLabel(" " + this.getTitel());
		ePanel = new JPanel(new BorderLayout());
		JPanel checkBoxTeiler = new JPanel();
		CustomCheckBox checkBox = new CustomCheckBox();
		
		checkBoxTeiler.add(checkBox);
 		titelLabel.setFont(new Font("Sans-Serif", Font.PLAIN, 16));
		ePanel.add(titelLabel, BorderLayout.NORTH);
		ePanel.setPreferredSize(new Dimension(southPanel.getWidth() - 70, 50));
		ePanel.setBorder(BorderFactory.createLineBorder(Color.black));
		southPanel.add(checkBoxTeiler);
		southPanel.add(ePanel);
	}

	public boolean isErledigt() {
		return erledigt;
	}

	public void setErledigt(boolean erledigt) {
		this.erledigt = erledigt;
	}

}
