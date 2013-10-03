package de.phyberapex.lolapi.client.service;

import de.phyberapex.lolapi.client.APIClient;

public abstract class APIService {

	protected APIClient client;

	public APIService(APIClient client) {
		this.client = client;
	}

	public APIClient getClient() {
		return this.client;
	}

	public String getName() {
		return "not defined";
	}
}
