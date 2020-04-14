package org.chatbot.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.chatbot.model.Intent;

public class ExcelParser {

	private String file = ConfigManager.config.getProperty("excel.file.path");
	private StringBuilder stats = new StringBuilder();
	private Logger logger = LogManager.getLogger(ExcelParser.class);

	public void readExcelFile() {

		Map<Integer, Intent> intentMap = new LinkedHashMap<Integer, Intent>();
		int questionColNumber = Integer.parseInt(ConfigManager.config.getProperty("column.number.for.question")) - 1;
		int intentColNumber = Integer.parseInt(ConfigManager.config.getProperty("column.number.for.intent")) - 1;
		int responseColNumber = Integer.parseInt(ConfigManager.config.getProperty("column.number.for.response")) - 1;
		String excelSheetName = ConfigManager.config.getProperty("excel.sheet.name");
		XSSFWorkbook myExcelBook;
		int intent = 0, counter = 0;
		long rowNumber = 1;
		try {
			Intent newIntent = new Intent();
			myExcelBook = new XSSFWorkbook(new FileInputStream(file));
			XSSFSheet myExcelSheet = myExcelBook.getSheet(excelSheetName);
			String question = "", response = "";

			for (Row row : myExcelSheet) {

				if (counter > 0) {
					intent = (int) row.getCell(intentColNumber).getNumericCellValue();
					if (row.getCell(questionColNumber).getCellType().equals(CellType.STRING))
						question = row.getCell(questionColNumber).getStringCellValue();
					else if (row.getCell(questionColNumber).getCellType().equals(CellType.NUMERIC))
						question = String.valueOf(row.getCell(questionColNumber).getNumericCellValue());
					if (row.getCell(responseColNumber).getCellType().equals(CellType.STRING))
						response = row.getCell(responseColNumber).getStringCellValue();
					else if (row.getCell(responseColNumber).getCellType().equals(CellType.NUMERIC))
						response = String.valueOf(row.getCell(responseColNumber).getNumericCellValue());

					if (intentMap.containsKey(intent)) {
						intentMap.get(intent).addQuestion(question);
					} else {
						newIntent = new Intent();
						newIntent.addQuestion(question);
						newIntent.setResponse(response);
						newIntent.setIntent(intent);
						intentMap.put(intent, newIntent);
					}
					rowNumber++;
				}
				counter++;
			}

			for (Map.Entry<Integer, Intent> entry : intentMap.entrySet())
				stats.append(
						"Intent " + entry.getKey() + " has " + entry.getValue().numberOfQuestions() + " questions.\n");

			myExcelBook.close();
			JsonBuilder jsonBuilder = new JsonBuilder();
			jsonBuilder.buildJson(intentMap);
			logger.info(stats.toString());
		} catch (FileNotFoundException e) {
			logger.info("Error encountered after processing row number: "+ rowNumber + " and intent: " + intent);
			logger.error(e.getMessage());
		} catch (IOException e) {
			logger.info("Error encountered after processing row number: "+ rowNumber + " and intent: " + intent);
			logger.error(e.getMessage());

		}
	}

}
