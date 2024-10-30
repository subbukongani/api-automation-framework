package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigMapping {

	/**
	 * Path to Configuration File
	 */
	private static final String CONFIG_FILE = "src/main/resources/configuration/config_prod.properties";
	private static Properties properties;

	/**
	 * ConfigMapping is responsible for loading properties from the
	 * environment-specific file.
	 */
	static {
		properties = new Properties();
		try (FileInputStream fis = new FileInputStream(CONFIG_FILE)) {
			properties.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Retrieve a property value by its key
	 * 
	 * @param key - property key
	 * @return String - property value
	 */
	public static String getConfigProperty(String key) {
		return properties.getProperty(key);
	}
}
