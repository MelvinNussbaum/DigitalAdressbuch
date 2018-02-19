/**
 * 
 */
package lab01.Datenbank.Person;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * @author rohrm
 *
 */
public class LoginForm extends JFrame {

	private static final long serialVersionUID = -8947127578402798768L;

	private final JLabel emailLabel = new JLabel("E-Mail:");
	private final JLabel passwordLabel = new JLabel("Passwort:");
	private final JTextField emailTextField = new JTextField(35);
	private final JPasswordField passwordField = new JPasswordField();
	private final JButton loginButton = new JButton("Anmelden");
	private final JButton registerButton = new JButton("Registrieren");

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final LoginForm lf = new LoginForm();
		lf.setTitle("Login Form Example [Version 1.0]");
		lf.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		lf.initUI();
		lf.pack();
		lf.setResizable(false);
		lf.setVisible(true);
	}

	private void initUI() {

		// left column of login (labels)
		final JPanel loginLabelPanel = new JPanel(new GridLayout(2, 1));
		loginLabelPanel.add(emailLabel);
		loginLabelPanel.add(passwordLabel);

		// right column of login (input fields)
		final JPanel loginInputPanel = new JPanel(new GridLayout(2, 1));
		loginInputPanel.add(emailTextField);
		loginInputPanel.add(passwordField);

		// full login panel (labels + input fields)
		final JPanel loginPanel = new JPanel();
		loginPanel.add(loginLabelPanel);
		loginPanel.add(loginInputPanel);

		// buttons panel
		final JPanel buttonPanel = new JPanel();
		buttonPanel.add(loginButton);
		buttonPanel.add(registerButton);

		// full login form
		add(loginPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
	}

}
