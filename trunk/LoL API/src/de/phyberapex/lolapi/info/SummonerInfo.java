package de.phyberapex.lolapi.info;

public class SummonerInfo {

	private int level;
	private int accountId;
	private int summonerId;
	private String name;

	public SummonerInfo(int level, int accountId, int summonerId, String name) {
		this.level = level;
		this.accountId = accountId;
		this.summonerId = summonerId;
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getSummonerId() {
		return summonerId;
	}

	public void setSummonerId(int summonerId) {
		this.summonerId = summonerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
