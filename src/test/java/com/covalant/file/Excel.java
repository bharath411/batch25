package com.covalant.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Excel {

	@Test
	public void test1() {

		File file = new File("D:\\bharath.xls");
		try {
			FileInputStream fis = new FileInputStream(file);

			HSSFWorkbook workbook = new HSSFWorkbook(fis);
			HSSFSheet sheet = workbook.getSheet("test");

			int totalrows = sheet.getPhysicalNumberOfRows();
			for (int j = 1; j < totalrows; j++) {
				HSSFRow row = sheet.getRow(j);
				row.getPhysicalNumberOfCells();
				for (int i = 0; i < 4; i++) {
					String value = "";
					HSSFCell cell = row.getCell(i);
					switch (cell.getCellTypeEnum()) {
					case STRING:
						value = cell.getStringCellValue();
						break;

					case NUMERIC:
						int val = (int) cell.getNumericCellValue();
						value = String.valueOf(val);
						break;

					case BLANK:
						value = "";
						break;

					default:
						value = "";
						break;
					}
					System.out.print(value + "  ");

				}
				System.out.println();
			}
			workbook.close();
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void test4() {
		
		File file = new File("D:\\opencart_register.xlsx");
		try {
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook book = new XSSFWorkbook(fis);
			XSSFSheet sheet = book.getSheet("Sheet1");
			
			XSSFRow row = sheet.getRow(0);
			System.out.println(sheet.getSheetName());
		}catch (Exception e) {
			
		}
		
	}
}

/*
 * if(cell.getCellType()==Cell.CELL_TYPE_STRING){ value =
 * cell.getStringCellValue(); }else
 * if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC){ int val =
 * (int)cell.getNumericCellValue(); value = String.valueOf(val); }
 */

/*
 * if(cell.getCellTypeEnum()==CellType.STRING){ value =
 * cell.getStringCellValue(); }else
 * if(cell.getCellTypeEnum()==CellType.NUMERIC){ int val =
 * (int)cell.getNumericCellValue(); value = String.valueOf(val); }
 */
