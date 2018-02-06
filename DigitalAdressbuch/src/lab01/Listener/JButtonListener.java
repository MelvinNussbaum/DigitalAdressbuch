package lab01.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

import lab01.TerminErinnerung.view.ErinnerungBerbeitenView;

public class JButtonListener implements ActionListener {

	public JButtonListener(ErinnerungBerbeitenView erinnerungBerbeitenView) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Neue Erinnerung")) {
			new ErinnerungBerbeitenView().setVisible(true);
		}
	}

}
