package de.phyberapex.lolapi.service;

import java.util.List;

import com.google.gson.Gson;

import de.phyberapex.lolapi.model.Region;
import de.phyberapex.lolapi.model.dto.champion.ChampionList;

public class ChampionServiceImpl extends RiotApiService implements
		ChampionService {

	public ChampionServiceImpl(String baseURL, List<Region> validRegions) {
		super(baseURL, validRegions);
	}

	@Override
	public ChampionList getAllChampions(Region region) {
		return getAllChampions(region, null);
	}

	@Override
	public ChampionList getAllChampions(Region region, Boolean isFreeToPlay) {
		ChampionList returnValue = null;
		if (getValidRegions().contains(region)) {

			String requestURL = getBaseURL() + region.toString()
					+ "/v1.1/champion";
			if (isFreeToPlay != null && isFreeToPlay) {
				requestURL = requestURL + "?freeToPlay=1&";
			} else if (isFreeToPlay != null && !isFreeToPlay) {
				requestURL = requestURL + "?freeToPlay=1&";
			} else {
				requestURL = requestURL + "?";
			}
			String response = APIRequestHelper.request(requestURL);
			Gson g = new Gson();
			returnValue = g.fromJson(response, ChampionList.class);
		} else {

		}
		return returnValue;
	}
}
