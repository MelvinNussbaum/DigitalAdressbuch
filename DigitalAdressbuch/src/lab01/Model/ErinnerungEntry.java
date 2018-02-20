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

import DatenbankErinnerung.DBErinnerung;
import lab01.Listener.CheckBoxListener;
import lab01.Listener.DeleteErinnerungListener;
import lab01.Listener.EditErinnerungListener;
import lab01.View.ErinnerungView;

public class ErinnerungEntry extends TerminErinnerung {
	private boolean erledigt = false;
	private static final Icon smallDeleteIcon = ErinnerungView.loadIcon("smallDeleteIcon.png");
	private JPanel ePanel;
	
	private JLabel titelLabel;
	private JLabel datetimeLabel;
	
	private CustomCheckBox checkBox;
	private DBErinnerung erinnerungDB;
	private ErinnerungView eView;
	
	
	public ErinnerungEntry(ErinnerungView eView, DBErinnerung erinnerungDB) {
		this.eView = eView;
		this.erinnerungDB = erinnerungDB;
		titelLabel = new JLabel(erinnerungDB.getErinnerungsname());
		datetimeLabel = new JLabel(erinnerungDB.getDatum() + ", " + erinnerungDB.getZeit());
		JPanel erinnerungLabelPanel = new JPanel(new BorderLayout());
		ePanel = new JPanel(new BorderLayout());
		JPanel checkBoxTeiler = new JPanel();
		JButton deleteButton = new JButton(smallDeleteIcon);
		checkBox = new CustomCheckBox();
		
 		titelLabel.setFont(new Font("Sans-Serif", Font.BOLD, 18));
 		datetimeLabel.setFont(new Font("Sans-Serif", Font.PLAIN, 15));
 		deleteButton.setVerticalTextPosition(SwingConstants.BOTTOM);
 		deleteButton.setHorizontalTextPosition(SwingConstants.CENTER);
 		deleteButton.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 0, Color.LIGHT_GRAY));
 		deleteButton.setOpaque(false);
 		deleteButton.setContentAreaFilled(false);
 		deleteButton.setPreferredSize(new Dimension(40, 40));
 		deleteButton.setActionCommand("edit");
 		deleteButton.addActionListener(new DeleteErinnerungListener(this, erinnerungDB, eView));
 		
 		checkBox.addItemListener(new CheckBoxListener(this));
 		checkBoxTeiler.add(checkBox);
 		ePanel.setBorder(BorderFactory.createRaisedBevelBorder());
 		ePanel.setPreferredSize(new Dimension(320, 47));;
		erinnerungLabelPanel.add(titelLabel, BorderLayout.NORTH);
		erinnerungLabelPanel.add(datetimeLabel, BorderLayout.SOUTH);
		erinnerungLabelPanel.setPreferredSize(new Dimension(ePanel.getWidth() - 110, ePanel.getHeight()));
		erinnerungLabelPanel.addMouseListener(new EditErinnerungListener(erinnerungDB, eView, this));
		ePanel.add(checkBoxTeiler, BorderLayout.WEST);
		ePanel.add(erinnerungLabelPanel, BorderLayout.CENTER);
		ePanel.add(deleteButton, BorderLayout.EAST);
	}
	
	public JPanel getEPanel() {
		return ePanel;
	}

	public boolean isErledigt() {
		return erledigt;
	}

	public void setErledigt(boolean erledigt) {
		this.erledigt = erledigt;
		erinnerungDB.setErledigt(erledigt);
		eView.getPd().updateErledigt(erinnerungDB);
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

	public CustomCheckBox getCheckBox() {
		return checkBox;
	}

	public void setCheckBox(CustomCheckBox checkBox) {
		this.checkBox = checkBox;
	}
}
