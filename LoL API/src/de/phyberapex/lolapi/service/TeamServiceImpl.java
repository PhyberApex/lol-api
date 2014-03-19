package de.phyberapex.lolapi.service;

import java.util.List;

import de.phyberapex.lolapi.model.Region;

public class TeamServiceImpl extends RiotApiService implements TeamService {

	public TeamServiceImpl(String baseURL, List<Region> validRegions) {
		super(baseURL, validRegions);
	}

}
