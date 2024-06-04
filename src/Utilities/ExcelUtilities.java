package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {
	static public String readExcel(int r,int c) 
	{
		 File f = new File("testcases_data.xlsx");
	        FileInputStream fis = null;
	        XSSFWorkbook wb = null ;
	        
		        try 
		        {
					fis = new FileInputStream(f);
				} 
		        catch (FileNotFoundException e) 
		        {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        
				try 
				{
					wb = new XSSFWorkbook(fis);
				} 
				catch (IOException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				XSSFSheet sh = wb.getSheetAt(1);
				XSSFRow row = sh.getRow(r);
				XSSFCell cell = row.getCell(c);
				
				String str = cell.getStringCellValue();
				return str;
				
	}
	static public int readExcelInt(int r,int c) 
	{
		 File f = new File("testcases_data.xlsx");
	        FileInputStream fis = null;
	        XSSFWorkbook wb = null ;
	        
		        try 
		        {
					fis = new FileInputStream(f);
				} 
		        catch (FileNotFoundException e) 
		        {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        
				try 
				{
					wb = new XSSFWorkbook(fis);
				} 
				catch (IOException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				XSSFSheet sh = wb.getSheetAt(1);
				XSSFRow row = sh.getRow(r);
				XSSFCell cell = row.getCell(c);
				
				int str = (int) cell.getNumericCellValue();
				return str;
				
	}

}
