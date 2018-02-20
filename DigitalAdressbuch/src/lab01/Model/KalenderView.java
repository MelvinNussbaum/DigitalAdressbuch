package lab01.Model;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import com.github.lgooddatepicker.components.CalendarPanel;

import lab01.View.ErinnerungView;

public class KalenderView extends JFrame {

	private static final long serialVersionUID = -610713751958287004L;
	
	private ArrayList<Termin> events = new ArrayList<Termin>();
	
	protected final Icon addTerminIcon = ErinnerungView.loadIcon("addTerminIcon.png");
	protected final Icon editTerminIcon = ErinnerungView.loadIcon("editTerminIcon.png");
	protected final Icon deleteTerminIcon = ErinnerungView.loadIcon("deleteTerminIcon.png");
	protected final Icon searchIcon = ErinnerungView.loadIcon("searchIcon.png");
	
	protected final JPanel sideBar = new JPanel();
	protected final JPanel sideBarNorthContainer = new JPanel(new BorderLayout(0, 80));
	protected final JPanel calendarButtonsPanel = new JPanel(new GridLayout(0, 1, 20, 20));
	protected final JPanel calendarPanel = new JPanel(new FlowLayout(SwingUtilities.BOTTOM));
	
	protected final JTextField searchBarField = new JTextField("Suchen");
	
	protected final JButton tHinzufügen = new JButton("Termin hinzufügen", addTerminIcon);
	protected final JButton tBearbeiten = new JButton("Termin bearbeiten", editTerminIcon);
	protected final JButton tLöschen = new JButton("Termin löschen", deleteTerminIcon);
	
	protected final CalendarPanel calendar = new CalendarPanel();
//	protected final WeekCalendar weekCalendar = new WeekCalendar(events);

	
	public KalenderView() {
		initUI();
	}
	
	private void initUI() {
		setTitle("Kalender");
		setResizable(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(new Dimension(1920, 1080));
		setLayout(new BorderLayout());
		
		searchBarField.setHorizontalAlignment(JTextField.CENTER);
		searchBarField.setPreferredSize(new Dimension(250, 25));

		
		tHinzufügen.setBorder(new RoundedBorder(20));
		tHinzufügen.setVerticalTextPosition(SwingConstants.BOTTOM);
		tHinzufügen.setHorizontalTextPosition(SwingConstants.CENTER);
		tBearbeiten.setBorder(new RoundedBorder(20));
		tBearbeiten.setVerticalTextPosition(SwingConstants.BOTTOM);
		tBearbeiten.setHorizontalTextPosition(SwingConstants.CENTER);
		tLöschen.setBorder(new RoundedBorder(20));
		tLöschen.setVerticalTextPosition(SwingConstants.BOTTOM);
		tLöschen.setHorizontalTextPosition(SwingConstants.CENTER);
		
		calendarButtonsPanel.add(tHinzufügen);
		calendarButtonsPanel.add(tBearbeiten);
		calendarButtonsPanel.add(tLöschen);
		calendarButtonsPanel.setPreferredSize(new Dimension(200, 300));

		sideBarNorthContainer.add(searchBarField, BorderLayout.NORTH);
		sideBarNorthContainer.add(calendarButtonsPanel, BorderLayout.SOUTH);
		
		calendarPanel.add(calendar);
		
		sideBar.setPreferredSize(new Dimension(300, 1080));
		sideBar.add(sideBarNorthContainer);
		sideBar.add(calendarPanel);
		add(sideBar, BorderLayout.WEST);

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

