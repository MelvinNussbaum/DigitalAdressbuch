package lab01.TerminErinnerung.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import lab01.TerminErinnerung.Erinnerung;

public class ErinnerungView extends JDialog {

	private static final long serialVersionUID = -6447835938896858960L;

	protected static final Icon neuerEintragIcon = loadIcon("neueErinnerung.PNG");

	protected final JButton neueErinnerungButton = new JButton("Neue Erinnerung", neuerEintragIcon);

	protected final List<JPanel> eList = new ArrayList<JPanel>();

	protected final JPanel listPanel = new JPanel();
	protected final JPanel northPanel = new JPanel(new GridLayout(0, 2));
	protected final JPanel southPanel = new JPanel(new GridLayout(0, 1));

	protected final JLabel uhrzeit = new JLabel("16:06");

	public ErinnerungView(Erinnerung e) {
		initUI(e);
	}

	private void initUI(Erinnerung e) {

		setTitle("Erinnerungen");
		setResizable(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		// neueErinnerungButton.setSize(100, 100);
		uhrzeit.setHorizontalAlignment(JLabel.RIGHT);
		northPanel.add(neueErinnerungButton);
		northPanel.add(uhrzeit);

		add(northPanel, BorderLayout.NORTH);
		getElist().add(e.createEPanel());
		
		for (JPanel ePanel : getElist()) {
			southPanel.add(ePanel);
		}
		add(southPanel, BorderLayout.SOUTH);

	}

	public List<JPanel> getElist() {
		return eList;
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

		Erinnerung e = new Erinnerung("Einkaufen");

		ErinnerungView gui = new ErinnerungView(e);
		gui.setSize(350, 500);
		gui.setVisible(true);
	}
}
