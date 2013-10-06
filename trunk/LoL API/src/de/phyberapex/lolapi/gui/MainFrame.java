package de.phyberapex.lolapi.gui;

import java.awt.BorderLayout;

import static de.phyberapex.lolapi.base.Constants.*;

import javax.swing.JFrame;

import de.phyberapex.lolapi.client.APIClient;
import de.phyberapex.lolapi.gui.servicePanel.ServicesTabbedPane;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private static MainFrame instance;
	private APIClient apiClient;
	private MenuBar menuBar;
	private ServicesTabbedPane content;
	private StatusBar statusBar;

	private MainFrame() {
		super(APP_NAME + " v." + APP_VERSION + " by " + APP_AUTOR);
		this.setSize(800, 600);
		this.setLayout(new BorderLayout());
		this.setLocationRelativeTo(null);
		this.apiClient = new APIClient();
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		createGUI();
		layoutGUI();
		this.statusBar.setStatusText("ARMED AND READY");
	}

	private void createGUI() {
		this.menuBar = new MenuBar(this.apiClient);
		this.content = new ServicesTabbedPane();
		this.statusBar = new StatusBar();
	}

	private void layoutGUI() {
		this.setJMenuBar(this.menuBar);
		this.add(this.content, BorderLayout.CENTER);
		this.add(this.statusBar, BorderLayout.SOUTH);
	}

	public void setStatusText(String status) {
		this.statusBar.setStatusText(status);
	}

	public APIClient getClient(){
		return this.apiClient;
	}
	
	public static synchronized MainFrame getInstance() {
		if (instance == null) {
			instance = new MainFrame();
		}
		return instance;
	}

	public void update() {
		content.setConnected(apiClient.isConnected());
	}
}
