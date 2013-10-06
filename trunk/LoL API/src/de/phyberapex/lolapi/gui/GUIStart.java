package de.phyberapex.lolapi.gui;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class GUIStart {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		MainFrame.getInstance().setVisible(true);
	}
}
