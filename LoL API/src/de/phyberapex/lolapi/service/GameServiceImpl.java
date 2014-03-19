package de.phyberapex.lolapi.service;

import java.util.List;

import com.google.gson.Gson;

import de.phyberapex.lolapi.model.Region;
import de.phyberapex.lolapi.model.dto.game.RecentGames;
import de.phyberapex.lolapi.service.exception.BadRequestException;
import de.phyberapex.lolapi.service.exception.GameDataNotFoundException;
import de.phyberapex.lolapi.service.exception.InternalServerErrorException;
import de.phyberapex.lolapi.service.exception.InvalidRegionException;
import de.phyberapex.lolapi.service.exception.RequestException;
import de.phyberapex.lolapi.service.exception.ServiceUnavailableException;
import de.phyberapex.lolapi.service.exception.UnauthorizedException;

public class GameServiceImpl extends RiotApiService implements GameService {

	public GameServiceImpl(String baseURL, List<Region> validRegions) {
		super(baseURL, validRegions);
	}

	@Override
	public RecentGames getRecentGames(Region region, long summonerId)
			throws BadRequestException, UnauthorizedException,
			GameDataNotFoundException, InternalServerErrorException,
			ServiceUnavailableException, InvalidRegionException {
		RecentGames returnValue = null;
		if (getValidRegions().contains(region)) {

			String requestURL = getBaseURL() + region.toString()
					+ "/v1.3/game/by-summoner/" + summonerId + "/recent?";
			try {
				String response = APIRequestHelper.request(requestURL);
				Gson g = new Gson();
				returnValue = g.fromJson(response, RecentGames.class);
			} catch (RequestException e) {
				switch (e.getErrorCode()) {
				case 400:
					throw new BadRequestException();
				case 401:
					throw new UnauthorizedException();
				case 404:
					throw new GameDataNotFoundException();
				case 500:
					throw new InternalServerErrorException();
				case 503:
					throw new ServiceUnavailableException();
				}
			}
		} else {
			throw new InvalidRegionException();
		}
		return returnValue;
	}

}
