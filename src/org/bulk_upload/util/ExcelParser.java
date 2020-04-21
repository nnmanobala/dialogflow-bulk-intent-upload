package org.bulk_upload.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bulk_upload.model.Intent;

public class ExcelParser {

	private String file = ConfigManager.config.getProperty("excel.file.path");
	private Logger logger = LogManager.getLogger(ExcelParser.class);

	public void readExcelFile() {

		Map<Integer, Intent> intentMap = new LinkedHashMap<Integer, Intent>();
		int questionColNumber = Integer.parseInt(ConfigManager.config.getProperty("column.number.for.question")) - 1;
		int intentColNumber = Integer.parseInt(ConfigManager.config.getProperty("column.number.for.intent")) - 1;
		int responseColNumber = Integer.parseInt(ConfigManager.config.getProperty("column.number.for.response")) - 1;
		String excelSheetName = ConfigManager.config.getProperty("excel.sheet.name");
		XSSFWorkbook myExcelBook;
		int intentNumber = 0;
		boolean isDataColumn = false;
		long rowNumber = 1;
		try {
			Intent newIntent = new Intent();
			Intent tempIntent = new Intent();
			myExcelBook = new XSSFWorkbook(new FileInputStream(file));
			XSSFSheet myExcelSheet = myExcelBook.getSheet(excelSheetName);
			String question = "", response = "";

			for (Row row : myExcelSheet) {

				if (isDataColumn) {
					intentNumber = (int) row.getCell(intentColNumber).getNumericCellValue();
					if (row.getCell(questionColNumber).getCellType().equals(CellType.STRING))
						question = row.getCell(questionColNumber).getStringCellValue();
					else if (row.getCell(questionColNumber).getCellType().equals(CellType.NUMERIC))
						question = String.valueOf(row.getCell(questionColNumber).getNumericCellValue());
					if (row.getCell(responseColNumber).getCellType().equals(CellType.STRING))
						response = row.getCell(responseColNumber).getStringCellValue();
					else if (row.getCell(responseColNumber).getCellType().equals(CellType.NUMERIC))
						response = String.valueOf(row.getCell(responseColNumber).getNumericCellValue());

					// If intent is already available add question to intent
					if (intentMap.containsKey(intentNumber)) {
						intentMap.get(intentNumber).addQuestion(question);
					} else {

						/*
						 * Due to memory constraints, an intent is written to file as soon as all its
						 * related questions are loaded. If all questions for an intent are loaded, then
						 * the map will create its next intent, so it will not be empty.
						 */
						if (!intentMap.keySet().isEmpty()) {

							Optional<Integer> optIntentNumber = intentMap.keySet().stream().findAny();

							if (optIntentNumber.isPresent()) {
								// Optional.get() returns the actual element
								tempIntent = intentMap.get(optIntentNumber.get());
								new JsonBuilder().buildAndWriteIntentJson(tempIntent);
								intentMap.remove(tempIntent.getIntent());
							}

						}
						newIntent = new Intent();
						newIntent.addQuestion(question);
						newIntent.setResponse(response);
						newIntent.setIntent(intentNumber);
						intentMap.put(intentNumber, newIntent);
					}
					rowNumber++;
				}
				isDataColumn = true;
			}
			myExcelBook.close();
			new JsonBuilder().buildAndWriteAgentAndInfo();

		} catch (FileNotFoundException e) {
			logger.info("Error encountered after processing row number: " + rowNumber + " and intent: " + intentNumber);
			logger.error(e.getMessage());
		} catch (IOException e) {
			logger.info("Error encountered after processing row number: " + rowNumber + " and intent: " + intentNumber);
			logger.error(e.getMessage());

		}
	}

}
