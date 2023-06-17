package utilities;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataReader 
{

	public static List<HashMap<String,String>> data (String path , String sheetName)
	{
		
		List<HashMap<String, String>> mydata = new ArrayList<>();
		try {
			
			FileInputStream fi = new FileInputStream(path);
			XSSFWorkbook wb = new XSSFWorkbook(fi);
			XSSFSheet sheet = wb.getSheet(sheetName);
			Row headrow = sheet.getRow(0);
			for(int i=1;i<=sheet.getPhysicalNumberOfRows();i++)
			{
				Row row=sheet.getRow(i);
				HashMap<String, String> currentHash = new HashMap<String, String>();
				for(int j=0;j<row.getPhysicalNumberOfCells();j++)
				{
					Cell cell=row.getCell(j);
					switch(cell.getCellType())
					{
					case STRING :
						currentHash.put(headrow.getCell(j).getStringCellValue(), cell.getStringCellValue());
						break;
					}
				}
				mydata.add(currentHash);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return(mydata);
	}
}
