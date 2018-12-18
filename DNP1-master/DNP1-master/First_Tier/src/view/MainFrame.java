package view;

import javax.swing.JFrame;

import java.awt.event.ActionListener;
import model.ModelManager;

import javax.swing.JPanel;

import controller.Controller;

public class MainFrame implements Gui {

	public JFrame frame;
	public Gui register, menu, login, play;
	private ModelManager modelManager;
	private ActionListener controller;

	/**
	 * Create the application.
	 * @param controller 
	 */
	public MainFrame(ModelManager modelManager) {
		this.modelManager=modelManager;
		initialize();
	}

	public void setActionListener() {
		controller = new Controller( this);
		
		

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setActionListener();
		frame = new JFrame();
		register = new RegisterGUI(controller);
		menu = new MenuGUI(controller);
		play = new PlayGUI(controller);
		login = new LoginGUI(controller);

		frame.getContentPane().add((JPanel) login);
		frame.getContentPane().add((JPanel) register);
		frame.getContentPane().add((JPanel) menu);
		frame.getContentPane().add((JPanel) play);

		frame.setBounds(200, 200, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		switchOffPanels();
		((JPanel) login).setVisible(true);

	}

	public void update(String[] data) {
		String key = data[0];
		switch (key) {

		case "play":
		case "resume":
			
			((PlayGUI) this.play).updateView(Integer.parseInt(data[1]), Integer.parseInt(data[2]));
			setViewVisible(play);

			break;
		case "menu":
			menu.setStage(12);
			menu.updateView(Integer.parseInt(data[2]), Integer.parseInt(data[3]), data[1]);

			setViewVisible(menu);
			break;
		case "register":
			setViewVisible(register);
			break;
		case "login":
			setViewVisible(login);
			break;
		case "logout":
			setViewVisible(login);
			break;
		case "exit":
			System.exit(1);

		}

	}

	private void setViewVisible(Gui gui) {
		switchOffPanels();
		((Gui) gui).clearFields();
		((Gui) gui).setVisible(true);

	}

	@SuppressWarnings("unused")
	private void loadPanel(Gui view) {

	}

	public void switchOffPanels() {
		((JPanel) register).setVisible(false);
		((JPanel) menu).setVisible(false);
		((JPanel) login).setVisible(false);
		((JPanel) play).setVisible(false);
	}

	public Gui getLogin() {
		return login;
	}

	public Gui getMenu() {
		return menu;
	}

	public Gui getPlay() {
		return play;
	}

	public Gui getRegister() {
		return register;
	}

	public String[] getdata(String command) {
		switch (command) {
		case "logout":
		case "login":
		case "doRegistration":
			return getLogin().getdata(command);
		case "menu":
		
			return getMenu().getdata(command);
		case "register":
			return getRegister().getdata(command);
		case "play":
		case "resume":
		case "newGame":
			return getPlay().getdata(command);
		case "exit":
			return new String[] {"exit","",""};

		default:
			break;
		}
		return null;
	}

	@Override
	public void setVisible(boolean b) {
		// TODO Auto-generated method stub

	}

	@Override
	public void clearFields() {
		// TODO Auto-generated method stub

	}

	public ModelManager getModelManager() {
		return this.modelManager;
	}

	@Override
	public void setStage(int stage) {
		// TODO Auto-generated method stub

	}

	@Override
	public String[] getdata() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateView(int parseInt, int parseInt2, String string) {
		// TODO Auto-generated method stub

	}

}
