package lab01.View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import lab01.Listener.NeueErinnerungListener;
import lab01.Model.ErinnerungEntry;
import lab01.Model.RoundedBorder;

public class ErinnerungView extends JDialog {

	private static final long serialVersionUID = -6447835938896858960L;

	private List<JPanel> entries = new ArrayList<JPanel>();

	private Calendar cal = Calendar.getInstance();
	static SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

	protected static final Icon neuerEintragIcon = loadIcon("neueErinnerung.PNG");

	protected final JButton neueErinnerungButton = new JButton("Neue ErinnerungEntry", neuerEintragIcon);

	protected final JPanel northPanel = new JPanel(new GridLayout(0, 2));
	private final JPanel southPanel = new JPanel();

	protected JLabel uhrzeit;

	public ErinnerungView() {
		initUI();
	}

	private void initUI() {

		setTitle("Erinnerungen");
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setPreferredSize(new Dimension(350, 500));

		neueErinnerungButton.setBorder(new RoundedBorder(20));
		neueErinnerungButton.setPreferredSize(new Dimension(200, 30));
		neueErinnerungButton.addActionListener(new NeueErinnerungListener(this, new ErinnerungEntry(this)));

		uhrzeit = new JLabel(sdf.format(getCal().getTime()) + "  ");
		uhrzeit.setHorizontalAlignment(JLabel.RIGHT);
		uhrzeit.setFont(new Font("Sans-Serif", Font.PLAIN, 16));

		northPanel.add(neueErinnerungButton);
		northPanel.add(uhrzeit);
		
		southPanel.setBorder(BorderFactory.createLoweredBevelBorder());

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

	public void addErinnerungEntry(ErinnerungEntry erinnerungEntry) {
		if (erinnerungEntry != null) {
			erinnerungEntry.getEPanel().setPreferredSize(new Dimension(southPanel.getWidth()-10, 48));
			entries.add(erinnerungEntry.getEPanel());
			for (JPanel entry : entries) {
				southPanel.add(entry);
			}
		}
	}

	public static SimpleDateFormat getSdf() {
		return sdf;
	}

	public Calendar getCal() {
		return cal;
	}

	public void setCal(Calendar cal) {
		this.cal = cal;
	}

	public JPanel getSouthpanel() {
		return southPanel;
	}

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				ErinnerungView erinnerungView = new ErinnerungView();

				erinnerungView.pack();
				erinnerungView.setVisible(true);
				// ErinnerungEntry e1 = new ErinnerungEntry(erinnerungView.getSouthpanel(), erinnerungView);

			}
		});

	}
}
