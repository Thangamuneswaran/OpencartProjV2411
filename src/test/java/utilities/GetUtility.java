package utilities;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;

public class GetUtility 
{
	public static Object[] getExcelData(String filePath, String sheetname) throws IOException 
	{
		//Load Excel file
		FileInputStream file = new FileInputStream(new File(filePath));
		Workbook workbook = new XSSFWorkbook(file);
		Sheet sheet = workbook.getSheet(sheetname);
		
		//find row and col count
		int rowcount =sheet.getPhysicalNumberOfRows();
		int colcount =sheet.getRow(0).getPhysicalNumberOfCells();
		
		//create 2d array to store data
		Object[][] data = new Object[rowcount-1][colcount];
		
		//read file
		for(int i=1; i<rowcount; i++)
		{
			Row row=sheet.getRow(i);
			for (int j=1; j<colcount; j++) {
				Cell cell =row.getCell(j);
				data[i-1][j]=cell.toString();
			}
		}
		
		return data;
	}

}
