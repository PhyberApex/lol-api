package de.phyberapex.lolapi.model;

public enum Region {
	BR("br"), EUNE("eune"), EUW("euw"), KR("kr"), LAN("lan"), LAS("las"), NA(
			"na"), OCE("oce"), RU("ru"), TR("tr");

	private String name;

	Region(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.name;
	}
}
