package de.phyberapex.lolapi.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * This class is used to seperate the file handling from the config class
 * 
 * @author Janis Walliser
 *
 */

public class FileHelper {
	public static String readFile(String path, Charset encoding)
			throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return encoding.decode(ByteBuffer.wrap(encoded)).toString();
	}

	/**
	 * This method is used to read a file from the path given
	 * 
	 * @param filePath the exact path to the file to read
	 * @return
	 * @throws IOException
	 */
	public static Properties readXMLPropertiesFile(String filePath)
			throws IOException {
		Properties returnValue = new Properties();
		InputStream in = new FileInputStream(new File(filePath));
		returnValue.loadFromXML(in);
		return returnValue;
	}

	/**
	 * This method is used to store the config in a xml-file
	 * 
	 * @param path The path where it should be written to disk
	 * @param config The {@link Properties} instance which should be written to disk
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void writeXMLPropertiesFile(String path,
			Properties config) throws FileNotFoundException, IOException {
		config.storeToXML(new FileOutputStream(new File(path)), "");
	}
}
