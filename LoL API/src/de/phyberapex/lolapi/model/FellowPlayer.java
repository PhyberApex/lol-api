package de.phyberapex.lolapi.model;

public class FellowPlayer {

	private String summonerName;
	private Champion champion;

	public FellowPlayer(){
		
	}
	
	public FellowPlayer(String name, Champion champion){
		this.summonerName = name;
		this.champion = champion;
	}
	
	public String getSummonerName() {
		return summonerName;
	}

	public void setSummonerName(String summonerName) {
		this.summonerName = summonerName;
	}

	public Champion getChampion() {
		return champion;
	}

	public void setChampion(Champion champion) {
		this.champion = champion;
	}
}
