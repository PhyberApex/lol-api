package de.phyberapex.lolapi.service;

import de.phyberapex.lolapi.model.Region;
import de.phyberapex.lolapi.model.dto.champion.ChampionList;
import de.phyberapex.lolapi.service.exception.ServiceException;

/**
 * This interface represents the champion service from the riot API
 * 
 * @author Janis Walliser
 * 
 */

public interface ChampionService extends Service {

	public ChampionList getAllChampions(Region region) throws ServiceException;

	public ChampionList getAllChampions(Region region, Boolean isFreeToPlay)
			throws ServiceException;
}
