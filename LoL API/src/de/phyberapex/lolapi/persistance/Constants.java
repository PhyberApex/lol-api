package de.phyberapex.lolapi.persistance;

import java.io.IOException;
import java.util.Properties;

import de.phyberapex.base.FileHelper;
import de.phyberapex.base.MainConstants;

public class Constants extends MainConstants {

	/* ==== Persistance stuff ==== */
	public static Properties PERSISTANCE_INFO;

	static {
		try {
			PERSISTANCE_INFO = FileHelper.readXMLPropertiesFile("lol_persistance.xml");

		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
}
