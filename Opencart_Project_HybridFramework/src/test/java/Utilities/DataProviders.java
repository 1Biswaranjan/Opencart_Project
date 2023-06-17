package Utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
	   String path = ".\\TestData\\LoginData Driven.xlsx";
	   int rownum=ExcelUtility.getRowCount(path, "sheet1");
	   int cellnum= ExcelUtility.getCellCount(path, "sheet1", 1);
		
	   String loginData[][]= new String[rownum][cellnum];
	   for(int i=1;i<=rownum;i++)
	   {
		   for(int j=0;j<cellnum;j++)
		   {
			   loginData[i-1][j]=ExcelUtility.getCellData(path, "sheet1", i, j);
		   }
	   }
	   
	       return(loginData);
	   
	}
}
