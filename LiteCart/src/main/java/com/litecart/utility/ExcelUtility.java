package com.litecart.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;





public class ExcelUtility {
	
		WebDriver driver;
		public static Logger log = Logger.getLogger(ExcelUtility.class);
		static FileInputStream fis;
		static Workbook wb;
		public static ArrayList<String> getExcelTableData(String fileName,String sheetName){
			ArrayList<String> expData=new ArrayList<String>();
			
			String path=System.getProperty("user.dir")+"/src/test/resources/"+fileName;
			String value=null;
		
			FileInputStream fis;
			try {
				fis = new FileInputStream(path);
				try {
					Workbook wb=WorkbookFactory.create(fis);
					log.info("Workbook  is retrived" +wb);
				} catch (EncryptedDocumentException e) {
					
					e.printStackTrace();
				} catch (InvalidFormatException e) {
					log.error("InvalidFormatException is occured");
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				log.error("FileNotFoundException is occured");
				e.printStackTrace();
			}
			
			Sheet sh=wb.getSheet(sheetName);
			log.info("retrive the sheet");
			int row=sh.getPhysicalNumberOfRows();
			for (int i = 0; i < row; i++) 
			{
				int col=sh.getRow(i).getLastCellNum();
				for (int j = 0; j <col; j++) 
				{
					Cell cell=sh.getRow(i).getCell(j);
					DataFormatter df=new DataFormatter();
					value=df.formatCellValue(cell);
					expData.add(value);
					log.info("    "+value);
				}
				System.out.println();
			}
			return expData;
		}
		
		
		public static ArrayList<String> getColumnData(String fileName,String sheetName,int colNo){
			ArrayList<String> expData=new ArrayList<String>();
			String value=null;
			String path=System.getProperty("user.dir")+"/src/test/resources/" + fileName;
			//System.out.println("path"+path);
			FileInputStream fis;
			try {
				fis = new FileInputStream(path);
				try {
					Workbook wb=WorkbookFactory.create(fis);
					Sheet sh=wb.getSheet(sheetName);
					int row=sh.getPhysicalNumberOfRows();
					
					for (int i =0; i <row; i++) 
					{
						Cell cell=sh.getRow(i).getCell(colNo);
							DataFormatter df=new DataFormatter();
							value=df.formatCellValue(cell);
							expData.add(value);
							//System.out.println(value);
					}
					
				} catch (EncryptedDocumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvalidFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return expData;
			
		
		}

	public static ArrayList<String> getDataOfAnyColumn(String fileName,String sheetName,int colNo)throws Exception{
		ArrayList<String> expData=new ArrayList<String>();
		String path=System.getProperty("user.dir")+"/src/test/resources/"+ fileName;
		String value=null;
		FileInputStream fis = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int row=sh.getPhysicalNumberOfRows();
		
		for (int i = 0; i < row; i++) 
		{
			int col=sh.getRow(i).getLastCellNum();
			for (int j = 0; j <col; j++) 
			{
				Cell cell=sh.getRow(i).getCell(colNo);
				DataFormatter df=new DataFormatter();
				value=df.formatCellValue(cell);
				expData.add(value);
			}
		}
		return expData;
	}
	public static List<String> getRowData(String fileName, String sheetName, int rowIndex) throws Exception {
		String path=System.getProperty("user.dir")+"/src/test/resources/"+ fileName;
		List<String> rows = new ArrayList<String>();
		FileInputStream fis = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowIndex);
		int col=sh.getRow(rowIndex).getLastCellNum();
		for (int j = 0; j <col; j++) 
		{
			rows.add(String.valueOf(row.getCell(j)));
			
		}
		return rows;
	}
}
