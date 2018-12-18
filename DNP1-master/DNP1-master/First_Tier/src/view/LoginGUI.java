package view;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.ModelManager;

public class LoginGUI extends JPanel implements Gui {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPasswordField passwordField;
	private JTextField emailField;
	private JButton loginButton;

	public LoginGUI(ActionListener actionListener) {
		setBounds(0, 0, 900, 600);
		setLayout(null);

		passwordField = new JPasswordField();
		passwordField.setToolTipText("Password");
		passwordField.setColumns(10);
		passwordField.setBounds(303, 230, 173, 20);
		add(passwordField);

		emailField = new JTextField();
		emailField.setToolTipText("Email");
		emailField.setColumns(10);
		emailField.setBounds(303, 185, 173, 20);
		add(emailField);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setLabelFor(emailField);
		lblEmail.setBounds(235, 188, 173, 14);
		add(lblEmail);

		JLabel lblPwd = new JLabel("Password");
		lblPwd.setBounds(235, 233, 173, 14);
		add(lblPwd);

		loginButton = new JButton("Login");
		loginButton.setBounds(256, 281, 86, 23);
		add(loginButton);
		loginButton.addActionListener(actionListener);
		loginButton.setActionCommand("login");

		JButton btnGoToRegister = new JButton("I am not registred");
		btnGoToRegister.addActionListener(actionListener);
		btnGoToRegister.setActionCommand("doRegistration");
		btnGoToRegister.setBounds(203, 372, 220, 35);
		add(btnGoToRegister);

	}

	@Override
	public String[] getdata() {
		String[] ret = { emailField.getText(), new String(passwordField.getPassword()) };
		System.out.println("getdata() is called: " + (ret[0] + ret[1]));

		return ret;
	}

	@Override
	public String[] getdata(String command) {

		String[] result = { command, "", "", "", "" };
		switch (command) {
		case "login":
			result[1] = emailField.getText();
			result[2] = new String(passwordField.getPassword());
			System.out.println("login.login.getdata[] is called: " + result[0] + " " + result[1] + " " + result[2] + " "
					+ result[3]);

			break;
		case "logout":
		case "doregistration":
			break;

		}
		return result;
	}

	public void clearFields() {
		emailField.setText(null);
		passwordField.setText(null);
	}

	@Override
	public void update(String[] getdata) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setStage(int stage) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateView(int parseInt, int parseInt2, String string) {
		// TODO Auto-generated method stub

	}


	@Override
	public ModelManager getModelManager() {
		// TODO Auto-generated method stub
		return null;
	}

}
