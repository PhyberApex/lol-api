package de.phyberapex.lolapi.client.service;

import java.util.List;

import de.phyberapex.lolapi.client.APIClient;
import de.phyberapex.lolapi.model.Champion;
import de.phyberapex.lolapi.model.ChampionList;

public class ChampionService extends APIService{

	public ChampionService(APIClient client) {
		super(client);
	}

	public List<Champion> getAllChampions(){
		return ChampionList.getAllChamps();
	}
	
	public Champion getChampionById(int id){
		return ChampionList.getChampionById(id);
	}
	
}
