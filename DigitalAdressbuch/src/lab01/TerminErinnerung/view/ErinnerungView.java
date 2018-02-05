package lab01.TerminErinnerung.view;

import java.net.URL;
import javax.swing.*;
import lab01.TerminErinnerung.Erinnerung;

public class ErinnerungView extends JDialog {

	private static final long serialVersionUID = 1L;

	private Erinnerung erinnerung = null;	
	
	protected static final Icon neuerEintragIcon = loadIcon("neueErinnerung.PNG");
	
	protected final JToolBar mainToolBar = new JToolBar();
	
	protected final JMenuItem newMenuItem = new JMenuItem("Neue Erinnerung");
	
	protected final JList<Erinnerung> eList = new JList<Erinnerung>();
	
	

	
	public ErinnerungView() {
		initUI();
	}
	
	private void initUI() {
		erinnerung = new Erinnerung();
		
		setTitle("Erinnerungen");
		setResizable(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
	    mainToolBar.add(newMenuItem);
		
	}
	
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
