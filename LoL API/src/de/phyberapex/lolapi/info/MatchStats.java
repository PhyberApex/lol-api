package de.phyberapex.lolapi.info;

import java.util.Date;

import de.phyberapex.lolapi.model.Champion;
import de.phyberapex.lolapi.model.FellowPlayer;
import de.phyberapex.lolapi.model.Item;
import de.phyberapex.lolapi.model.SummonerSpell;

public class MatchStats {

	private long gameId;
	private String summonerName;

	private boolean win;
	private Champion ownChamp;
	private FellowPlayer[] ownTeam = new FellowPlayer[4];
	private FellowPlayer[] enemyTeam = new FellowPlayer[5];

	private SummonerSpell spell1;
	private SummonerSpell spell2;

	private int ping;
	private int amountPremade;
	private int ipEarned;
	private int eloChange;

	private Date createDate;
	private GameMode gameMode;
	private QueueType queueType;
	private GameMap map;
	private boolean leaver;
	private Item[] items = new Item[6];

	private int goldEarned;
	private int level;

	private int dmgDealt;
	private int magicDmgDealtToChamps;
	private int physicalDmgDealtToChamps;
	private int trueDmgToChamps;
	private int totalDmgDealtToChamps;
	private int largestCrit;
	private int largestMultikill;
	private int largestKillingSpree;
	private int crowdControlDealt;
	private int ownJungleMinionsKilled;
	private int enemyJungleMinionsKilled;

	private int sightWardsBought;
	private int visionWardsBought;
	private int wardsKilled;
	private int wardsPlaced;

	private int physicalDmgTaken;
	private int magicDmgTaken;
	private int trueDmgTaken;
	private int totalDmgTaken;
	private int totalHeal;

	private int timeSpentDead;

	private int deaths;
	private int kills;
	private int assists;
	private int minionsKilled;
	private int neutralMinionsKilled;

	private int turretsKilled;
	private int barracksKilled;

	public long getGameId() {
		return gameId;
	}

	public void setGameId(long gameId) {
		this.gameId = gameId;
	}

	public String getSummonerName() {
		return summonerName;
	}

	public void setSummonerName(String summonerName) {
		this.summonerName = summonerName;
	}

	public boolean isWin() {
		return win;
	}

	public void setWin(boolean win) {
		this.win = win;
	}

	public Champion getOwnChamp() {
		return ownChamp;
	}

	public void setOwnChamp(Champion ownChamp) {
		this.ownChamp = ownChamp;
	}

	public FellowPlayer[] getOwnTeam() {
		return ownTeam;
	}

	public void setOwnTeam(FellowPlayer[] ownTeam) {
		this.ownTeam = ownTeam;
	}

	public FellowPlayer[] getEnemyTeam() {
		return enemyTeam;
	}

	public void setEnemyTeam(FellowPlayer[] enemyTeam) {
		this.enemyTeam = enemyTeam;
	}

	public SummonerSpell getSpell1() {
		return spell1;
	}

	public void setSpell1(SummonerSpell spell1) {
		this.spell1 = spell1;
	}

	public SummonerSpell getSpell2() {
		return spell2;
	}

	public void setSpell2(SummonerSpell spell2) {
		this.spell2 = spell2;
	}

	public int getPing() {
		return ping;
	}

	public void setPing(int ping) {
		this.ping = ping;
	}

	public int getAmountPremade() {
		return amountPremade;
	}

	public void setAmountPremade(int amountPremade) {
		this.amountPremade = amountPremade;
	}

	public int getIpEarned() {
		return ipEarned;
	}

	public void setIpEarned(int ipEarned) {
		this.ipEarned = ipEarned;
	}

	public int getEloChange() {
		return eloChange;
	}

