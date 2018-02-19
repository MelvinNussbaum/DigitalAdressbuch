package lab01.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import lab01.Model.ErinnerungEntry;
import lab01.View.ErinnerungBearbeitenView;
import lab01.View.ErinnerungView;

public class NeueErinnerungListener implements ActionListener {
	private ErinnerungView view;
	private ErinnerungEntry erinnerungEntry;

	public NeueErinnerungListener(ErinnerungView view, ErinnerungEntry erinnerungEntry) {
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
