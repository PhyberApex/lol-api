package de.phyberapex.lolapi.service;

import java.util.List;

import de.phyberapex.lolapi.model.Region;

public class SummonerServiceImpl extends RiotApiService implements SummonerService {

	public SummonerServiceImpl(String baseURL, List<Region> validRegions) {
		super(baseURL, validRegions);
	}

}
