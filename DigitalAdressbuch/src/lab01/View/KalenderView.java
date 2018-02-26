package lab01.View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import com.github.lgooddatepicker.components.CalendarPanel;

import DatenbankErinnerung.DBConnectionErinnerung;
import DatenbankTermine.DBTermine;
import DatenbankTermine.DBTermineDao;
import DatenbankTermine.DBTermineJDBCDao;
import lab01.Listener.CalendarNeuListener;
import lab01.Model.RoundedBorder;
import lab01.Model.WeekCalendar.CalendarEvent;
import lab01.Model.WeekCalendar.WeekCalendar;

public class KalenderView extends JFrame {

	private static final long serialVersionUID = -610713751958287004L;
	
	private ArrayList<CalendarEvent> events = new ArrayList<>();
	
	protected final CalendarPanel calendar = new CalendarPanel();
	protected final WeekCalendar weekCalendar = new WeekCalendar(events);
	
	private Connection con = DBConnectionErinnerung.getInstance().getConnection();		
	private DBTermineDao pd = new DBTermineJDBCDao(con);
	
	protected final Icon addTerminIcon = ErinnerungView.loadIcon("addTerminIcon.png");
	protected final Icon editTerminIcon = ErinnerungView.loadIcon("editTerminIcon.png");
	protected final Icon deleteTerminIcon = ErinnerungView.loadIcon("deleteTerminIcon.png");
	protected final Icon searchIcon = ErinnerungView.loadIcon("searchIcon.png");
	
	protected final JPanel sideBar = new JPanel();
	protected final JPanel sideBarNorthContainer = new JPanel(new BorderLayout(0, 80));
	protected final JPanel calendarButtonsPanel = new JPanel(new GridLayout(0, 1, 20, 20));
	protected final JPanel calendarPanel = new JPanel();
	protected final JPanel weekCalendarPanel = new JPanel();
	
	protected final JScrollPane scrollPane = new JScrollPane(weekCalendar);
	
	protected final JTextField searchBarField = new JTextField("Suchen");
				
	protected final JButton tHinzufügen = new JButton("Termin hinzufügen", addTerminIcon);
	protected final JButton tBearbeiten = new JButton("Termin bearbeiten", editTerminIcon);
	protected final JButton tLöschen = new JButton("Termin löschen", deleteTerminIcon);
	

	


	
	public KalenderView() {
		initUI();
	}
	
	private void initUI() {
		setTitle("Kalender");
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(1600, 900));
		
		searchBarField.setHorizontalAlignment(JTextField.CENTER);
		searchBarField.setPreferredSize(new Dimension(250, 25));
		
		tHinzufügen.setBorder(new RoundedBorder(20));
		tHinzufügen.setVerticalTextPosition(SwingConstants.BOTTOM);
		tHinzufügen.setHorizontalTextPosition(SwingConstants.CENTER);
		tHinzufügen.addActionListener(new CalendarNeuListener(this));

		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	
//		TODO scrollable WeekCalendar
//		weekCalendar.setPreferredSize(new Dimension(1620, 2000));
//		
//		weekCalendarPanel.add(weekCalendar);
//		weekCalendarPanel.add(scrollPane);
//		weekCalendarPanel.setPreferredSize(new Dimension(1620, 1000));
		
		weekCalendar.setBorder(BorderFactory.createMatteBorder(1, 10, 1, 0, Color.lightGray));
		
		calendarButtonsPanel.add(tHinzufügen);
		calendarButtonsPanel.add(tBearbeiten);
		calendarButtonsPanel.add(tLöschen);
		calendarButtonsPanel.setPreferredSize(new Dimension(200, 300));

		sideBarNorthContainer.add(searchBarField, BorderLayout.NORTH);
		sideBarNorthContainer.add(calendarButtonsPanel, BorderLayout.SOUTH);
		
		calendarPanel.add(calendar);
		calendarPanel.setPreferredSize(new Dimension(250, 500));
		//TODO Calendar Bottom-Alingment
		
		sideBar.setPreferredSize(new Dimension(300, 1080));
		sideBar.add(sideBarNorthContainer);
		sideBar.add(calendarPanel);
		add(sideBar, BorderLayout.WEST);
		add(weekCalendar, BorderLayout.CENTER);
		add(scrollPane, BorderLayout.EAST);
		
		validate();
	}
	
	public void addCalendarEvent(DBTermine cEvent, boolean isNewEntry) {
		if (isNewEntry) {
			pd.insertTermine(cEvent);
		} else {
			pd.deleteTermine(cEvent);
			pd.updateTermineName(cEvent);
			pd.updateTermineDatum(cEvent);
			pd.updateTermineStartzeit(cEvent);
			pd.updateTermineEndzeit(cEvent);
			pd.updateTermineFarbe(cEvent);
			pd.insertTermine(cEvent);
		}
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {	
			@Override
			public void run() {
				KalenderView kalenderView = new KalenderView();
				kalenderView.pack();
				kalenderView.setVisible(true);
				
			}
	    });
	}
}

