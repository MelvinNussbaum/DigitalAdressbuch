package lab01.TerminErinnerung.view;

import java.net.URL;
import javax.swing.*;
import lab01.TerminErinnerung.Erinnerung;

public class ErinnerungView extends JDialog {

	private static final long serialVersionUID = 1L;

	private Erinnerung CONTROLLER = null;	
	
	protected static final Icon neuerEintragIcon = loadIcon("neueErinnerung.PNG	");
	
	
	
	
	private static Icon loadIcon(String iconName) {
	    final URL resource = ErinnerungView.class.getResource("/images/" + iconName);
	
	    if (resource == null) {
	      System.err.println("Fehler: " + "/images/" + iconName);
	      return new ImageIcon();
	    }
	    return new ImageIcon(resource);
	}
	
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
		      @Override
		      public void run() {
		        ErinnerungView erinnerungView = new ErinnerungView();
		       
		      }
		    });
		  }

}
