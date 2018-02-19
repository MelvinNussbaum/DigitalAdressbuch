package lab01.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import lab01.Datenbank.Erinnerung.DBErinnerung;
import lab01.Model.ErinnerungEntry;
import lab01.View.ErinnerungBearbeitenView;
import lab01.View.ErinnerungView;

public class EditErinnerungListener implements ActionListener {
	private DBErinnerung erinnerungDB;
	private ErinnerungView eView;

	public EditErinnerungListener(DBErinnerung erinnerungDB, ErinnerungView eView) {
		this.eView = eView;
		setErinnerungEntry(erinnerungDB);
	}

	public void setErinnerungEntry(DBErinnerung erinnerungDB) {
		if (erinnerungDB == null) {
			//TODO throw Exception
		}
		this.erinnerungDB = erinnerungDB;
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ErinnerungBearbeitenView ebView = new ErinnerungBearbeitenView(eView, erinnerungDB, false);
		
		ebView.getTitelTF().setText(erinnerungDB.getErinnerungsname());
		ebView.getDateTimePicker().getTimePicker().getComponentTimeTextField().setText(erinnerungDB.getZeit());
		ebView.getDateTimePicker().getDatePicker().getComponentDateTextField().setText(erinnerungDB.getDatum());
		ebView.setVisible(true);

	}

}
