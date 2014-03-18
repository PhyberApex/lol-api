package de.phyberapex.lolapi.model.dto.league;

import java.util.List;

/**
 * This class represents the DTO "LeagueDto" for the league API by riot
 * 
 * @author Janis Walliser
 * 
 */

public class League {

	private List<LeagueItem> entries;
	/**
	 * This name is an internal place-holder name only. Display and localization
	 * of names in the game client are handled client-side.
	 */
	private String name;
	private String participantId;
	private Queue queue;
	private Tier tier;

	public List<LeagueItem> getEntries() {
		return entries;
	}

	public void setEntries(List<LeagueItem> entries) {
		this.entries = entries;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParticipantId() {
		return participantId;
	}

	public void setParticipantId(String participantId) {
		this.participantId = participantId;
	}

	public Queue getQueue() {
		return queue;
	}

	public void setQueue(Queue queue) {
		this.queue = queue;
	}

	public Tier getTier() {
		return tier;
	}

	public void setTier(Tier tier) {
		this.tier = tier;
	}

}
