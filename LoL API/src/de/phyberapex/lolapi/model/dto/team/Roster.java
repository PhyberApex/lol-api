package de.phyberapex.lolapi.model.dto.team;

import java.util.List;

/**
 * This class represents the DTO "RosterDto" for the lol-static-data API by riot
 * 
 * @author Janis Walliser
 * 
 */

public class Roster {
	
	private List<TeamMemberInfo> memberList;
	private long ownerId;
	public List<TeamMemberInfo> getMemberList() {
		return memberList;
	}
	public void setMemberList(List<TeamMemberInfo> memberList) {
		this.memberList = memberList;
	}
	public long getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(long ownerId) {
		this.ownerId = ownerId;
	}

}
