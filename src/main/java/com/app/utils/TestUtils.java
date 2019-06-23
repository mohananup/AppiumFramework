package com.app.utils;

import java.io.FileInputStream;

import java.io.FileNotFoundException;

import java.io.FileOutputStream;

import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFCell;

import org.apache.poi.xssf.usermodel.XSSFRow;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.app.base.TestBase;

public class TestUtils extends TestBase{


	private static XSSFSheet ExcelWSheet;

	private static XSSFWorkbook ExcelWBook;

	private static XSSFCell Cell;

	private static XSSFRow Row;
	
	
	
	
	//function to retrieve data from java properties
    public String getproperties(String propertieskey) {
    	String propertiesdata = prop.getProperty("propertieskey");
    	return propertiesdata;
    }
    
    

	public static Object[][] getTableArray(String SheetName) throws Exception {   
        String FilePath = prop.getProperty("datafilepath");
		String[][] tabArray = null;

		try {

			FileInputStream ExcelFile = new FileInputStream(FilePath);

			// Access the required test data sheet

			ExcelWBook = new XSSFWorkbook(ExcelFile);

			ExcelWSheet = ExcelWBook.getSheet(SheetName);

			int startRow = 3;

			int startCol = 1;

			int ci,cj;

			int totalRows = ExcelWSheet.getLastRowNum();
			//int totalRows = ExcelWSheet.getPhysicalNumberOfRows();
			XSSFRow rows=ExcelWSheet.getRow(startRow);
			int lastColumns = rows.getLastCellNum();

			// you can write a function as well to get Column count

			int totalCols = lastColumns-1;
			//int totalCols = 4;
			
			System.out.println("total rows = " + totalRows);
			
			System.out.println("total columns = " + totalCols);

			tabArray=new String[totalRows][totalCols];

			ci=0;

			for (int i=startRow;i<=totalRows;i++, ci++) {           	   

				cj=0;

				for (int j=startCol;j<=totalCols;j++, cj++){

					tabArray[ci][cj]=getCellData(i,j);

					System.out.println(tabArray[ci][cj]);  

				}

			}

		}

		catch (FileNotFoundException e){

			System.out.println("Could not read the Excel sheet");

			e.printStackTrace();

		}

		catch (IOException e){

			System.out.println("Could not read the Excel sheet");

			e.printStackTrace();

		}

		return(tabArray);

	}

	public static String getCellData(int RowNum, int ColNum) throws Exception {

		try{

			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

			int dataType = Cell.getCellType();

			if  (dataType == 3) {

				return "";

			}else{

				String CellData = Cell.getStringCellValue();

				return CellData;

			}}catch (Exception e){

				System.out.println(e.getMessage());

				throw (e);

			}

		}
	
	public void hideAndroidKeyboard() {
		
	}
	
	
	//scroll and search functions

	}
	


