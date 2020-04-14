package org.chatbot.intent;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.chatbot.util.ConfigManager;
import org.chatbot.util.ExcelParser;
import org.chatbot.util.ZipUtility;

public class Main {

	public static void main(String[] args) {

		Logger logger = LogManager.getLogger(Main.class);
		Properties testConfig = ConfigManager.config;
		ExcelParser parseExcel = new ExcelParser();
		parseExcel.readExcelFile();
		ZipUtility directoryZipper = new ZipUtility();
		File outputFolder = new File(ConfigManager.config.getProperty("output.folder") + "//intents");
		File agent = new File(ConfigManager.config.getProperty("output.folder") + "//agent.json");
		File packageFile = new File(ConfigManager.config.getProperty("output.folder") + "//package.json");
		List<File> listFiles = new ArrayList<File>();
		listFiles.add(outputFolder);
		listFiles.add(agent);
		listFiles.add(packageFile);
		directoryZipper.zip(listFiles, ConfigManager.config.getProperty("output.folder") + "//"
				+ ConfigManager.config.getProperty("output.zip.name"));
		logger.info("Application has processed all data successfully!");
	}
}
