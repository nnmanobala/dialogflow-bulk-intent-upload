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
			logger.info("Configuration information from config.properties:");
			logger.info(config.getProperty("excel.file.path"));
			logger.info(config.getProperty("excel.sheet.name"));
			logger.info(config.getProperty("output.folder"));
			logger.info(config.getProperty("column.number.for.question"));
			logger.info(config.getProperty("column.number.for.intent"));
			logger.info(config.getProperty("column.number.for.response"));
			logger.info(config.getProperty("agent.name"));
			logger.info(config.getProperty("language"));
			logger.info("Configuration information ends here.");

		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}

}
