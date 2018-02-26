package lab01.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import DatenbankTermine.DBTermine;
import lab01.Model.WeekCalendar.CalendarEvent;
import lab01.View.CalendarEventEditView;
import lab01.View.KalenderView;

public class CalendarSafeListener implements ActionListener {
	private DBTermine terminDB;
	private CalendarEvent cEvent;
	private CalendarEventEditView editView;
	private KalenderView kView;
	private boolean isNewEntry;

	public CalendarSafeListener(DBTermine terminDB, CalendarEvent cEvent, CalendarEventEditView editView, KalenderView kView, boolean isNewEntry) {
		this.terminDB = terminDB;
		this.cEvent = cEvent;
		this.editView = editView;
		this.kView = kView;
		this.isNewEntry = isNewEntry;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		terminDB.setTerminname(editView.getTitelTF().getText());
		terminDB.setDatum(editView.getDatePicker().getText());
		terminDB.setStartzeit(editView.getStartPicker().getText());
		terminDB.setEndzeit(editView.getEndPicker().getText());
		terminDB.setFarbe(editView.getColorChooser().getSelectedItem().toString());
		
		kView.addCalendarEvent(terminDB, isNewEntry);
		editView.dispose();
	}

}
