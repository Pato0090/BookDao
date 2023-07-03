package it.betacom.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {
	
	Properties properties;
	FileInputStream inputStream;
	
	public static ConfigLoader instance;
	
	public static ConfigLoader getInstance() {
		if (instance == null) {
			instance = new ConfigLoader();
		}
		return instance;
	}
	

	private ConfigLoader() {

		properties = new Properties();
        
		try {
			inputStream = new FileInputStream("resources/configIO.properties");
			properties.load(inputStream);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Errore nel caricamento del file di properties IO. Uscita in corso...");
			e.printStackTrace();
		}
        
	}
	
	public String getTargetPath() {
		return properties.getProperty("path");
	}

}
