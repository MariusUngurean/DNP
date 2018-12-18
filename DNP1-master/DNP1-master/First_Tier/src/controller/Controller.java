package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import model.ModelManager;
import model.Player;
import model.PlayerManager;
import view.Gui;

public class Controller implements ActionListener {

	private Gui gui;
	public String toDo;
	private ModelManager modelManager;

	public Controller(Gui gui) {

		this.gui = gui;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("there is action event");
		String command = e.getActionCommand();
		System.out.println("event = "+ command);
		String[] args = gui.getdata(command);
		modelManager = (PlayerManager) gui.getModelManager();
		gui.update(modelManager.doWork(args));
	}

}
