package lab01.Model;

import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;

import lab01.View.ErinnerungView;

public class CustomCheckBox extends JCheckBox {

	private static final long serialVersionUID = 5460756562159846853L;

	public CustomCheckBox() {
	    setSelected(false);

	    setIcon(ErinnerungView.loadIcon("checkboxunchecked.png"));
	    setSelectedIcon(ErinnerungView.loadIcon("checkboxchecked.png"));
	    setRolloverIcon(ErinnerungView.loadIcon("checkboxhover.png"));
	}
}
