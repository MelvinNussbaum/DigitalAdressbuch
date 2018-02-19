package lab01.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import lab01.Datenbank.Erinnerung.DBErinnerung;
import lab01.Model.ErinnerungEntry;
import lab01.View.ErinnerungBearbeitenView;
import lab01.View.ErinnerungView;

public class SafeErinnerungListener implements ActionListener {
	private ErinnerungBearbeitenView view;
	private DBErinnerung erinnerungDB;
	private ErinnerungView eView;
	private boolean isNewEntry;

	public SafeErinnerungListener(ErinnerungBearbeitenView ebView, DBErinnerung erinnerungDB,
			ErinnerungView eView, boolean isNewEntry) {
		this.view = ebView;
		this.eView = eView;
		this.isNewEntry = isNewEntry;
		setErinnerungDB(erinnerungDB);
	}

	public void setErinnerungDB(DBErinnerung erinnerungDB) {
		if (erinnerungDB == null) {
			// TODO throw Exception
		}
		this.erinnerungDB = erinnerungDB;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		erinnerungDB.setErinnerungsname((view.getTitelTF().getText()));
		erinnerungDB.setDatum(view.getDateTimePicker().getDatePicker().getComponentDateTextField().getText());
		erinnerungDB.setZeit(view.getDateTimePicker().getTimePicker().getComponentTimeTextField().getText());
		eView.addErinnerungEntry(erinnerungDB, isNewEntry);
		view.dispose();
	}
}
