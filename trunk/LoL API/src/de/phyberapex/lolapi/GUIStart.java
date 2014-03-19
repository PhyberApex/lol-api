package de.phyberapex.lolapi;

import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import de.phyberapex.lolapi.base.Config;
import de.phyberapex.lolapi.base.Mode;

public class GUIStart {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			Config.getInstance().setMode(Mode.GUI_API);
		} catch (IOException e) {
			JOptionPane
					.showMessageDialog(null,
							"Please check your the configuration files. Examples have been created.");
			Config.getInstance().createNeededFiles();
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}
}
