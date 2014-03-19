package de.phyberapex.lolapi.service;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import de.phyberapex.lolapi.model.LeagueType;
import de.phyberapex.lolapi.model.Region;
import de.phyberapex.lolapi.model.dto.league.League;
import de.phyberapex.lolapi.model.dto.league.LeagueItem;
import de.phyberapex.lolapi.service.exception.BadRequestException;
import de.phyberapex.lolapi.service.exception.GameDataNotFoundException;
import de.phyberapex.lolapi.service.exception.InternalServerErrorException;
import de.phyberapex.lolapi.service.exception.InvalidRegionException;
import de.phyberapex.lolapi.service.exception.RateLimitExceededException;
import de.phyberapex.lolapi.service.exception.RequestException;
import de.phyberapex.lolapi.service.exception.ServiceException;
import de.phyberapex.lolapi.service.exception.ServiceUnavailableException;
import de.phyberapex.lolapi.service.exception.UnauthorizedException;

public class LeagueServiceImpl extends RiotApiService implements LeagueService {

	public LeagueServiceImpl(String baseURL, List<Region> validRegions) {
		super(baseURL, validRegions);
	}

	@Override
	public List<League> getCompleteSummonerLeagues(Region region,
			long summonerId) throws ServiceException {
		List<League> returnValue = null;
		if (getValidRegions().contains(region)) {

			String requestURL = getBaseURL() + region.toString()
					+ "/v2.3/league/by-summoner/" + summonerId + "?";
			try {
				String response = APIRequestHelper.request(requestURL);
				Gson g = new Gson();
				returnValue = g.fromJson(response,
						new TypeToken<List<League>>() {
						}.getType());
			} catch (RequestException e) {
				switch (e.getErrorCode()) {
				case 400:
					throw new BadRequestException();
				case 401:
					throw new UnauthorizedException();
				case 404:
					throw new GameDataNotFoundException();
				case 429:
					throw new RateLimitExceededException();
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

	@Override
	public List<LeagueItem> getSummonerLeagueEntries(Region region,
			long summonerId) throws ServiceException {
		List<LeagueItem> returnValue = null;
		if (getValidRegions().contains(region)) {

			String requestURL = getBaseURL() + region.toString()
					+ "/v2.3/league/by-summoner/" + summonerId + "/entry?";
			try {
				String response = APIRequestHelper.request(requestURL);
				Gson g = new Gson();
				returnValue = g.fromJson(response,
						new TypeToken<List<LeagueItem>>() {
						}.getType());
			} catch (RequestException e) {
				switch (e.getErrorCode()) {
				case 400:
					throw new BadRequestException();
				case 401:
					throw new UnauthorizedException();
				case 404:
					throw new GameDataNotFoundException();
				case 429:
					throw new RateLimitExceededException();
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

	@Override
	public List<League> getTeamLeagues(Region region, long teamId)
			throws ServiceException {
		List<League> returnValue = null;
		if (getValidRegions().contains(region)) {

			String requestURL = getBaseURL() + region.toString()
					+ "/v2.3/league/by-team/" + teamId + "?";
			try {
				String response = APIRequestHelper.request(requestURL);
				Gson g = new Gson();
				returnValue = g.fromJson(response,
						new TypeToken<List<League>>() {
						}.getType());
			} catch (RequestException e) {
				switch (e.getErrorCode()) {
				case 400:
					throw new BadRequestException();
				case 401:
					throw new UnauthorizedException();
				case 404:
					throw new GameDataNotFoundException();
				case 429:
					throw new RateLimitExceededException();
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

	@Override
	public List<LeagueItem> getTeamLeagueEntries(Region region, long teamId)
			throws ServiceException {
		List<LeagueItem> returnValue = null;
		if (getValidRegions().contains(region)) {

			String requestURL = getBaseURL() + region.toString()
					+ "/v2.3/league/by-team/" + teamId + "/entry?";
			try {
				String response = APIRequestHelper.request(requestURL);
				Gson g = new Gson();
				returnValue = g.fromJson(response,
						new TypeToken<List<LeagueItem>>() {
						}.getType());
			} catch (RequestException e) {
				switch (e.getErrorCode()) {
				case 400:
					throw new BadRequestException();
				case 401:
					throw new UnauthorizedException();
				case 404:
					throw new GameDataNotFoundException();
				case 429:
					throw new RateLimitExceededException();
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

	@Override
	public League getChallengerLeague(Region region, LeagueType league)
			throws ServiceException {
		League returnValue = null;
		if (getValidRegions().contains(region)) {

			String requestURL = getBaseURL() + region.toString()
					+ "/v2.3/league/challenger?type=" + league + "&";
			try {
				String response = APIRequestHelper.request(requestURL);
				Gson g = new Gson();
				returnValue = g.fromJson(response, League.class);
			} catch (RequestException e) {
				switch (e.getErrorCode()) {
				case 400:
					throw new BadRequestException();
				case 401:
					throw new UnauthorizedException();
				case 404:
					throw new GameDataNotFoundException();
				case 429:
					throw new RateLimitExceededException();
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
