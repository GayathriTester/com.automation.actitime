package com.demoacti.utils;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	XSSFWorkbook wb;

	public ExcelUtils(String excelpath) { // creating constructor to read the excel file
		try {
			File file = new File(excelpath);
			FileInputStream fis = new FileInputStream(file);
			// XSSFWorkbook wb = new XSSFWorkbook(fis); //XSSFWorkbook should be removed
			// after making it as the global variable., otherwise it will result in null
			// pointer exception
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println("Not able to read the value from excelworkbook,please check");
		}
	}

	public int getLastRowCount(int sheetnum) {                     // Constructor for getting the active rows and columns from the worksheet
		return wb.getSheetAt(sheetnum).getLastRowNum() + 1;
	}

	public String getCellData(int sheetnum, int row, int col) {    // To get cell data from the workbook
		return wb.getSheetAt(sheetnum).getRow(row).getCell(col).toString();
	}

}
