package view;

import model.ModelManager;
import model.PlayerManager;

public interface Gui {

	String[] getdata(String command);

	String[] getdata();

	void setVisible(boolean b);

	void clearFields();

	void update(String[] getdata);

	void setStage(int stage);

	void updateView(int parseInt, int parseInt2, String string);

	ModelManager getModelManager();

	
}