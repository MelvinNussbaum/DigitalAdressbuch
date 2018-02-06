package lab01.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

import lab01.View.ErinnerungBearbeitenView;

public class JButtonListener implements ActionListener {

	public JButtonListener(ErinnerungBearbeitenView erinnerungBerbeitenView) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Neue Erinnerung")) {
			new ErinnerungBearbeitenView().setVisible(true);
		}
	}

}
