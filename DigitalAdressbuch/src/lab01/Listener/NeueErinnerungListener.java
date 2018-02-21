package lab01.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import DatenbankErinnerung.DBErinnerung;
import lab01.View.ErinnerungBearbeitenView;

public class NeueErinnerungListener implements ActionListener {
	private ErinnerungView view;
	private DBErinnerung erinnerungEntry;

	public NeueErinnerungListener(ErinnerungView view, DBErinnerung erinnerungEntry) {
		this.view = view;
		this.erinnerungEntry = erinnerungEntry;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		ErinnerungBearbeitenView ebView = new ErinnerungBearbeitenView(view, erinnerungEntry, true);
		view.revalidate();
		view.repaint();
		ebView.setVisible(true);
	}

}
