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

public class FileHelper {
	public static String readFile(String path, Charset encoding)
			throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return encoding.decode(ByteBuffer.wrap(encoded)).toString();
	}

	public static Properties readXMLPropertiesFile(String filePath)
			throws IOException {
		Properties returnValue = new Properties();
		InputStream in = new FileInputStream(new File(filePath));
		returnValue.loadFromXML(in);
		return returnValue;
	}

	public static void writeXMLPropertiesFile(String string,
			Properties lOL_LOGIN_INFO) throws FileNotFoundException, IOException {
		lOL_LOGIN_INFO.storeToXML(new FileOutputStream(new File(string)), "");
	}
}
