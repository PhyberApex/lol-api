package de.phyberapex.lolapi.gui;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;

import static de.phyberapex.lolapi.base.Constants.*;

import javax.swing.JFrame;

import de.phyberapex.lolapi.client.APIClient;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private APIClient apiClient;
	private StatusBar statusBar;

	public MainFrame(APIClient client) {
		super(APP_NAME + " v." + APP_VERSION + " by " + APP_AUTOR);
		this.setSize(800, 600);
		this.setLayout(new BorderLayout());
		this.setLocationRelativeTo(null);
		this.apiClient = client;
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		createGUI();
		layoutGUI();
		this.statusBar.setStatusText("ARMED AND READY");
	}

	private void createGUI() {
		this.statusBar = new StatusBar();
	}

	private void layoutGUI() {
		this.add(this.statusBar, BorderLayout.SOUTH);
	}
}
