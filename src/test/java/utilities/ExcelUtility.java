package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility 
{
	public FileOutputStream fo;
	public FileInputStream fi;
	public XSSFWorkbook wkbook;
	public XSSFSheet Sheet;
	public XSSFRow row;
	public XSSFCell cell;
	String path;
	
	public ExcelUtility(String path)
	{
		this.path=path;
	}
	
	
	public int getRowCount(String Sheetname) throws IOException
	{
		fi= new FileInputStream(path);
		wkbook= new XSSFWorkbook(fi);
		Sheet= wkbook.getSheet(Sheetname);
		int rowcount= Sheet.getLastRowNum();
		wkbook.close();
		fi.close();
		return rowcount;
	}
	
	public int getCellCount(String Sheetname, int rownum) throws IOException
	{
		fi= new FileInputStream(path);
		wkbook= new XSSFWorkbook(fi);
		Sheet= wkbook.getSheet(Sheetname);
		row = Sheet.getRow(rownum);
		int cellcount = row.getLastCellNum();
		wkbook.close();
		fi.close();
		return cellcount;
	}
	
	
	public String getCellData( String Sheetname, int rownum, int cellnum) throws IOException
	{
		fi= new FileInputStream(path);
		wkbook= new XSSFWorkbook(fi);
		Sheet= wkbook.getSheet(Sheetname);
		row = Sheet.getRow(rownum);
		cell=row.getCell(cellnum);
		
		String data;
		try
		{
		data=cell.toString();
		}
		catch (Exception e)
		{
			data=" ";
		}
		
		wkbook.close();
		fi.close();
		return data;
		
	}
	
	// Method to read values from cells and write values to cells. 
	public void setCelldata(String Sheetname, int rownum, int cellnum, String data) throws IOException
	{
		//Line of codes to read data from excel
		fi= new FileInputStream(path);
		wkbook= new XSSFWorkbook(fi);
		Sheet= wkbook.getSheet(Sheetname);
		row = Sheet.getRow(rownum);
		//cell=row.getCell(cellnum);
		
		//Line of code to write data to excell
		cell= row.createCell(cellnum);   // will create a new cell		
		cell.setCellValue(data);
		fo= new FileOutputStream(path);
		wkbook.write(fo);
		wkbook.close();
		fi.close();
		fo.close();
		
	}
	
	
}
