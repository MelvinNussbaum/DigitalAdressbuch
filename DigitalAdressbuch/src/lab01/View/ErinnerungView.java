package lab01.View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.net.URL;
import java.sql.Connection;
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
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import DatenbankErinnerung.DBConnectionErinnerung;
import DatenbankErinnerung.DBErinnerung;
import DatenbankErinnerung.DBErinnerungDao;
import DatenbankErinnerung.DBErinnerungJDBCDao;
import lab01.Listener.NeueErinnerungListener;
import lab01.Model.ErinnerungEntry;
import lab01.Model.RoundedBorder;

public class ErinnerungView extends JDialog {

	private static final long serialVersionUID = -6447835938896858960L;

	private List<JPanel> entries = new ArrayList<JPanel>();

	private Calendar cal = Calendar.getInstance();
	static SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
	
	private Connection con = DBConnectionErinnerung.getInstance().getConnection();		
	private DBErinnerungDao pd = new DBErinnerungJDBCDao(con);

	protected static final Icon neuerEintragIcon = loadIcon("neueErinnerung.PNG");

	protected final JButton neueErinnerungButton = new JButton("Neue Erinnerung", neuerEintragIcon);
	
	protected final JPanel northPanel = new JPanel(new BorderLayout());
	protected final JPanel buttonPanel = new JPanel();
	protected final JPanel timePanel = new JPanel();
	
	protected final JPanel southPanel = new JPanel();
	protected final JPanel container = new JPanel(new BorderLayout(0, 0));
	
	protected final JScrollPane scrollPane = new JScrollPane(container);

	protected JLabel uhrzeit;

	public ErinnerungView() {
		initUI();
	}

	private void initUI() {
		
		setTitle("Erinnerungen");
		setResizable(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setPreferredSize(new Dimension(350, 500));
		
		for (DBErinnerung entry : pd.getAllErinnerung()) {
			ErinnerungEntry eEntry = new ErinnerungEntry(this, entry);
			if (entry.isErledigt()) {
				eEntry.getCheckBox().setSelected(true); 
			}
			entries.add(eEntry.getEPanel());		}
		for (JPanel entry : entries) {
			southPanel.add(entry);
		}
		
		neueErinnerungButton.setBorder(new RoundedBorder(20));
		neueErinnerungButton.setPreferredSize(new Dimension(170, 30));
		neueErinnerungButton.addActionListener(new NeueErinnerungListener(this, new DBErinnerung()));
		neueErinnerungButton.setHorizontalAlignment(JButton.LEFT);
		
		uhrzeit = new JLabel(sdf.format(getCal().getTime()) + "  ");
		uhrzeit.setHorizontalAlignment(JLabel.RIGHT);
		uhrzeit.setFont(new Font("Sans-Serif", Font.PLAIN, 16));

		buttonPanel.add(neueErinnerungButton);
		timePanel.add(uhrzeit);
		
		northPanel.setPreferredSize(new Dimension(300, 40));
		northPanel.add(buttonPanel, BorderLayout.WEST);
		northPanel.add(timePanel, BorderLayout.EAST);
				
		southPanel.setPreferredSize(new Dimension(300, entries.size()*51 + 40));
		southPanel.setBorder(BorderFactory.createLoweredBevelBorder());
		
		container.add(northPanel, BorderLayout.NORTH);
		container.add(southPanel, BorderLayout.CENTER);
		
		add(scrollPane);
		
		pack();
		setVisible(true);
		
	}
	
	public void updateUI() {
		southPanel.removeAll();
		entries.removeAll(entries);
		
		for (DBErinnerung entry : pd.getAllErinnerung()) {
			ErinnerungEntry eEntry = new ErinnerungEntry(this, entry);
			if (entry.isErledigt()) {
				eEntry.getCheckBox().setSelected(true); 
			}
			entries.add(eEntry.getEPanel());
		}
		for (JPanel entry : entries) {
			southPanel.add(entry);
		}
		
		cal = Calendar.getInstance();
		uhrzeit.setText(sdf.format(getCal().getTime()) + "  ");
		southPanel.setPreferredSize(new Dimension(300, entries.size()*51 + 40));

		this.revalidate();
		this.repaint();
	}

	public static Icon loadIcon(String iconName) {
		final URL resource = ErinnerungView.class.getResource("/images/" + iconName);

		if (resource == null) {
			System.err.println("Fehler: " + "/images/" + iconName);
			return new ImageIcon();
		}
		return new ImageIcon(resource);
	}

	public void addErinnerungEntry(DBErinnerung erinnerungDB, boolean isNewEntry) {
		if (isNewEntry) {
			pd.insertErinnerung(erinnerungDB);
		} else {
			pd.deleteErinnerung(erinnerungDB);
			pd.updateErinnerungDatum(erinnerungDB);
			pd.updateErinnerungDatum(erinnerungDB);
			pd.updateErinnerungZeit(erinnerungDB);
			pd.insertErinnerung(erinnerungDB);
		}
		
		ErinnerungEntry eEntry = new ErinnerungEntry(this, erinnerungDB);
		entries.add(eEntry.getEPanel());
		updateUI();
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

	public List<JPanel> getEntries() {
		return entries;
	}

	public DBErinnerungDao getPd() {
		return pd;
	}

	public void setPd(DBErinnerungDao pd) {
		this.pd = pd;
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
