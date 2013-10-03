package de.phyberapex.lolapi.client.persistence;

public class SaveConfiguration {

	private SaveData data;
	private String parameter;

	public SaveConfiguration(SaveData toSave, String summonername) {
		this.data = toSave;
		this.parameter = summonername;
	}

	public SaveData getData() {
		return data;
	}

	public void setData(SaveData data) {
		this.data = data;
	}

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}
}
