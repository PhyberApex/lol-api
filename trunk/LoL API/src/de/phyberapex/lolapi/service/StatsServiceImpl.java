package de.phyberapex.lolapi.service;

import java.util.List;

import de.phyberapex.lolapi.model.Region;

public class StatsServiceImpl extends RiotApiService implements StatsService {

	public StatsServiceImpl(String baseURL, List<Region> validRegions) {
		super(baseURL, validRegions);
	}

}
