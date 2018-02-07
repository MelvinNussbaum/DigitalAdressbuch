package lab01.Listener;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import lab01.View.ErinnerungBearbeitenView;

public class JButtonListener implements ActionListener {
	
	private final Object object;

	public JButtonListener(Object object) {
		this.object = object;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Neue Erinnerung")) {
			new ErinnerungBearbeitenView().setVisible(true);
		}
		else if (e.getActionCommand().equals("Fertig")) {
			((Window) object).dispose();
		}
	}

}
