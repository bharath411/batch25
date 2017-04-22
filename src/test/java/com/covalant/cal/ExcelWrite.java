package com.covalant.cal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.testng.annotations.Test;

public class ExcelWrite {

	@Test
	public void testWrite() {

		File file = new File("D:\\bharath_new.xls");

		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Sample1");

		HSSFRow row = sheet.createRow(0);
		HSSFCell cell = row.createCell(0);

		cell.setCellType(CellType.STRING);
		cell.setCellValue("Bharath");

		try {
			workbook.write(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void modifyExcel() {
		File file = new File("D:\\bharath.xls");
		try {
			FileInputStream fis = new FileInputStream(file);

			HSSFWorkbook workbook = new HSSFWorkbook(fis);
			HSSFSheet sheet = workbook.getSheet("test");
			int maxRow = sheet.getPhysicalNumberOfRows();
			HSSFRow row = sheet.createRow(maxRow);
			HSSFCell cell = row.createCell(0);
			cell.setCellType(CellType.NUMERIC);
			cell.setCellValue((int) 7);

			cell = row.createCell(1);
			cell.setCellType(CellType.STRING);
			cell.setCellValue("Nagesh");

			cell = row.createCell(2);
			cell.setCellType(CellType.STRING);
			cell.setCellValue("batch24");

			cell = row.createCell(3);
			cell.setCellType(CellType.STRING);
			cell.setCellValue("PAID");
			
			FileOutputStream fos = new FileOutputStream(file);
			workbook.write(fos);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
