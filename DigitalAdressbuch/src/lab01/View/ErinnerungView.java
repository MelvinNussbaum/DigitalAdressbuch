package lab01.View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import lab01.Listener.JButtonListener;
import lab01.Model.Erinnerung;
import lab01.Model.RoundedBorder;

public class ErinnerungView extends JDialog {

	private static final long serialVersionUID = -6447835938896858960L;
	
    Calendar cal = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

	protected static final Icon neuerEintragIcon = loadIcon("neueErinnerung.PNG");

	protected final JButton neueErinnerungButton = new JButton("Neue Erinnerung", neuerEintragIcon);

	protected final JPanel northPanel = new JPanel(new GridLayout(0, 2));
	protected final static JPanel southPanel = new JPanel();

	protected JLabel uhrzeit;

	public ErinnerungView() {
		initUI();
	}

	private void initUI() {

		setTitle("Erinnerungen");
		setResizable(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		this.setSize(new Dimension(350, 500));
		
		neueErinnerungButton.setBorder(new RoundedBorder(20));
		neueErinnerungButton.setPreferredSize(new Dimension(200, 30));
		neueErinnerungButton.addActionListener(new JButtonListener(null));

		
		
		uhrzeit = new JLabel(sdf.format(cal.getTime()) + "  ");
		uhrzeit.setHorizontalAlignment(JLabel.RIGHT);
		uhrzeit.setFont(new Font("Sans-Serif", Font.PLAIN, 16));
		
		northPanel.add(neueErinnerungButton);
		northPanel.add(uhrzeit);
		

		add(northPanel, BorderLayout.NORTH);
		add(southPanel, BorderLayout.CENTER);
		
		
	}

	public static Icon loadIcon(String iconName) {
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
	        	ErinnerungView ErinnerungView = new ErinnerungView();
	        	ErinnerungView.pack();
	        	ErinnerungView.setVisible(true);
	        	Erinnerung e1 = new Erinnerung("Einkaufen", southPanel);
	        	Erinnerung e2 = new Erinnerung("Schlafen", southPanel);
	        }
	      });
	    
		


	}
}
