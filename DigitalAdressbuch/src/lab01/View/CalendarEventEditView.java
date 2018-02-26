package lab01.View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.TimePicker;

import DatenbankTermine.DBTermine;
import lab01.Listener.CalendarSafeListener;
import lab01.Model.WeekCalendar.CalendarEvent;

public class CalendarEventEditView extends JDialog{

	private static final long serialVersionUID = 3656169188299117802L;
	
	private Map<String, Color> farben = new HashMap<String, Color>();
	
	private CalendarEvent cEvent;
	private KalenderView kView;
	private boolean isNewEntry;
	
	protected final Font bold = new Font("Sans-Serif", Font.BOLD, 15);
	
	protected final JPanel container = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	protected final JPanel bearbeitungPanel = new JPanel(new BorderLayout(5, 10));
	protected final JPanel labelPanel = new JPanel(new GridLayout(0,  1, 10, 10));
	protected final JPanel fieldPanel = new JPanel(new GridLayout(0, 1, 10, 5));
	
	protected final JLabel titelLabel = new JLabel("Titel");
	protected final JLabel dateLabel = new JLabel("Datum");
	protected final JLabel startLabel = new JLabel("Start");
	protected final JLabel endLabel = new JLabel("Ende");
	protected final JLabel farbeLabel = new JLabel("Farbe");
	
	protected final JTextField titelTF = new JTextField();
	
	protected final DatePicker datePicker = new DatePicker();
	protected final TimePicker startPicker = new TimePicker();
	protected final TimePicker endPicker = new TimePicker();
	
	protected final JComboBox<String> colorChooser = new JComboBox<String>();
	
	protected final JButton fertigButton = new JButton("Fertig");

	
	
	public CalendarEventEditView(CalendarEvent cEvent, KalenderView kView, boolean isNewEntry) {
		this.cEvent = cEvent;
		this.kView = kView;
		this.isNewEntry = isNewEntry;
		initUI();
	}
	
	private void initUI() {
		setTitle("Termin");
		setResizable(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setPreferredSize(new Dimension(330, 230));
		
		farben.put("Rot", Color.RED);
		farben.put("Blau", Color.BLUE);
		farben.put("Grün", Color.GREEN);
		farben.put("Schwarz", Color.BLACK);
		
		for (String item : farben.keySet()) {
			colorChooser.addItem(item);
		}
		
		fertigButton.addActionListener(new CalendarSafeListener(new DBTermine(), cEvent, this, kView, isNewEntry));
		
		titelLabel.setFont(bold);
		dateLabel.setFont(bold);
		startLabel.setFont(bold);
		endLabel.setFont(bold);
		farbeLabel.setFont(bold);
		
		labelPanel.add(titelLabel);
		labelPanel.add(dateLabel);
		labelPanel.add(startLabel);
		labelPanel.add(endLabel);
		labelPanel.add(farbeLabel);
		
		fieldPanel.add(titelTF);
		fieldPanel.add(datePicker);
		fieldPanel.add(startPicker);
		fieldPanel.add(endPicker);
		fieldPanel.add(colorChooser);
		
		bearbeitungPanel.setPreferredSize(new Dimension(300, 150));
		bearbeitungPanel.add(labelPanel, BorderLayout.WEST);
		bearbeitungPanel.add(fieldPanel, BorderLayout.CENTER);
		
		container.add(bearbeitungPanel);
		container.add(fertigButton);
		
		add(container);
		
		pack();
		setVisible(true);
	}

	public Map<String, Color> getFarben() {
		return farben;
	}

	public void setFarben(Map<String, Color> farben) {
		this.farben = farben;
	}

	public CalendarEvent getcEvent() {
		return cEvent;
	}

	public void setcEvent(CalendarEvent cEvent) {
		this.cEvent = cEvent;
	}

	public JLabel getTitelLabel() {
		return titelLabel;
	}

	public JLabel getDateLabel() {
		return dateLabel;
	}

	public JLabel getStartLabel() {
		return startLabel;
	}

	public JLabel getEndLabel() {
		return endLabel;
	}

	public JLabel getFarbeLabel() {
		return farbeLabel;
	}

	public JTextField getTitelTF() {
		return titelTF;
	}

	public DatePicker getDatePicker() {
		return datePicker;
	}

	public TimePicker getStartPicker() {
		return startPicker;
	}

	public TimePicker getEndPicker() {
		return endPicker;
	}

	public JComboBox<String> getColorChooser() {
		return colorChooser;
	}
}
