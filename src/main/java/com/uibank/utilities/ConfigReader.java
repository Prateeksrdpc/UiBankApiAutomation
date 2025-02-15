package com.uibank.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	private Properties prop;
	
	// this class will read the config.properties file 
	
	
	
	public Properties init_prop() throws IOException {
		
		prop = new Properties();
		
		try {
			
			FileInputStream ip = new FileInputStream("src/test/resources/config/config.properties");
			prop.load(ip);
			
			
		}catch(FileNotFoundException e) {
			
			e.printStackTrace();
			
	
		}
		
		return prop;
		
		
		
		
		
	}
	
	

}
