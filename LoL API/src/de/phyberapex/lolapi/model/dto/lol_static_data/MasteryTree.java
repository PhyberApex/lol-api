package de.phyberapex.lolapi.model.dto.lol_static_data;

import java.util.List;

/**
 * This class represents the DTO "MasteryTreeDto" for the lol-static-data API by
 * riot
 * 
 * @author Janis Walliser
 * 
 */

public class MasteryTree {

	private List<MasteryTreeList> Defense;
	private List<MasteryTreeList> Offense;
	private List<MasteryTreeList> Utility;

	public List<MasteryTreeList> getDefense() {
		return Defense;
	}

	public void setDefense(List<MasteryTreeList> defense) {
		Defense = defense;
	}

	public List<MasteryTreeList> getOffense() {
		return Offense;
	}

	public void setOffense(List<MasteryTreeList> offense) {
		Offense = offense;
	}

	public List<MasteryTreeList> getUtility() {
		return Utility;
	}

	public void setUtility(List<MasteryTreeList> utility) {
		Utility = utility;
	}

}
