/**
* @Title: PoiAdvanceDemo.java
* @Package com.osxm.je.chp5.poi
* @Description: TODO
* @author XM
* @date 2023年12月5日 下午9:39:17
* @Copyright: 2023
* @version V1.0  
*/
package com.osxm.je.chp5.poi;

import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;

public class PoiAdvanceDemo {

	@Test
	public void headStyle() throws Exception {
		try (XSSFWorkbook excelWorkbook = new XSSFWorkbook()) {
			XSSFSheet sheet = excelWorkbook.createSheet("My Sheet");
			XSSFRow row = sheet.createRow(0);
			XSSFCell cell = row.createCell(0);
			cell.setCellValue("Hello");

			byte[] rgb = new byte[]{(byte)68, (byte)144, (byte)196};
			XSSFColor color = new XSSFColor(rgb, null);
			
			XSSFCellStyle headStyle = excelWorkbook.createCellStyle();
			headStyle.setFillForegroundColor(color);
			headStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

			Font font = excelWorkbook.createFont();
			font.setColor(IndexedColors.WHITE.getIndex());
			font.setBold(true);
			headStyle.setFont(font);
			cell.setCellStyle(headStyle);

			String fullfileName = "D:\\temp\\poiExcel.xlsx";
			FileOutputStream fdout = new FileOutputStream(fullfileName);
			excelWorkbook.write(fdout);
			fdout.flush();
			fdout.close();
		}

	}
}
