package utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.io.InputStream;

/**
 * Common Functions to use for API automation.
 */
public class CommonFunctions {


	static String configFileName = "Configuation.properties";
	
    public static String getFilePath(String fileName) {
 
    	ClassLoader classLoader;
		classLoader = CommonFunctions.class.getClassLoader();
		//classLoader = getClass().getClassLoader();
		File file = null ;
    	file  = new File(classLoader.getResource(fileName).getFile());
		//file = new File(CommonFunctions.class.getClassLoader().getResource("apiURLs.properties").getFile());
		return file.getAbsolutePath();
    }
    
    public static Properties PropertyFileReader(String configFileName){

    	BufferedReader reader;
    	
    	String configFilePath;
		configFilePath = getFilePath(configFileName);
		Properties prop;
		prop = new Properties();
		try {
			reader = new BufferedReader(new FileReader(configFilePath));
			try {
				prop.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + configFilePath);
		}

		return prop;
	}

	public static String getFilePathToSaveStatic() {

		Properties prop = new Properties();

		String result = "";

		try (InputStream inputStream = CommonFunctions.class
				.getClassLoader().getResourceAsStream("apiURLs.properties")) {

			prop.load(inputStream);
			result = prop.getProperty("getRecorderVersion");

		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;

	}

	public static void main(String[] args) {

    	String file = getFilePath("Configuration.properties");
		System.out.println(file);
		//System.out.println(getFilePathToSaveStatic());
	}

}
