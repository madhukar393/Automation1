package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import groovyjarjarantlr4.v4.parse.ANTLRParser.exceptionGroup_return;

public class Excel_methods {
	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static int getRoeCount(String xlfile,String xlsheet) throws Exception
	{
		fis= new FileInputStream(xlfile);
		wb= new XSSFWorkbook(fis);
		ws= wb.getSheet(xlsheet);
		int rowcount=ws.getLastRowNum();
		wb.close();
		fis.close();
		return rowcount;
	}
	public static int getcellcount(String xlfile,String xlsheet,int rownum) throws IOException
	{
		fis= new FileInputStream(xlfile);
		wb= new XSSFWorkbook(fis);
		ws= wb.getSheet(xlsheet);
	row=ws.getRow(rownum);
	int cellcount=row.getLastCellNum();
	wb.close();
	fis.close();
	return cellcount;
	
		
	}
	public static String getcelldata(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
	{
		fis= new FileInputStream(xlfile);
		wb= new XSSFWorkbook(fis);
		ws= wb.getSheet(xlsheet);
	row=ws.getRow(rownum);
	cell=row.getCell(colnum);
	String data;
	try {
		DataFormatter formater= new DataFormatter();
		String celldata=formater.formatCellValue(cell);
		return celldata;
	}
	catch(Exception e) {
		data="";
	}
	return data;
	
	}
	public static void setcelldata(String xlfile,String xlSheet,int rownum,int colnum,String data) throws Exception
	{
		fis= new FileInputStream(xlfile);
		wb= new XSSFWorkbook(fis);
		ws= wb.getSheet(xlSheet);
	row=ws.getRow(rownum);
	cell=row.getCell(colnum);
	cell.setCellValue(data);
	fos= new FileOutputStream(xlfile);
	wb.write(fos);
	wb.close();
	fis.close();
	fos.close();
		
	}

}
