package de.phyberapex.lolapi.gui;

import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StatusBar extends JPanel {

	private static final long serialVersionUID = 1L;

	private JLabel statusText;

	public StatusBar() {
		super();
		createGUI();
		layoutGUI();
	}

	private void createGUI() {
		this.setBorder(BorderFactory.createLoweredBevelBorder());
		this.statusText = new JLabel();
	}

	private void layoutGUI() {
		this.setLayout(new FlowLayout());
		this.add(statusText, FlowLayout.LEFT);
	}

	public void setStatusText(String statusText) {
		this.statusText.setText(statusText);
	}

}
