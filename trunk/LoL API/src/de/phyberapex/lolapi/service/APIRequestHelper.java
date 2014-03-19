package de.phyberapex.lolapi.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import de.phyberapex.lolapi.base.Config;

public class APIRequestHelper {

	public static String request(String requestURL) {
		try {
			int timeout = 5000;
			URL u = new URL(requestURL+"api_key="+Config.getInstance().getApikey());
			HttpURLConnection c = (HttpURLConnection) u.openConnection();
			c.setRequestMethod("GET");
			c.setRequestProperty("Content-length", "0");
			c.setUseCaches(false);
			c.setAllowUserInteraction(false);
			c.setConnectTimeout(timeout);
			c.setReadTimeout(timeout);
			c.connect();
			int status = c.getResponseCode();

			switch (status) {
			case 200:
			case 201:
				BufferedReader br = new BufferedReader(new InputStreamReader(
						c.getInputStream()));
				StringBuilder sb = new StringBuilder();
				String line;
				while ((line = br.readLine()) != null) {
					sb.append(line + "\n");
				}
				br.close();
				return sb.toString();
			}

		} catch (MalformedURLException ex) {
			// Logger.getLogger(DebugServer.class.getName()).log(Level.SEVERE,
			// null, ex);
		} catch (IOException ex) {
			// Logger.getLogger(DebugServer.class.getName()).log(Level.SEVERE,
			// null, ex);
		}
		return null;
	}

}