	public void setEloChange(int eloChange) {
		this.eloChange = eloChange;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public GameMode getGameMode() {
		return gameMode;
	}

	public void setGameMode(GameMode gameMode) {
		this.gameMode = gameMode;
	}

	public QueueType getQueueType() {
		return queueType;
	}

	public void setQueueType(QueueType queueType) {
		this.queueType = queueType;
	}

	public GameMap getMap() {
		return map;
	}

	public void setMap(GameMap map) {
		this.map = map;
	}

	public boolean isLeaver() {
		return leaver;
	}

	public void setLeaver(boolean leaver) {
		this.leaver = leaver;
	}

	public Item[] getItems() {
		return items;
	}

	public void setItems(Item[] items) {
		this.items = items;
	}

	public int getGoldEarned() {
		return goldEarned;
	}

	public void setGoldEarned(int goldEarned) {
		this.goldEarned = goldEarned;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getDmgDealt() {
		return dmgDealt;
	}

	public void setDmgDealt(int dmgDealt) {
		this.dmgDealt = dmgDealt;
	}

	public int getMagicDmgDealtToChamps() {
		return magicDmgDealtToChamps;
	}

	public void setMagicDmgDealtToChamps(int magicDmgDealtToChamps) {
		this.magicDmgDealtToChamps = magicDmgDealtToChamps;
	}

	public int getPhysicalDmgDealtToChamps() {
		return physicalDmgDealtToChamps;
	}

	public void setPhysicalDmgDealtToChamps(int physicalDmgDealtToChamps) {
		this.physicalDmgDealtToChamps = physicalDmgDealtToChamps;
	}

	public int getTrueDmgToChamps() {
		return trueDmgToChamps;
	}

	public void setTrueDmgToChamps(int trueDmgToChamps) {
		this.trueDmgToChamps = trueDmgToChamps;
	}

	public int getTotalDmgDealtToChamps() {
		return totalDmgDealtToChamps;
	}

	public void setTotalDmgDealtToChamps(int totalDmgDealtToChamps) {
		this.totalDmgDealtToChamps = totalDmgDealtToChamps;
	}

	public int getLargestCrit() {
		return largestCrit;
	}

	public void setLargestCrit(int largestCrit) {
		this.largestCrit = largestCrit;
	}

	public int getLargestMultikill() {
		return largestMultikill;
	}

	public void setLargestMultikill(int largestMultikill) {
		this.largestMultikill = largestMultikill;
	}

	public int getLargestKillingSpree() {
		return largestKillingSpree;
	}

	public void setLargestKillingSpree(int largestKillingSpree) {
		this.largestKillingSpree = largestKillingSpree;
	}

	public int getCrowdControlDealt() {
		return crowdControlDealt;
	}

	public void setCrowdControlDealt(int crowdControlDealt) {
		this.crowdControlDealt = crowdControlDealt;
	}

	public int getOwnJungleMinionsKilled() {
		return ownJungleMinionsKilled;
	}

	public void setOwnJungleMinionsKilled(int ownJungleMinionsKilled) {
		this.ownJungleMinionsKilled = ownJungleMinionsKilled;
	}

	public int getEnemyJungleMinionsKilled() {
		return enemyJungleMinionsKilled;
	}

	public void setEnemyJungleMinionsKilled(int enemyJungleMinionsKilled) {
		this.enemyJungleMinionsKilled = enemyJungleMinionsKilled;
	}

	public int getSightWardsBought() {
		return sightWardsBought;
	}

	public void setSightWardsBought(int sightWardsBought) {
		this.sightWardsBought = sightWardsBought;
	}

	public int getVisionWardsBought() {
		return visionWardsBought;
	}

	public void setVisionWardsBought(int visionWardsBought) {
		this.visionWardsBought = visionWardsBought;
	}

	public int getWardsKilled() {
		return wardsKilled;
	}

	public void setWardsKilled(int wardsKilled) {
		this.wardsKilled = wardsKilled;
	}

	public int getWardsPlaced() {
		return wardsPlaced;
	}

	public void setWardsPlaced(int wardsPlaced) {
		this.wardsPlaced = wardsPlaced;
	}

	public int getPhysicalDmgTaken() {
		return physicalDmgTaken;
	}

	public void setPhysicalDmgTaken(int physicalDmgTaken) {
		this.physicalDmgTaken = physicalDmgTaken;
	}

	public int getMagicDmgTaken() {
		return magicDmgTaken;
	}

	public void setMagicDmgTaken(int magicDmgTaken) {
		this.magicDmgTaken = magicDmgTaken;
	}

	public int getTrueDmgTaken() {
		return trueDmgTaken;
	}

	public void setTrueDmgTaken(int trueDmgTaken) {
		this.trueDmgTaken = trueDmgTaken;
	}

	public int getTotalDmgTaken() {
		return totalDmgTaken;
	}

	public void setTotalDmgTaken(int totalDmgTaken) {
		this.totalDmgTaken = totalDmgTaken;
	}

	public int getTotalHeal() {
		return totalHeal;
	}

	public void setTotalHeal(int totalHeal) {
		this.totalHeal = totalHeal;
	}

	public int getTimeSpentDead() {
		return timeSpentDead;
	}

	public void setTimeSpentDead(int timeSpentDead) {
		this.timeSpentDead = timeSpentDead;
	}

	public int getDeaths() {
		return deaths;
	}

	public void setDeaths(int deaths) {
		this.deaths = deaths;
	}

	public int getKills() {
		return kills;
	}

	public void setKills(int kills) {
		this.kills = kills;
	}

	public int getAssists() {
		return assists;
	}

	public void setAssists(int assists) {
		this.assists = assists;
	}

	public int getMinionsKilled() {
		return minionsKilled;
	}

	public void setMinionsKilled(int minionsKilled) {
		this.minionsKilled = minionsKilled;
	}

	public int getNeutralMinionsKilled() {
		return neutralMinionsKilled;
	}

	public void setNeutralMinionsKilled(int neutralMinionsKilled) {
		this.neutralMinionsKilled = neutralMinionsKilled;
	}

	public int getTurretsKilled() {
		return turretsKilled;
	}

	public void setTurretsKilled(int turretsKilled) {
		this.turretsKilled = turretsKilled;
	}

	public int getBarracksKilled() {
		return barracksKilled;
	}

	public void setBarracksKilled(int barracksKilled) {
		this.barracksKilled = barracksKilled;
	}
}
