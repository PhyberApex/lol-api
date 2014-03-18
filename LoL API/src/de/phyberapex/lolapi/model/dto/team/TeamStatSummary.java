package de.phyberapex.lolapi.model.dto.team;

import java.util.List;

/**
 * This class represents the DTO "TeamStatSummaryDto" for the lol-static-data API by
 * riot
 * 
 * @author Janis Walliser
 * 
 */

public class TeamStatSummary {
	
	private String fullId;
	private List<TeamStatDetail> teamStatDetails;

	public String getFullId() {
		return fullId;
	}

	public void setFullId(String fullId) {
		this.fullId = fullId;
	}

	public List<TeamStatDetail> getTeamStatDetails() {
		return teamStatDetails;
	}

	public void setTeamStatDetails(List<TeamStatDetail> teamStatDetails) {
		this.teamStatDetails = teamStatDetails;
	}

}
