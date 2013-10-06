package de.phyberapex.lolapi.gui.servicePanel.item;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import de.phyberapex.lolapi.client.service.ChampionService;
import de.phyberapex.lolapi.gui.MainFrame;

public class ItemServicePanel extends JScrollPane {

	private static final long serialVersionUID = 1L;
	private ChampionService champService;
	private JPanel content;

	public ItemServicePanel() {
		super();
		createGUI();
		layoutGUI();
	}

	private void createGUI() {
		this.content = new JPanel();
	}

	private void layoutGUI() {
		this.content.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.fill = GridBagConstraints.BOTH;
		c.weighty = 1;
		c.weightx = 1;
		this.content.add(new AllItemsPanel(), c);
		c.weighty = 0;
		c.gridy = 1;
		this.content.add(new ItemByIdPanel(), c);
		this.setViewportView(content);
	}

	public ChampionService getChampService() {
		if (this.champService == null) {
			this.champService = MainFrame.getInstance().getClient()
					.getChampionService();
		}
		return this.champService;
	}
}