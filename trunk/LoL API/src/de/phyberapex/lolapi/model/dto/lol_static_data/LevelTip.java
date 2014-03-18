package de.phyberapex.lolapi.model.dto.lol_static_data;

import java.util.List;

/**
 * This class represents the DTO "LevelTipDto" for the lol-static-data API by
 * riot
 * 
 * @author Janis Walliser
 * 
 */

public class LevelTip {

	private List<String> effect;
	private List<String> label;

	public List<String> getEffect() {
		return effect;
	}

	public void setEffect(List<String> effect) {
		this.effect = effect;
	}

	public List<String> getLabel() {
		return label;
	}

	public void setLabel(List<String> label) {
		this.label = label;
	}

}
