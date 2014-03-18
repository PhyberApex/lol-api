package de.phyberapex.lolapi.model.dto.lol_static_data;

/**
 * This class represents the DTO "MasteryTreeItemDto" for the lol-static-data
 * API by riot
 * 
 * @author Janis Walliser
 * 
 */

public class MasteryTreeItem {

	private String masteryId;
	private String prereq;

	public String getMasteryId() {
		return masteryId;
	}

	public void setMasteryId(String masteryId) {
		this.masteryId = masteryId;
	}

	public String getPrereq() {
		return prereq;
	}

	public void setPrereq(String prereq) {
		this.prereq = prereq;
	}

}
