package ExcelData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.SheetUtil;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class ReadExcel {

public static String onp;
public static String dsp;
public static String mobilenumber;
	
public void excelfile() throws IOException  {
	
	File src=new File("C:\\Users\\EMP1\\eclipse-workspace\\in\\src\\main\\java\\ExcelData\\RedBus_Data.xlsx");

	FileInputStream fis=new FileInputStream(src);

	XSSFWorkbook wb=new XSSFWorkbook(fis);

	XSSFSheet sh1=wb.getSheetAt(0);
	
	onp=sh1.getRow(1).getCell(0).getStringCellValue();
	dsp=sh1.getRow(1).getCell(1).getStringCellValue();
	mobilenumber=sh1.getRow(1).getCell(2).getStringCellValue();

	System.out.println("THE Onward_Place IS : "+onp);
	System.out.println("THE Dest_palce  IS : "+dsp);
	System.out.println("THE Mobile_Number IS : "+mobilenumber);
	
	//printing the values in loop
	for(int i=1;i<=sh1.getLastRowNum();i++) {
		Row row = sh1.getRow(i);
		if (row != null) {
		    for (int j = 0; j < row.getLastCellNum(); j++) {
		        if (row.getCell(j) != null) {
		                String value=row.getCell(j).getStringCellValue(); 
		                if(value != null) { 
		                    System.out.println("The cell values are:"+value);
		                }
		        }   
		    }
		}

	}	
	
	wb.close();
}	
}
