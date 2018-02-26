package lab01.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import lab01.Model.WeekCalendar.CalendarEvent;
import lab01.View.CalendarEventEditView;
import lab01.View.KalenderView;

public class CalendarNeuListener implements ActionListener {

	private KalenderView kView;

	public CalendarNeuListener(KalenderView kView) {
		this.kView = kView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Termin hinzufügen")){
			CalendarEvent cEvent = new CalendarEvent(null, null, null, null, null);
			new CalendarEventEditView(cEvent, kView, true);

		}
	}
}
