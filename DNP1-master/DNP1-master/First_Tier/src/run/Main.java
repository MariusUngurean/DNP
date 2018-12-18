package run;


import java.awt.EventQueue;

import ServerConnection.*;

import model.ModelManager;
import model.PlayerManager;
import view.MainFrame;

public class Main {
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Connection  clientConnection= new ClientConnection();
					ModelManager playerManager = new PlayerManager(clientConnection);
					MainFrame window = new MainFrame((PlayerManager) playerManager);
					
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}