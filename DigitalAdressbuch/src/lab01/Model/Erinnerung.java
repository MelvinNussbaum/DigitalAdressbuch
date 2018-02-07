package lab01.Model;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.text.html.HTMLDocument.HTMLReader.BlockAction;

import lab01.View.ErinnerungView;

public class Erinnerung extends TerminErinnerung {
	private boolean erledigt = false;
	private static final Icon editIcon = ErinnerungView.loadIcon("editIcon.png");

	
	public Erinnerung(String title, JPanel southPanel) {
		this.setTitel(title);
		this.setDate(getDate());
		this.setTime(getTime());
		JLabel titelLabel = new JLabel(this.getTitel());
		JLabel datetimeLabel = new JLabel(getDate() + ", " + getTime());
		JPanel erinnerungLabelPanel = new JPanel(new BorderLayout());
		JPanel ePanel = new JPanel(new BorderLayout());
		JPanel checkBoxTeiler = new JPanel();
		JButton editButton = new JButton(editIcon);
		CustomCheckBox checkBox = new CustomCheckBox();
		
 		titelLabel.setFont(new Font("Sans-Serif", Font.PLAIN, 18));
 		datetimeLabel.setFont(new Font("Sans-Serif", Font.PLAIN, 16));
 		editButton.setVerticalTextPosition(SwingConstants.BOTTOM);
 		editButton.setHorizontalTextPosition(SwingConstants.CENTER);
 		editButton.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 0, Color.LIGHT_GRAY));
 		editButton.setOpaque(false);
 		editButton.setContentAreaFilled(false);
 		editButton.setPreferredSize(new Dimension(40, 40));
 		
 		
 		
 		checkBoxTeiler.add(checkBox);
 		ePanel.setPreferredSize(new Dimension(southPanel.getWidth(), 48));
 		ePanel.setBorder(BorderFactory.createLoweredBevelBorder());
		erinnerungLabelPanel.add(titelLabel, BorderLayout.NORTH);
		erinnerungLabelPanel.add(datetimeLabel, BorderLayout.SOUTH);
		erinnerungLabelPanel.setPreferredSize(new Dimension(ePanel.getWidth() - 110, ePanel.getHeight()));
		ePanel.add(checkBoxTeiler, BorderLayout.WEST);
		ePanel.add(erinnerungLabelPanel, BorderLayout.CENTER);
		ePanel.add(editButton, BorderLayout.EAST);
		southPanel.add(ePanel);

	}

	public boolean isErledigt() {
		return erledigt;
	}

	public void setErledigt(boolean erledigt) {
		this.erledigt = erledigt;
	}

}
