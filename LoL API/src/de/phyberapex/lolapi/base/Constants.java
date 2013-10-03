package de.phyberapex.lolapi.base;

import java.io.IOException;
import java.util.Properties;

import com.gvaneyck.rtmp.ServerInfo;

import de.phyberapex.base.FileHelper;
import de.phyberapex.base.MainConstants;

public class Constants extends MainConstants {

	/* ==== Basic stuff ==== */
	public static final String APP_NAME = "LoLAPI";
	public static final String APP_VERSION = "0.01";
	public static final String APP_AUTOR = "Phyber.Apex";
	public static final boolean DEV_VERSION = true;

	/* ==== LoL login stuff ==== */
	public static final String LOL_LOGIN;
	public static final String LOL_PASSWORD;
	public static final String LOL_CLIENT_VERSION;
	public static final ServerInfo LOL_SERVER;
	
	/* ==== Persistance stuff ==== */
	public static final String SQLITE_FILEPATH;

	static {
		Properties props = null;
		try {
			props = FileHelper.readXMLPropertiesFile("lol_login.xml");

		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
		SQLITE_FILEPATH = props.getProperty("DATABASE_PATH");
		LOL_LOGIN = props.getProperty("LOGINNAME");
		LOL_PASSWORD = props.getProperty("PASSWORD");
		LOL_CLIENT_VERSION = props.getProperty("CLIENT_VERSION");
		ServerInfo serv;
		switch (props.getProperty("SERVER")) {
		case "NA":
			serv = ServerInfo.NA;
			break;
		case "EUW":
			serv = ServerInfo.EUW;
			break;
		case "EUNE":
			serv = ServerInfo.EUNE;
			break;
		case "KR":
			serv = ServerInfo.KR;
			break;
		case "BR":
			serv = ServerInfo.BR;
			break;
		case "TR":
			serv = ServerInfo.TR;
			break;
		case "RU":
			serv = ServerInfo.RU;
			break;
		case "LAN":
			serv = ServerInfo.LAN;
			break;
		case "LAS":
			serv = ServerInfo.LAS;
			break;
		case "OCE":
			serv = ServerInfo.OCE;
			break;
		case "PBE":
			serv = ServerInfo.PBE;
			break;
		case "SG":
			serv = ServerInfo.SG;
			break;
		case "TW":
			serv = ServerInfo.TW;
			break;
		case "TH":
			serv = ServerInfo.TH;
			break;
		case "PH":
			serv = ServerInfo.PH;
			break;
		case "VN":
			serv = ServerInfo.VN;
			break;
		default:
			serv = ServerInfo.NA;
		}
		LOL_SERVER = serv;
	}
}
