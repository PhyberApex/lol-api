package de.phyberapex.lolapi.model;

import java.util.Set;

public class RecentGames {
	/**
	 * Collection of recent games played (max 10).
	 */
	private Set<Game> games;
	/**
	 * Summoner ID.
	 */
	private long summonerId;

	public Set<Game> getGames() {
		return games;
	}

	public void setGames(Set<Game> games) {
		this.games = games;
	}

	public long getSummonerId() {
		return summonerId;
	}

	public void setSummonerId(long summonerId) {
		this.summonerId = summonerId;
	}
}