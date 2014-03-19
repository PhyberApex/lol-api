package de.phyberapex.lolapi.base;

import java.io.IOException;
import java.util.Properties;

/**
 * This class is used to configure all aspects of lolapi
 * 
 * @author Janis Walliser
 * 
 */

public class Config {

	private Mode mode;
	private static Config instance;
	private Properties api_config;
	private Properties persistence_config;
	private String apikey;

	private Config() {

	}

	public static synchronized Config getInstance() {
		if (instance == null) {
			instance = new Config();
		}
		return instance;
	}

	public Mode getMode() {
		return mode;
	}

	public void setMode(Mode mode) throws IOException {
		if (this.mode == null) {
			this.mode = mode;
			loadFile();
		}
	}

	public String getApikey() {
		return apikey;
	}

	public void setApikey(String apikey) {
		this.apikey = apikey;
	}

	private void loadFile() throws IOException {
		if (mode != Mode.API) {
			api_config = FileHelper.readXMLPropertiesFile("api_config.xml");
		}
		if (mode == Mode.PERSISTENCE) {
			persistence_config = FileHelper
					.readXMLPropertiesFile("persistence_config.xml");
		}
		this.setApikey(api_config.getProperty("API_KEY"));
	}

	public void createNeededFiles() {
		api_config = new Properties();
		api_config.setProperty("API_KEY", "INSERT_API_KEY_HERE");
		try {
			FileHelper.writeXMLPropertiesFile("api_config.xml.ex",
					api_config);
			if (mode == Mode.PERSISTENCE) {
				persistence_config = new Properties();
				persistence_config.setProperty("DATABASE_FILE",
						"INSERT_NAME_OF_DATABASE_HERE");
				FileHelper.writeXMLPropertiesFile(
						"persistence_config.xml.ex", persistence_config);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}