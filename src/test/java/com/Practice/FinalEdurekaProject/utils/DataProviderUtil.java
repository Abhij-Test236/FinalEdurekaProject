package com.Practice.FinalEdurekaProject.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataProviderUtil {
	/**
	 * DataProvider Utility
	 * @param cases: Number of Test Cases
	 * @param values: The values in each Test Case
	 * @param rowIndex: Excel sheet initial cell row index
	 * @param colIndex: Excel sheet initial cell column index
	 * @param filePath: Excel Sheet file path
	 * @param sheetName: Excel Sheet sheet name
	 * @return : Returns Test Data row wise
	 * @throws IOException
	 */

	public Object[][] Provide(int cases, int values, int rowIndex, int colIndex, String filePath, String sheetName)
			throws IOException {

		String TestData[][] = new String[cases][values];
		FileInputStream inputStream = new FileInputStream(filePath);
		XSSFWorkbook myWorkBook = new XSSFWorkbook(inputStream);
		
		DataFormatter formatter = new DataFormatter();
		XSSFSheet mySheet = myWorkBook.getSheet(sheetName);

		for (int i = rowIndex, j = 0; i < rowIndex + cases; i++, j++) {
			
			Row row = mySheet.getRow(i);
			
			for (int l = colIndex, k = 0; l < colIndex + values; l++, k++) {
				TestData[j][k] = formatter.formatCellValue(row.getCell(l));
			}

		}
		
		myWorkBook.close();
		inputStream.close();

		return TestData;
	}

}
