package de.phyberapex.lolapi;

import java.io.IOException;

import de.phyberapex.lolapi.base.Config;
import de.phyberapex.lolapi.base.Mode;

public class GUIStart {

	public static void main(String[] args) {
		try {
			Config.getInstance().setMode(Mode.GUI_API);
		} catch (IOException e) {
			// inform user that files needed have been created and he should
			// edit them
			Config.getInstance().createNeededFiles();
		}
	}
}
