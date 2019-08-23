package utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	Properties prop;
	FileInputStream fisconfig;
	
	public ConfigDataProvider(){
		File src= new File("./Config/Config.properties");
		
		try {
			fisconfig = new FileInputStream(src);
			prop = new Properties();
			prop.load(fisconfig);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Not able to load config file"+e.getMessage());
		}
	}



public String getDataFromConfig(String key){
	return prop.getProperty(key);
}

}
