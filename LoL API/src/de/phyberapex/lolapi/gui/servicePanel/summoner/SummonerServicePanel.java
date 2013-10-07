package de.phyberapex.lolapi.gui.servicePanel.summoner;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class SummonerServicePanel extends JScrollPane {

	private static final long serialVersionUID = 1L;

	private JPanel content;

	public SummonerServicePanel() {
		super();
		createGUI();
		layoutGUI();
	}

	private void createGUI() {
		this.content = new JPanel();
	}

	private void layoutGUI() {
		this.setViewportView(this.content);
	}
}
