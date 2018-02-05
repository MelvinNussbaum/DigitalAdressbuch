package lab01.TerminErinnerung.view;

import java.awt.BorderLayout;
import java.net.URL;
import javax.swing.*;

import lab01.TerminErinnerung.Erinnerung;


public class ErinnerungView extends JDialog {

	private static final long serialVersionUID = -6447835938896858960L;

	protected static final Icon neuerEintragIcon = loadIcon("neueErinnerung.PNG");
		
	protected final JButton neueErinnerungButton = new JButton("Neue Erinnerung", neuerEintragIcon);
	
	protected final JList<Erinnerung> eList = new JList<Erinnerung>();
	
	protected final JPanel listPanel = new JPanel();
	

	
	public ErinnerungView() {
		initUI();
	}
	
	private void initUI() {
		
		setTitle("Erinnerungen");
		setResizable(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		add(neueErinnerungButton, BorderLayout.WEST);
		add(listPanel, BorderLayout.SOUTH);
		listPanel.add(eList);
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
		ErinnerungView gui = new ErinnerungView();
		gui.setSize(350, 500);
		gui.setVisible(true);
	}
}
