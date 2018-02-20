package lab01.Listener;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import lab01.Model.ErinnerungEntry;

public class CheckBoxListener implements ItemListener {
	private ErinnerungEntry entry;

	public CheckBoxListener(ErinnerungEntry entry) {
		this.entry = entry;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		switch (e.getStateChange()) {
		case 1: entry.setErledigt(true); break;
		case 0: entry.setErledigt(false); break;
		default: entry.setErledigt(false); break;
		}
	}
}
