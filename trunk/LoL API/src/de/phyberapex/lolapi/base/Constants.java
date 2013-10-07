package de.phyberapex.lolapi.base;

import java.io.IOException;
import java.util.Properties;

import com.gvaneyck.rtmp.ServerInfo;

import de.phyberapex.base.FileHelper;
import de.phyberapex.base.MainConstants;

public class Constants extends MainConstants {

	/* ==== Basic stuff ==== */
	public static final String APP_NAME = "LoL-API";
	public static final String APP_VERSION = "0.01";
	public static final String APP_AUTOR = "Phyber.Apex";
	public static final boolean DEV_VERSION = true;

	/* ==== LoL login stuff ==== */
	public static Properties LOL_LOGIN_INFO;

	public static ServerInfo parseServer(String property) {
		ServerInfo serv = null;
		switch (property) {
		case "NA":
		case "North America":
			serv = ServerInfo.NA;
			break;
		case "EUW":
		case "Europe West":
			serv = ServerInfo.EUW;
			break;
		case "EUNE":
		case "Europe Nordic & East":
			serv = ServerInfo.EUNE;
			break;
		case "KR":
		case "Korea":
			serv = ServerInfo.KR;
			break;
		case "BR":
		case "Brazil":
			serv = ServerInfo.BR;
			break;
		case "TR":
		case "Turkey":
			serv = ServerInfo.TR;
			break;
		case "RU":
		case "Russia":
			serv = ServerInfo.RU;
			break;
		case "LAN":
		case "Latin America North":
			serv = ServerInfo.LAN;
			break;
		case "LAS":
		case "Latin America South":
			serv = ServerInfo.LAS;
			break;
		case "OCE":
		case "Oceania":
			serv = ServerInfo.OCE;
			break;
		case "PBE":
		case "Public Beta Environment":
			serv = ServerInfo.PBE;
			break;
		case "SG":
		case "Singapore/Malaysia":
			serv = ServerInfo.SG;
			break;
		case "TW":
		case "Taiwan":
			serv = ServerInfo.TW;
			break;
		case "TH":
		case "Thailand":
			serv = ServerInfo.TH;
			break;
		case "PH":
		case "Phillipines":
			serv = ServerInfo.PH;
			break;
		case "VN":
		case "Vietnam":
			serv = ServerInfo.VN;
			break;
		default:
			serv = ServerInfo.NA;
		}
		return serv;
	}

	public static void saveLoginInfo() {
		try {
			FileHelper.writeXMLPropertiesFile("lol_login.xml", LOL_LOGIN_INFO);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static {
		try {
			LOL_LOGIN_INFO = FileHelper.readXMLPropertiesFile("lol_login.xml");

		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
}
