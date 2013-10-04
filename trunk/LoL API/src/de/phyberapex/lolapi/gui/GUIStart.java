package de.phyberapex.lolapi.gui;

import de.phyberapex.lolapi.client.APIClient;

public class GUIStart {

	public static void main(String[] args) {
		new MainFrame(new APIClient()).setVisible(true);;
	}
}
