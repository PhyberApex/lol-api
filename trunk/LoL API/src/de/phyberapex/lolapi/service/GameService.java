package de.phyberapex.lolapi.service;

import de.phyberapex.lolapi.model.Region;
import de.phyberapex.lolapi.model.dto.game.RecentGames;
import de.phyberapex.lolapi.service.exception.BadRequestException;
import de.phyberapex.lolapi.service.exception.GameDataNotFoundException;
import de.phyberapex.lolapi.service.exception.InternalServerErrorException;
import de.phyberapex.lolapi.service.exception.InvalidRegionException;
import de.phyberapex.lolapi.service.exception.ServiceUnavailableException;
import de.phyberapex.lolapi.service.exception.UnauthorizedException;

/**
 * This interface represents the game service from the riot API
 * 
 * @author Janis Walliser
 * 
 */

public interface GameService extends Service {

	public RecentGames getRecentGames(Region region, long summonerId)
			throws BadRequestException, UnauthorizedException,
			GameDataNotFoundException, InternalServerErrorException,
			ServiceUnavailableException, InvalidRegionException;

}
