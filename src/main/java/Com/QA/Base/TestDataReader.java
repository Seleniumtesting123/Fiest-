package Com.QA.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestDataReader {

	
	static XSSFSheet ExcelWSheet;
	static XSSFWorkbook ExcelWBook;
	static XSSFCell Cell;
	static XSSFRow Row;
	
	public static String getCellData(String SheetName, int RowNum, int ColNum) throws Exception{
	
	try {
		FileInputStream ExcelFile = new FileInputStream("C:\\Users\\Lenovo\\Desktop\\eclipse-workspace\\OLB\\Test1.xlsx");
		
		ExcelWBook = new XSSFWorkbook(ExcelFile);
		
		ExcelWSheet = ExcelWBook.getSheet(SheetName);
		
		Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
		
		String CellData = Cell.getStringCellValue();
		
		return CellData;
		
		
		
	} catch (Exception e) {
		
		return "";
		
	}
		
	}
      public static void main(String[] args) throws Exception {
		
		System.out.println(TestDataReader.getCellData("Sheet1", 0 ,1));
		
	}
	   
      
	}
