package lab01.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import lab01.Model.ErinnerungEntry;
import lab01.View.ErinnerungBearbeitenView;
import lab01.View.ErinnerungView;

public class SafeErinnerungListener implements ActionListener {
	private ErinnerungBearbeitenView view;
	private ErinnerungEntry erinnerungEntry;
	private ErinnerungView eView;
	private boolean isNewEntry;

	public SafeErinnerungListener(ErinnerungBearbeitenView ebView, ErinnerungEntry erinnerungEntry,
			ErinnerungView eView, boolean isNewEntry) {
		this.view = ebView;
		this.eView = eView;
		this.isNewEntry = isNewEntry;
		setErinnerungEntry(erinnerungEntry);
	}

	public void setErinnerungEntry(ErinnerungEntry erinnerungEntry) {
		if (erinnerungEntry == null) {
			// TODO throw Exception
		}
		this.erinnerungEntry = erinnerungEntry;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		erinnerungEntry.setTitel(view.getTitelTF().getText());
		erinnerungEntry.setDateTime(view.getDateTimePicker().getDatePicker().getComponentDateTextField().getText(),
				view.getDateTimePicker().getTimePicker().getComponentTimeTextField().getText());
		view.dispose();
		if (this.isNewEntry) {
			eView.addErinnerungEntry(erinnerungEntry);
		}
		eView.revalidate();
		eView.repaint();
	}
}
