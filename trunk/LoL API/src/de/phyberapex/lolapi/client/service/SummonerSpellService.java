package de.phyberapex.lolapi.client.service;

import java.util.List;

import de.phyberapex.lolapi.client.APIClient;
import de.phyberapex.lolapi.model.SummonerSpell;
import de.phyberapex.lolapi.model.SummonerSpellList;

public class SummonerSpellService extends APIService {

	private SummonerSpellList spellList;

	public SummonerSpellService(APIClient client) {
		super(client);
		this.spellList = new SummonerSpellList();
	}

	public List<SummonerSpell> getAllSpells() {
		return spellList.getAllSpells();
	}

	public SummonerSpell getSpellById(int id) {
		return spellList.getSpellById(id);
	}

}