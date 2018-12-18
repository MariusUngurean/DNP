package view;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.ModelManager;

public class MenuGUI extends JPanel implements Gui {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	private JLabel lblScore;
	private JLabel lblStage;
	private JLabel welcomeMessage;
	private JButton btnResume;
	private JButton btnNewGame;
	private JButton btnExit;

	public MenuGUI(ActionListener actionListener) {

		setBounds(0, 0, 900, 600);
		setLayout(null);

		lblScore = new JLabel("Score: ");
		lblScore.setBounds(21, 42, 108, 14);
		add(lblScore);

		lblStage = new JLabel("Stage: ");
		lblStage.setBounds(809, 42, 46, 14);
		add(lblStage);

		welcomeMessage = new JLabel("Hello ..... !");
		welcomeMessage.setBounds(371, 148, 136, 14);
		add(welcomeMessage);

		btnResume = new JButton("Resume");
		btnResume.setBounds(393, 192, 89, 23);
		btnResume.addActionListener(actionListener);
		btnResume.setActionCommand("resume");
		add(btnResume);

		btnNewGame = new JButton("New Game");
		btnNewGame.setBounds(393, 226, 89, 23);
		btnNewGame.addActionListener(actionListener);
		btnNewGame.setActionCommand("newGame");
		add(btnNewGame);

		btnExit = new JButton("Exit");
		btnExit.setBounds(393, 260, 89, 23);
		btnExit.addActionListener(actionListener);
		btnExit.setActionCommand("exit");
		add(btnExit);

	}

	public void update(String username, int score, int stage) {
		lblScore.setText("Score: " + score);
		lblStage.setText("Stage: " + stage);
		welcomeMessage.setText("Hello " + username + " !");

	}

	@Override
	public String[] getdata(String command) {
		String[] result = { command, "", "", "", "" };

		System.out.println(
				"Menu.getdata[] is called: " + result[0] + " " + result[1] + " " + result[2] + " " + result[3]);

		return result;
	}

	public void updateView(int score, int stage, String name) {
		System.out.println("menu.updateView");
		lblScore.setText("Score: " + score);
		lblStage.setText("Stage: " + stage);
		welcomeMessage.setText("Welcome " + name);

	}

	@Override
	public void clearFields() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(String[] getdata) {
		System.out.println("menu.updateView");

	}

	@Override
	public String[] getdata() {
		System.out.println("MainFrame.menu");
		return null;
	}

	@Override
	public void setStage(int stage) {
		lblStage.setText("BS: ");

	}


	@Override
	public ModelManager getModelManager() {
		// TODO Auto-generated method stub
		return null;
	}

}
