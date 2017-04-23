package com.covalant.ng2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelReaderDp {

	public Object[][] getData_old() {

		Object[][] obj = new Object[4][2];

		obj[0][0] = "a";
		obj[0][1] = "a1";

		obj[1][0] = "b";
		obj[1][1] = "b1";

		obj[2][0] = "c";
		obj[2][1] = "c1";

		obj[3][0] = "d";
		obj[3][1] = "d1";

		return obj;
	}

	public String readCell(int row, int column) {

		HSSFRow rowData = sheet.getRow(row);
		HSSFCell cellData = rowData.getCell(column);
		String data = getCellData(cellData);
		return data;
	}

	private String getCellData(HSSFCell cell) {
		String value = "";
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

		return value;
	}

	public Object[][] getData() {
		int rows = getRowCount();
		Object[][] obj = new Object[rows-1][2];

		for (int i = 0; i < obj.length; i++) {
			obj[i][0] = readCell(i + 1, 1);
			obj[i][1] = readCell(i + 1, 2);
		}

		return obj;
	}

	public int getRowCount() {
		return sheet.getPhysicalNumberOfRows();
	}

	public void readData() {

	}

	public ExcelReaderDp() {
		init();
	}

	HSSFSheet sheet = null;

	private void init() {
		File file = new File("D:\\newExcel.xls");
		try {
			FileInputStream fis = new FileInputStream(file);

			HSSFWorkbook workbook = new HSSFWorkbook(fis);
			sheet = workbook.getSheet("Bharath");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
