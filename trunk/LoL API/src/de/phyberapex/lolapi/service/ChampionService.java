package de.phyberapex.lolapi.service;

import de.phyberapex.lolapi.model.Region;
import de.phyberapex.lolapi.model.dto.champion.ChampionList;
import de.phyberapex.lolapi.service.exception.BadRequestException;
import de.phyberapex.lolapi.service.exception.InternalServerErrorException;
import de.phyberapex.lolapi.service.exception.InvalidRegionException;
import de.phyberapex.lolapi.service.exception.ServiceUnavailableException;
import de.phyberapex.lolapi.service.exception.UnauthorizedException;

/**
 * This interface represents the champion service from the riot API
 * 
 * @author Janis Walliser
 * 
 */

public interface ChampionService extends Service {

	public ChampionList getAllChampions(Region region)
			throws InvalidRegionException, BadRequestException,
			UnauthorizedException, InternalServerErrorException,
			ServiceUnavailableException;

	public ChampionList getAllChampions(Region region, Boolean isFreeToPlay)
			throws InvalidRegionException, BadRequestException,
			UnauthorizedException, InternalServerErrorException,
			ServiceUnavailableException;;
}
