package de.phyberapex.lolapi.base;

import java.io.IOException;
import java.util.Properties;

import com.gvaneyck.rtmp.ServerInfo;

import de.phyberapex.base.FileHelper;
import de.phyberapex.base.MainConstants;

public class Constants extends MainConstants {

	/* ==== Basic stuff ==== */
	public static Properties BASIC_INFO;

	/* ==== LoL login stuff ==== */
	public static Properties LOL_LOGIN_INFO;

	public static ServerInfo parseServer(String property) {
		ServerInfo serv = null;
		switch (property) {
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
		return serv;
	}

	static {
		try {
			BASIC_INFO = FileHelper.readXMLPropertiesFile("lol_login.xml");

		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
}
