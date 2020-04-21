package org.bulk_upload.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConfigManager {

	static Logger logger = LogManager.getLogger(ConfigManager.class);
	public static Properties config = null;
	static {
		try (InputStream input = new FileInputStream(System.getProperty("user.dir") + "//config//config.properties")) {

			config = new Properties();

			// load a properties file
			config.load(input);

			// get the property value and print it out
			System.out.println(config.getProperty("excel.file.path"));
			System.out.println(config.getProperty("excel.sheet.name"));
			System.out.println(config.getProperty("output.folder"));
			System.out.println(config.getProperty("column.number.for.question"));
			System.out.println(config.getProperty("column.number.for.intent"));
			System.out.println(config.getProperty("column.number.for.response"));
			System.out.println(config.getProperty("agent.name"));

		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}

}
