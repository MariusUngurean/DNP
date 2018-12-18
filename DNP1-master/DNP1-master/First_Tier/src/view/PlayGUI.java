package view;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import model.ModelManager;
import model.Questions;

public class PlayGUI extends JPanel implements Gui {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextPane textPane;
	private JScrollPane scrollpane;
	private JLabel score;
	private JLabel stage;
	private JTextArea storyText;
	private JButton btnLogOut;
	private JButton btnSubmit;

	public PlayGUI(ActionListener actionListener) {

		setBorder(null);
		setForeground(new Color(0, 255, 0));
		setBackground(new Color(0, 0, 0));
		setBounds(0, 0, 900, 600);
		setLayout(null);

		score = new JLabel("0");
		score.setHorizontalAlignment(SwingConstants.TRAILING);
		score.setBounds(767, 49, 95, 14);
		score.setForeground(new Color(0, 255, 0));
		score.setBackground(new Color(0, 0, 0));
		add(score);

		stage = new JLabel("0");
		stage.setBounds(755, 24, 107, 14);
		stage.setForeground(new Color(0, 255, 0));
		stage.setBackground(new Color(0, 0, 0));
		stage.setHorizontalAlignment(SwingConstants.TRAILING);
		add(stage);

		storyText = new JTextArea();
		storyText.setBounds(0, 27, 757, 275);
		storyText.setForeground(Color.GREEN);
		storyText.setBackground(Color.BLACK);
		add(storyText);

		textPane = new JTextPane();
		textPane.setForeground(new Color(0, 255, 0));
		textPane.setBackground(new Color(0, 0, 0));
		textPane.setBounds(0, 135, 400, 126);
		textPane.setCaretColor(Color.GREEN);
		textPane.setCaretPosition(0);

		scrollpane = new JScrollPane(textPane);
		scrollpane.setBounds(0, 302, 900, 300);
		scrollpane.setViewportBorder(null);
		add(scrollpane);

		btnLogOut = new JButton("Logout");
		btnLogOut.setBounds(767, 234, 89, 23);
		btnLogOut.setBackground(Color.BLACK);
		btnLogOut.setForeground(Color.GREEN);
		btnLogOut.setBorder(null);
		btnLogOut.addActionListener(actionListener);
		btnLogOut.setActionCommand("logout");
		add(btnLogOut);

		btnSubmit = new JButton("Submit");
		btnSubmit.setForeground(Color.GREEN);
		btnSubmit.setBorder(null);
		btnSubmit.setBackground(Color.BLACK);
		btnSubmit.addActionListener(actionListener);
		btnSubmit.setActionCommand("play");
		btnSubmit.setBounds(767, 268, 89, 23);
		add(btnSubmit);

	}

	public void update(String[] getdata) {
		storyText.append(getdata[0]);
		textPane.setText("");
		textPane.setCaretPosition(0);

	}

	@Override
	public String[] getdata(String command) {
		String scoreInt = "", stageInt = "", answer = "";
		scoreInt = "" + Integer.parseInt(score.getText());
		stageInt = "" + Integer.parseInt(stage.getText());
		answer = ""+ textPane.getText();
		textPane.setText("");
		

		System.out.println(
				"Play.class.logout.getdata[] is called: " + command + " " + scoreInt + " " + stageInt + " " + answer);
		return new String[] { command, scoreInt, stageInt, answer };

	}

	public void updateView(int score1, int stage1) {

		score.setText("" + score1);
		stage.setText("" + stage1);
		setStage(stage1);

	}

	@Override
	public void clearFields() {
		// TODO Auto-generated method stub

	}

	@Override
	public String[] getdata() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setStage(int stage) {
		String[] questions = Questions.QuestionsToStringArray(Questions.values());

		storyText.setText("");
		if (stage>5) {stage = 5;}
			
		
		storyText.append(questions[stage]);
		System.out.println(questions[stage]);

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
