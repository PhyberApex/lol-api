package de.phyberapex.lolapi.service;

import java.util.List;

import de.phyberapex.lolapi.model.Region;

/**
 * This class is the base of all services
 * 
 * @author Janis Walliser
 * 
 */

public abstract class RiotApiService implements Service {

	/**
	 * Base URL of the API
	 */
	private String baseURL;
	/**
	 * A List of all Regions where this service is enabled
	 */
	private List<Region> validRegions;

	public RiotApiService(String baseURL, List<Region> validRegions) {
		this.baseURL = baseURL;
		this.validRegions = validRegions;
	}

	public String getBaseURL() {
		return baseURL;
	}

	public void setBaseURL(String baseURL) {
		this.baseURL = baseURL;
	}

	public List<Region> getValidRegions() {
		return validRegions;
	}

	public void setValidRegions(List<Region> validRegions) {
		this.validRegions = validRegions;
	}

	/**
	 * This method check whether a region is valid for this service or not
	 * 
	 * @param region
	 *            Region to check
	 * @return
	 */
	public boolean isValidRegion(Region region) {
		boolean valid = false;
		if (validRegions.contains(region)) {
			valid = true;
		}
		return valid;
	}

}
