package de.phyberapex.lolapi.service;

import de.phyberapex.lolapi.model.Region;
import de.phyberapex.lolapi.model.dto.champion.ChampionList;

/**
 * This interface represents the champion service from the riot API
 * 
 * @author Janis Walliser
 * 
 */

public interface ChampionService extends Service {

	public ChampionList getAllChampions(Region region);

	public ChampionList getAllChampions(Region region, Boolean isFreeToPlay);
}
