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

import lab01.Datenbank.Erinnerung.DBErinnerung;
import lab01.Listener.EditErinnerungListener;
import lab01.View.ErinnerungView;

public class ErinnerungEntry extends TerminErinnerung {
	private boolean erledigt = false;
	private static final Icon editIcon = ErinnerungView.loadIcon("editIcon.png");
	private JPanel ePanel;
	
	private JLabel titelLabel;
	private JLabel datetimeLabel;
	private DBErinnerung erinnerungDB;
	

	public ErinnerungEntry(ErinnerungView eView, DBErinnerung erinnerungDB) {
		this.erinnerungDB = erinnerungDB;
		titelLabel = new JLabel(erinnerungDB.getErinnerungsname());
		datetimeLabel = new JLabel(erinnerungDB.getDatum() + ", " + erinnerungDB.getZeit());
		JPanel erinnerungLabelPanel = new JPanel(new BorderLayout());
		ePanel = new JPanel(new BorderLayout());
		JPanel checkBoxTeiler = new JPanel();
		JButton editButton = new JButton(editIcon);
		CustomCheckBox checkBox = new CustomCheckBox();
		
 		titelLabel.setFont(new Font("Sans-Serif", Font.BOLD, 18));
 		datetimeLabel.setFont(new Font("Sans-Serif", Font.PLAIN, 15));
 		editButton.setVerticalTextPosition(SwingConstants.BOTTOM);
 		editButton.setHorizontalTextPosition(SwingConstants.CENTER);
 		editButton.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 0, Color.LIGHT_GRAY));
 		editButton.setOpaque(false);
 		editButton.setContentAreaFilled(false);
 		editButton.setPreferredSize(new Dimension(40, 40));
 		editButton.setActionCommand("edit");
 		editButton.addActionListener(new EditErinnerungListener(erinnerungDB, eView));
 		
 		checkBoxTeiler.add(checkBox);
 		ePanel.setBorder(BorderFactory.createRaisedBevelBorder());
 		ePanel.setPreferredSize(new Dimension(320, 47));;
//		ePanel.setPreferredSize(new Dimension(300, 50));
		erinnerungLabelPanel.add(titelLabel, BorderLayout.NORTH);
		erinnerungLabelPanel.add(datetimeLabel, BorderLayout.SOUTH);
		erinnerungLabelPanel.setPreferredSize(new Dimension(ePanel.getWidth() - 110, ePanel.getHeight()));
		ePanel.add(checkBoxTeiler, BorderLayout.WEST);
		ePanel.add(erinnerungLabelPanel, BorderLayout.CENTER);
		ePanel.add(editButton, BorderLayout.EAST);
	}
	
	public JPanel getEPanel() {
		return ePanel;
	}

	public boolean isErledigt() {
		return erledigt;
	}

	public void setErledigt(boolean erledigt) {
		this.erledigt = erledigt;
	}
	
	@Override
	public void setTitel(String titel) {
		super.setTitel(titel);
		titelLabel.setText(titel);
		
	}
	
	public void setDateTime(String date, String time) {
		super.setDate(date);
		super.setTime(time);
		datetimeLabel.setText(date + ", " + time);
	}

	public DBErinnerung getErinnerungDB() {
		return erinnerungDB;
	}

	public void setErinnerungDB(DBErinnerung erinnerungDB) {
		this.erinnerungDB = erinnerungDB;
	}
}
