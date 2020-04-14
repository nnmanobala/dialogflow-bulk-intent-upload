package org.chatbot.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JsonWriter {

	private Logger logger = LogManager.getLogger(JsonWriter.class);
	String requestFilename, responseFilename;

	public void printToFile(Object object, String filename, boolean isIntent) {

		ObjectMapper Obj = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
		String jsonStr, outputFolder = ConfigManager.config.getProperty("output.folder");
		String intentFolder = outputFolder + "\\intents\\";
		try {
			File directory = new File(intentFolder);
			if (!directory.exists()) {
				if (directory.mkdir()) {
					System.out.println("Directory is created!");
				} else {
					System.out.println("Failed to create directory!");
				}
			}
			jsonStr = Obj.writeValueAsString(object);
			if (isIntent) {
				BufferedWriter writer = new BufferedWriter(new FileWriter(intentFolder + filename));
				writer.write(jsonStr);
				writer.close();
			} else {
				BufferedWriter writer = new BufferedWriter(new FileWriter(outputFolder + "\\" + filename));
				writer.write(jsonStr);
				writer.close();
			}
		} catch (JsonProcessingException e) {
			logger.error(e.getMessage());
		} catch (IOException e) {
			logger.error(e.getMessage());
		}

	}
}
