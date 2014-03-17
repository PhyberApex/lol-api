package de.phyberapex.lolapi.model;

import java.util.List;

public class ChampionList {
	/**
	 * The collection of champion information.
	 */
	private List<Champion> champions;

	public List<Champion> getChampions() {
		return champions;
	}

	public void setChampions(List<Champion> champions) {
		this.champions = champions;
	}

}
