package lab01.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import lab01.Model.ErinnerungEntry;
import lab01.View.ErinnerungBearbeitenView;
import lab01.View.ErinnerungView;

public class EditErinnerungListener implements ActionListener {
	private ErinnerungEntry erinnerungEntry;
	private ErinnerungView eView;

	public EditErinnerungListener(ErinnerungEntry erinnerungEntry, ErinnerungView eView) {
		this.eView = eView;
		setErinnerungEntry(erinnerungEntry);
	}

	public void setErinnerungEntry(ErinnerungEntry erinnerungEntry) {
		if (erinnerungEntry == null) {
			//TODO throw Exception
		}
		this.erinnerungEntry = erinnerungEntry;
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ErinnerungBearbeitenView ebView = new ErinnerungBearbeitenView(eView, erinnerungEntry, false);
		
		ebView.getTitelTF().setText(erinnerungEntry.getTitel());
		ebView.getDateTimePicker().getTimePicker().getComponentTimeTextField().setText(erinnerungEntry.getTime());
		ebView.getDateTimePicker().getDatePicker().getComponentDateTextField().setText(erinnerungEntry.getDate());
		ebView.setVisible(true);

	}

}
