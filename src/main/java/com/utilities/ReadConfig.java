package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


public class ReadConfig {

	Properties prop;

	public ReadConfig() {

		File src = new File(System.getProperty("user.dir")+"/src/main/resources/config.properties");

		try {

			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception is"+e.getMessage());
		}
	}
	public String getApplication() {
		String url = prop.getProperty("baseURL");
		return url;
	}

	public String getUserName() {
		String uname = prop.getProperty("username");
		return uname;
	}

	public String getPassword() {
		String pwd = prop.getProperty("password");
		return pwd;
	}

	public String getChromePath() {
		String chropath = prop.getProperty("chromepath");
		return chropath;
	}	

	public String getEdgePath() {
		String chropath = prop.getProperty("edgepath");
		return chropath;
	}

	public String getFirePath() {
		String firepath = prop.getProperty("firefoxpath");
		return firepath;
	}
}
