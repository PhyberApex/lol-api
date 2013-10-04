package de.phyberapex.lolapi.client.service;

import java.util.List;

import de.phyberapex.lolapi.client.APIClient;
import de.phyberapex.lolapi.model.SummonerSpell;
import de.phyberapex.lolapi.model.SummonerSpellList;

public class SummonerSpellService extends APIService {

	public SummonerSpellService(APIClient client) {
		super(client);
	}

	public List<SummonerSpell> getAllItems() {
		return SummonerSpellList.getAllSpells();
	}

	public SummonerSpell getItemById(int id) {
		return SummonerSpellList.getSpellById(id);
	}

}