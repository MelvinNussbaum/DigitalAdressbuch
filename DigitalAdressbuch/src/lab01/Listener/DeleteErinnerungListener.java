package lab01.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import DatenbankErinnerung.DBErinnerung;
import lab01.Model.ErinnerungEntry;
import lab01.View.ErinnerungView;

public class DeleteErinnerungListener implements ActionListener {
	private ErinnerungEntry entry;
	private DBErinnerung erinnerungDB;
	private ErinnerungView eView;
	public DeleteErinnerungListener(ErinnerungEntry entry, DBErinnerung erinnerungDB, ErinnerungView eView) {
			this.entry = entry;
			this.erinnerungDB = erinnerungDB;
			this. eView = eView;
		}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		eView.getPd().deleteErinnerung(erinnerungDB);
		eView.getEntries().remove(entry.getEPanel());
		eView.updateUI();
	}
}
