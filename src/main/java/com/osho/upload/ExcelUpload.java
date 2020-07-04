package com.osho.upload;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.osho.model.Shop;

import ch.qos.logback.classic.net.SyslogAppender;

public class ExcelUpload 
{
	
	public static void main(String[] args) 
	{
		try {
			FileInputStream file = new FileInputStream(new File("C:/upload/xls/sample.xlsx"));

			// Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);

			ArrayList<Shop> shopList = new ArrayList<>();
			// I've Header and I'm ignoring header for that I've +1 in loop
			for (int i = sheet.getFirstRowNum() + 1; i <= sheet.getLastRowNum(); i++) {
				Shop shop = new Shop();
				Row row = sheet.getRow(i);
				for (int j = row.getFirstCellNum(); j <= row.getLastCellNum(); j++) {
					Cell cell = row.getCell(j);
					 
					switch(j){
						case 0:
					}
					
					if (j == 0) {
						// If you have Header in text It'll throw exception because it won't get
						// NumericValue
						shop.setAuthor(cell.getStringCellValue());
					}
					if (j == 1) {
						shop.setItem_name(cell.getStringCellValue());
					}
					if (j == 2) {
						shop.setItem_category(cell.getStringCellValue());
					}
				}
				shopList.add(shop);
			}
			
			shopList.forEach(shop -> shopShow(shop));

			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void shopShow(Shop shop) {
		 System.out.println(shop.toString());
	}
 

}
