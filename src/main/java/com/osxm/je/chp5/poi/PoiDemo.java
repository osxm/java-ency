/**
* @Title: PoiDemo.java
* @Package com.osxm.je.chp5.poi
* @Description: TODO
* @author XM
* @date 2023年12月5日 下午10:10:16
* @Copyright: 2023
* @version V1.0  
*/
package com.osxm.je.chp5.poi;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PoiDemo {

	public static void main(String[] args) throws IOException {
		// 创建一个新的工作簿

		try (XSSFWorkbook workbook = new XSSFWorkbook()) {
			// 创建一个新的工作表
			Sheet sheet = workbook.createSheet("Sheet1");

			// 创建一行并在其中添加单元格
			Row row = sheet.createRow(0);
			Cell cell = row.createCell(0);
			cell.setCellValue("Hello, World!");

			// 将工作表写入文件
			String filename = "D:\\temp\\example.xlsx";
			FileOutputStream outputStream = new FileOutputStream(filename);
			workbook.write(outputStream);
			outputStream.close();

			System.out.println("Excel文件已创建并保存到 " + filename);
		}
	}
}
