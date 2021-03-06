package de.phyberapex.lolapi.model.dto.lol_static_data;

import java.util.List;

/**
 * This class represents the DTO "ChampionDto" for the lol-static-data API by
 * riot
 * 
 * @author Janis Walliser
 * 
 */

public class Champion {

	private List<String> allytips;
	private String blurb;
	private List<String> enemytips;
	private String id;
	private Image image;
	private Info info;
	private String key;
	private String lore;
	private String name;
	private String partype;
	private Passive passive;
	private Recommended recommended;
	private List<Skin> skins;
	private List<ChampionSpell> spells;
	private Stats stats;
	private List<String> tags;
	private String title;

	public List<String> getAllytips() {
		return allytips;
	}

	public void setAllytips(List<String> allytips) {
		this.allytips = allytips;
	}

	public String getBlurb() {
		return blurb;
	}

	public void setBlurb(String blurb) {
		this.blurb = blurb;
	}

	public List<String> getEnemytips() {
		return enemytips;
	}

	public void setEnemytips(List<String> enemytips) {
		this.enemytips = enemytips;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getLore() {
		return lore;
	}

	public void setLore(String lore) {
		this.lore = lore;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPartype() {
		return partype;
	}

	public void setPartype(String partype) {
		this.partype = partype;
	}

	public Passive getPassive() {
		return passive;
	}

	public void setPassive(Passive passive) {
		this.passive = passive;
	}

	public Recommended getRecommended() {
		return recommended;
	}

	public void setRecommended(Recommended recommended) {
		this.recommended = recommended;
	}

	public List<Skin> getSkins() {
		return skins;
	}

	public void setSkins(List<Skin> skins) {
		this.skins = skins;
	}

	public List<ChampionSpell> getSpells() {
		return spells;
	}

	public void setSpells(List<ChampionSpell> spells) {
		this.spells = spells;
	}

	public Stats getStats() {
		return stats;
	}

	public void setStats(Stats stats) {
		this.stats = stats;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
