package de.phyberapex.lolapi.model.dto.team;

import java.util.Date;
import java.util.List;

/**
 * This class represents the DTO "TeamDto" for the lol-static-data API by riot
 * 
 * @author Janis Walliser
 * 
 */

public class Team {

	private Date createDate;
	private String fullId;
	private Date lastGameDate;
	private Date lastJoinDate;
	private Date lastJoinedRankedTeamQueueDate;
	private List<MatchHistorySummary> matchHistory;
	private MessageOfDay messageOfDay;
	private Date modifyDate;
	private String name;
	private Roster roster;
	private Date secondLastJoinDate;
	private String status;
	private String tag;
	private TeamStatSummary teamStatSummary;
	private Date thirdLastJoinDate;

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getFullId() {
		return fullId;
	}

	public void setFullId(String fullId) {
		this.fullId = fullId;
	}

	public Date getLastGameDate() {
		return lastGameDate;
	}

	public void setLastGameDate(Date lastGameDate) {
		this.lastGameDate = lastGameDate;
	}

	public Date getLastJoinDate() {
		return lastJoinDate;
	}

	public void setLastJoinDate(Date lastJoinDate) {
		this.lastJoinDate = lastJoinDate;
	}

	public Date getLastJoinedRankedTeamQueueDate() {
		return lastJoinedRankedTeamQueueDate;
	}

	public void setLastJoinedRankedTeamQueueDate(
			Date lastJoinedRankedTeamQueueDate) {
		this.lastJoinedRankedTeamQueueDate = lastJoinedRankedTeamQueueDate;
	}

	public List<MatchHistorySummary> getMatchHistory() {
		return matchHistory;
	}

	public void setMatchHistory(List<MatchHistorySummary> matchHistory) {
		this.matchHistory = matchHistory;
	}

	public MessageOfDay getMessageOfDay() {
		return messageOfDay;
	}

	public void setMessageOfDay(MessageOfDay messageOfDay) {
		this.messageOfDay = messageOfDay;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Roster getRoster() {
		return roster;
	}

	public void setRoster(Roster roster) {
		this.roster = roster;
	}

	public Date getSecondLastJoinDate() {
		return secondLastJoinDate;
	}

	public void setSecondLastJoinDate(Date secondLastJoinDate) {
		this.secondLastJoinDate = secondLastJoinDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public TeamStatSummary getTeamStatSummary() {
		return teamStatSummary;
	}

	public void setTeamStatSummary(TeamStatSummary teamStatSummary) {
		this.teamStatSummary = teamStatSummary;
	}

	public Date getThirdLastJoinDate() {
		return thirdLastJoinDate;
	}

	public void setThirdLastJoinDate(Date thirdLastJoinDate) {
		this.thirdLastJoinDate = thirdLastJoinDate;
	}

}
