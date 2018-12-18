package view;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.ModelManager;
import java.awt.event.ActionEvent;

public class RegisterGUI extends JPanel implements Gui {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblRegUsername;
	private JPasswordField regPasswordField_1;
	private JPasswordField regPasswordField_2;
	private JTextField regEmailField;
	private JTextField regUsernameField;
	private JButton btnRegister;

	public RegisterGUI(ActionListener actionListener) {
		setBounds(0, 0, 900, 600);
		setLayout(null);

		lblRegUsername = new JLabel("User Name");
		lblRegUsername.setBounds(212, 191, 114, 14);
		add(lblRegUsername);

		JLabel lblRegEmail = new JLabel("Email");
		lblRegEmail.setBounds(212, 216, 69, 14);
		add(lblRegEmail);

		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(212, 241, 93, 14);
		add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Repete Password");
		lblNewLabel_2.setBounds(212, 266, 114, 14);
		add(lblNewLabel_2);

		regPasswordField_1 = new JPasswordField();
		regPasswordField_1.setBounds(360, 238, 167, 20);
		add(regPasswordField_1);

		regPasswordField_2 = new JPasswordField();
		regPasswordField_2.setBounds(360, 263, 167, 20);
		add(regPasswordField_2);

		regEmailField = new JTextField();
		regEmailField.setBounds(360, 213, 167, 20);
		add(regEmailField);
		regEmailField.setColumns(10);

		regUsernameField = new JTextField();
		regUsernameField.setBounds(360, 188, 167, 20);
		add(regUsernameField);
		regUsernameField.setColumns(10);

		btnRegister = new JButton("Register");
		btnRegister.addActionListener(actionListener);
		btnRegister.setActionCommand("register");
	
		btnRegister.setBounds(340, 332, 89, 23);
		add(btnRegister);

	}

	@Override
	public String[] getdata() {
		return new String[] { getUsername(), getEmail(), getPassword() };
	}

	private String getPassword() {
		String ret0 = new String(regPasswordField_1.getPassword());
		String ret1 = new String(regPasswordField_2.getPassword());
		if (ret0.equals(ret1)) {
			return ret0;
		}
		return null;
	}

	private String getEmail() {
		return regEmailField.getText();
	}

	private String getUsername() {
		return regUsernameField.getText();
	}

	@Override
	public String[] getdata(String command) {
		String[] result = { command, "", "", "", "" };
		String pwd1 = new String(regPasswordField_1.getPassword());
		String pwd2 = new String(regPasswordField_2.getPassword());
		if (pwd1.equals(pwd2)) {
			result[1] = regUsernameField.getText();
			result[2] = regEmailField.getText();
			result[3] = pwd1;
		}
		System.out.println(
				"Register.getdata[] is called: " + result[0] + " " + result[1] + " " + result[2] + " " + result[3]);

		return result;
	}

	public void clearFields() {
		regEmailField.setText(null);
		regPasswordField_1.setText(null);
		regPasswordField_2.setText(null);
		regUsernameField.setText(null);

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
