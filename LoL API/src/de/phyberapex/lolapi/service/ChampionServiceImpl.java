package de.phyberapex.lolapi.service;

import java.util.List;

import com.google.gson.Gson;

import de.phyberapex.lolapi.model.Region;
import de.phyberapex.lolapi.model.dto.champion.ChampionList;
import de.phyberapex.lolapi.service.exception.BadRequestException;
import de.phyberapex.lolapi.service.exception.InternalServerErrorException;
import de.phyberapex.lolapi.service.exception.InvalidRegionException;
import de.phyberapex.lolapi.service.exception.RequestException;
import de.phyberapex.lolapi.service.exception.ServiceException;
import de.phyberapex.lolapi.service.exception.ServiceUnavailableException;
import de.phyberapex.lolapi.service.exception.UnauthorizedException;

public class ChampionServiceImpl extends RiotApiService implements
		ChampionService {

	public ChampionServiceImpl(String baseURL, List<Region> validRegions) {
		super(baseURL, validRegions);
	}

	@Override
	public ChampionList getAllChampions(Region region) throws ServiceException {
		return getAllChampions(region, null);
	}

	@Override
	public ChampionList getAllChampions(Region region, Boolean isFreeToPlay)
			throws ServiceException {
		ChampionList returnValue = null;
		if (getValidRegions().contains(region)) {

			String requestURL = getBaseURL() + region.toString()
					+ "/v1.1/champion";
			if (isFreeToPlay != null && isFreeToPlay) {
				requestURL = requestURL + "?freeToPlay=1&";
			} else if (isFreeToPlay != null && !isFreeToPlay) {
				requestURL = requestURL + "?freeToPlay=0&";
			} else {
				requestURL = requestURL + "?";
			}
			try {
				String response = APIRequestHelper.request(requestURL);
				Gson g = new Gson();
				returnValue = g.fromJson(response, ChampionList.class);
			} catch (RequestException e) {
				switch (e.getErrorCode()) {
				case 400:
					throw new BadRequestException();
				case 401:
					throw new UnauthorizedException();
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
