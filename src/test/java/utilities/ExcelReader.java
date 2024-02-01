package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelReader 
{
	static FileInputStream fis;	
	static XSSFWorkbook workbook;
	static Sheet sheet;
	static Row row;
	
	@DataProvider(name = "loginDetails")
	public String[][] readExcelData() throws IOException 	
	
	{
		fis = new FileInputStream("C:\\Users\\jayud\\OneDrive\\Desktop\\Framework\\opencart.org\\src\\test\\resources\\LoginDetails1.xlsx");
		workbook = new XSSFWorkbook(fis);			
		sheet = workbook.getSheet("sheet1");	
		
		row = sheet.getRow(0);
		
		
		String[][] data = new String[sheet.getLastRowNum()][row.getLastCellNum()];
		
		System.out.println("getLastRowNum" + (sheet.getLastRowNum()));
		System.out.println("getLastCellNum" + (row.getLastCellNum()));


		for(int i=1; i<=sheet.getLastRowNum(); i++)
		{
	        row = sheet.getRow(i);
	        int k= i -1;
	        System.out.println("Values of k: "+k);
	        System.out.println(row.getLastCellNum());
			for(int j=0; j<row.getLastCellNum() ; j++)
			{
				//System.out.println(sheet.getRow(i).getCell(j));
				data[k][j] = sheet.getRow(i).getCell(j).getStringCellValue();
				System.out.println("Values at arr["+k+"]["+j+"]" +sheet.getRow(i).getCell(j).getStringCellValue());
			}
			k=+1;
		}	
		
		for(int i=0; i<data.length; i++) {
	        for(int j=0; j<data[i].length; j++) {
	            System.out.println("Values at arr["+i+"]["+j+"] is "+data[i][j]);
	        }
	    }
		
		return(data);
		
	}

}
