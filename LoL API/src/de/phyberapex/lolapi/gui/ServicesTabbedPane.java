package de.phyberapex.lolapi.gui;

import javax.swing.JTabbedPane;

import de.phyberapex.lolapi.gui.servicePanel.ChampionServicePanel;
import de.phyberapex.lolapi.gui.servicePanel.ItemServicePanel;
import de.phyberapex.lolapi.gui.servicePanel.SummonerServicePanel;
import de.phyberapex.lolapi.gui.servicePanel.SummonerSpellServicePanel;

public class ServicesTabbedPane extends JTabbedPane {

	private static final long serialVersionUID = 1L;

	private SummonerServicePanel summServPanel;
	private ChampionServicePanel champServPanel;
	private ItemServicePanel itemServPanel;
	private SummonerSpellServicePanel spellServPanel;

	public ServicesTabbedPane() {
		super();
		createGUI();
		layoutGUI();
	}

	private void createGUI() {
	//	this.summServPanel = new SummonerServicePanel();
		this.champServPanel = new ChampionServicePanel();
		this.itemServPanel = new ItemServicePanel();
		this.spellServPanel = new SummonerSpellServicePanel();
	}

	private void layoutGUI() {
		this.addTab("Summoner Service", this.summServPanel);
		this.setEnabledAt(0, false);
		this.addTab("Champion Service", this.champServPanel);
		this.addTab("Item Service", this.itemServPanel);
		this.addTab("SummonerSpell Service", this.spellServPanel);
	}

	public void setConnected(boolean connected) {
		this.setEnabledAt(0, connected);
	}
}