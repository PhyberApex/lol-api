package de.phyberapex.lolapi.service;

import java.util.List;

import de.phyberapex.lolapi.model.Region;

public class LoLStaticDataServiceImpl extends RiotApiService implements LoLStaticDataService {

	public LoLStaticDataServiceImpl(String baseURL, List<Region> validRegions) {
		super(baseURL, validRegions);
	}

}
