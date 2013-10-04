package de.phyberapex.lolapi.client.service;

import java.util.List;

import de.phyberapex.lolapi.client.APIClient;
import de.phyberapex.lolapi.model.Champion;
import de.phyberapex.lolapi.model.ChampionList;

public class ChampionService extends APIService {

	private ChampionList champList;

	public ChampionService(APIClient client) {
		super(client);
		this.champList = new ChampionList();
	}

	public List<Champion> getAllChampions() {
		return champList.getAllChamps();
	}

	public Champion getChampionById(int id) {
		return champList.getChampionById(id);
	}

}
