package lab01.View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.github.lgooddatepicker.components.DateTimePicker;

import DatenbankErinnerung.DBErinnerung;
import lab01.Listener.SafeErinnerungListener;

public class ErinnerungBearbeitenView extends JDialog {

	private static final long serialVersionUID = 5813736857825532698L;
	
	private DBErinnerung erinnerungDB;
	private ErinnerungView eView;
	private boolean isNewEntry;
	
	
	protected final JPanel container = new JPanel(new FlowLayout(SwingConstants.RIGHT, 10, 5));
	protected final JPanel bearbeitungPanel = new JPanel(new BorderLayout(5, 10));	
	protected final JPanel labelPanel = new JPanel(new GridLayout(0, 1, 10, 10));
	protected final JPanel fieldPanel = new JPanel(new GridLayout(0, 1, 10, 5));
	
	protected final Font bold = new Font("Sans-Serif", Font.BOLD, 15);
	
	protected final JLabel titelLabel = new JLabel("Titel");
	protected final JLabel dateLabel = new JLabel("Datum");
	
	protected final JButton bearbeitenFertigButton = new JButton("Fertig");
	
	protected final DateTimePicker dateTimePicker = new DateTimePicker();
	
	protected final JTextField titelTF = new JTextField();


	
	
	public ErinnerungBearbeitenView(ErinnerungView eView, DBErinnerung erinnerungDB, boolean isNewEntry) {
		this.eView = eView;
		this.erinnerungDB = erinnerungDB;
		this.isNewEntry = isNewEntry;
		initUI();
	}
	
	private void initUI() {
		setTitle("Erinnerungen");s
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		setSize(new Dimension(350, 150));;
		
		titelLabel.setFont(bold);
		dateLabel.setFont(bold);		
		
		bearbeitenFertigButton.setSize(new Dimension(100, 20));
		bearbeitenFertigButton.setHorizontalAlignment(SwingConstants.RIGHT);
		bearbeitenFertigButton.addActionListener(new SafeErinnerungListener(this, erinnerungDB, eView, isNewEntry));
		
		labelPanel.add(titelLabel);
		labelPanel.add(dateLabel);
		
		fieldPanel.add(titelTF);
		fieldPanel.add(dateTimePicker);
		
		bearbeitungPanel.setPreferredSize(new Dimension(320, 60));
		bearbeitungPanel.add(labelPanel, BorderLayout.WEST);
		bearbeitungPanel.add(fieldPanel, BorderLayout.CENTER);

		container.add(bearbeitungPanel);
		container.add(bearbeitenFertigButton);
		
		add(container);
		
		
	}
	
	public void updateUI() {
		
	}

	public JTextField getTitelTF() {
		return titelTF;
	}

	public DateTimePicker getDateTimePicker() {
		return dateTimePicker;
	}
	
}
