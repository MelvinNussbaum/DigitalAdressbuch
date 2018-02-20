package lab01.Listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.function.Predicate;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import DatenbankErinnerung.DBErinnerung;
import lab01.Model.ErinnerungEntry;
import lab01.View.ErinnerungBearbeitenView;
import lab01.View.ErinnerungView;

public class EditErinnerungListener implements MouseListener {
	private DBErinnerung erinnerungDB;
	private ErinnerungView eView;
	private ErinnerungEntry eEntry;

	public EditErinnerungListener(DBErinnerung erinnerungDB, ErinnerungView eView, ErinnerungEntry eEntry) {
		this.eView = eView;
		this.eEntry = eEntry;
		setErinnerungEntry(erinnerungDB);
	}

	public void setErinnerungEntry(DBErinnerung erinnerungDB) {
		if (erinnerungDB == null) {
			//TODO throw Exception
		}
		this.erinnerungDB = erinnerungDB;
	
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Predicate<JPanel> entryPredicate = entry-> entry.hashCode() == eEntry.getEPanel().hashCode();
		ErinnerungBearbeitenView ebView = new ErinnerungBearbeitenView(eView, erinnerungDB, false);
		
		ebView.getTitelTF().setText(erinnerungDB.getErinnerungsname());
		ebView.getDateTimePicker().getTimePicker().getComponentTimeTextField().setText(erinnerungDB.getZeit());
		ebView.getDateTimePicker().getDatePicker().getComponentDateTextField().setText(erinnerungDB.getDatum());
		ebView.setVisible(true);
		eView.getEntries().removeIf(entryPredicate);		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
 		eEntry.getEPanel().setBorder(BorderFactory.createRaisedBevelBorder());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		eEntry.getEPanel().setBorder(BorderFactory.createLoweredBevelBorder());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
