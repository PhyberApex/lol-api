package de.phyberapex.lolapi.model.dto.team;

import java.util.Date;

/**
 * This class represents the DTO "TeamMemberInfoDto" for the lol-static-data API by
 * riot
 * 
 * @author Janis Walliser
 * 
 */

public class TeamMemberInfo {
	
	private Date inviteDate;
	private Date joinDate;
	private long playerId;
	private String status;

	public Date getInviteDate() {
		return inviteDate;
	}

	public void setInviteDate(Date inviteDate) {
		this.inviteDate = inviteDate;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(long playerId) {
		this.playerId = playerId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
