package lab01.View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class ErinnerungBearbeitenView extends JDialog {

	private static final long serialVersionUID = 5813736857825532698L;
	
	protected final JPanel bearbeitungPanel = new JPanel();
	protected final JPanel titelPanel = new JPanel(new BorderLayout());
	protected final JPanel datePanel = new JPanel(new BorderLayout());
	
	protected final JLabel titelLabel = new JLabel("Titel      ");
	protected final JLabel dateLabel = new JLabel("Datum  ");
	
	protected final JTextField titelTF = new JTextField();
	protected final JTextField dateTF = new JTextField();
	
	
	public ErinnerungBearbeitenView() {
		initUI();
	}
	
	private void initUI() {
		setTitle("Erinnerungen");
		setResizable(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		this.setSize(new Dimension(350, 500));
		
		titelTF.setPreferredSize(new Dimension(this.getWidth()-70, 20));
		dateTF.setPreferredSize(new Dimension(this.getWidth()-70, 20));
		
		titelPanel.add(titelLabel, BorderLayout.WEST);
		titelPanel.add(titelTF, BorderLayout.EAST);
		
		datePanel.add(dateLabel, BorderLayout.WEST);
		datePanel.add(dateTF, BorderLayout.EAST);
		
		
		bearbeitungPanel.add(titelPanel);
		bearbeitungPanel.add(datePanel);
		
		add(bearbeitungPanel);
		
	}
	
}
