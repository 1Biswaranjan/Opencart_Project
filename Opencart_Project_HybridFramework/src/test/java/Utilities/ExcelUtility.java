package Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style;
	
	public static int getRowCount(String path,String sheetname) throws IOException
	{
		fi=new FileInputStream(path);
		wb= new XSSFWorkbook(fi);
	    sheet=wb.getSheet(sheetname);
		int rownum=sheet.getLastRowNum();
		wb.close();
		fi.close();
		return(rownum);
	}
	
	public static int getCellCount(String path,String sheetname,int rownum) throws IOException
	{
		fi=new FileInputStream(path);
		wb= new XSSFWorkbook(fi);
	    sheet=wb.getSheet(sheetname);
	    int cellnum=sheet.getRow(rownum).getLastCellNum();
	    wb.close();
	    fi.close();
	    return(cellnum);  
	}
	
	public static String getCellData(String path,String sheetname,int rownum,int cellnum) throws IOException 
	{
		fi=new FileInputStream(path);
		wb= new XSSFWorkbook(fi);
	    sheet=wb.getSheet(sheetname);
	    row=sheet.getRow(rownum);
	    cell=row.getCell(cellnum);
	    
	    String data;
	    DataFormatter formatter = new DataFormatter();
	   try {
	    data=formatter.formatCellValue(cell);
	   }
	   catch(Exception e)
	   {
		   data="";
	   }
	   wb.close();
	   fi.close();
	   return(data);
	}
	
	public static void setCellValue(String path,String sheetname,int rownum,int cellnum,String data) throws IOException
	{
		fi=new FileInputStream(path);
		wb= new XSSFWorkbook(fi);
	    sheet=wb.getSheet(sheetname);
	    row=sheet.getRow(rownum);
	    cell=row.getCell(cellnum);
	    cell.setCellValue(data);
	    
	    fo=new FileOutputStream(path);
	    wb.write(fo);
	    fi.close();
	    wb.close();
	    fo.close();
	}
	
	public static void setGreenColor(String path,String sheetname,int rownum,int cellnum) throws IOException
	{
		fi=new FileInputStream(path);
		wb= new XSSFWorkbook(fi);
	    sheet=wb.getSheet(sheetname);
	    row=sheet.getRow(rownum);
	    cell=row.getCell(cellnum);
	   
	    style = wb.createCellStyle();
	    
	    style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
	    style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	    
	    cell.setCellStyle(style);
	    fo=new FileOutputStream(path);
	    wb.write(fo);
	    fi.close();
	    wb.close();
	    fo.close();
	}
	
	public static void setRedColor(String path,String sheetname,int rownum,int cellnum) throws IOException
	{
		fi=new FileInputStream(path);
		wb= new XSSFWorkbook(fi);
	    sheet=wb.getSheet(sheetname);
	    row=sheet.getRow(rownum);
	    cell=row.getCell(cellnum);
	   
	    style = wb.createCellStyle();
	    
	    style.setFillForegroundColor(IndexedColors.RED.getIndex());
	    style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	    
	    cell.setCellStyle(style);
	    fo=new FileOutputStream(path);
	    wb.write(fo);
	    fi.close();
	    wb.close();
	    fo.close();
	}
	
	
	
	
}
