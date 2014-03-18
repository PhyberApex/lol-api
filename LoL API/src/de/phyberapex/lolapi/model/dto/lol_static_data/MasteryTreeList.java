package de.phyberapex.lolapi.model.dto.lol_static_data;

import java.util.List;

/**
 * This class represents the DTO "MasteryTreeListDto" for the lol-static-data
 * API by riot
 * 
 * @author Janis Walliser
 * 
 */

public class MasteryTreeList {

	private List<MasteryTreeItem> masteryTreeItems;

	public List<MasteryTreeItem> getMasteryTreeItems() {
		return masteryTreeItems;
	}

	public void setMasteryTreeItems(List<MasteryTreeItem> masteryTreeItems) {
		this.masteryTreeItems = masteryTreeItems;
	}

}
