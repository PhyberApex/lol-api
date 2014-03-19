package de.phyberapex.lolapi.persistence;

import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import de.phyberapex.lolapi.base.Config;
import de.phyberapex.lolapi.base.Mode;

public class Start {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			Config.getInstance().setMode(Mode.PERSISTENCE);
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
