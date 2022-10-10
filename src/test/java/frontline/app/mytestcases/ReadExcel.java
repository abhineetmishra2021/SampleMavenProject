package frontline.app.mytestcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcel {
	@Test
	public void readExcel(){
		String TESTDATA_SHEET_PATH = "C:\\Users\\Abhineet Mishra\\Desktop\\create_user_testdata.xlsx";
		
		 XSSFWorkbook workbook = null;
		 XSSFSheet sheet;
		 DataFormatter formatter = new DataFormatter();
			FileInputStream fis = null;
			try {
				fis = new FileInputStream(TESTDATA_SHEET_PATH);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			try {
				workbook = new XSSFWorkbook(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //get my workbook 
			 sheet=workbook.getSheet("users");// get my sheet from workbook
			       XSSFRow Row = sheet.getRow(0);   //get my Row which start from 0   
			   
			    	int RowNum = sheet.getPhysicalNumberOfRows();// count my number of Rows
			    	System.out.println("RowNum="+RowNum);
			    	int ColNum= Row.getLastCellNum(); // get last ColNum 
			    	System.out.println("ColNum="+ColNum);
			    	
			    	Object Data[][]= new Object[RowNum-1][ColNum]; // pass my  count data in array
			    	
			     for(int i=0; i<RowNum-1; i++) //Loop work for Rows
			     {  
			     XSSFRow row= sheet.getRow(i+1);
			     
			     for (int j=0; j<ColNum; j++) //Loop work for colNum
			     {
			     if(row==null)
			     Data[i][j]= "";
			     else 
			     {
			     XSSFCell cell= row.getCell(j);
			     if(cell==null)
			     Data[i][j]= ""; //if it get Null value it pass no data 
			     else
			     {
			     String value=formatter.formatCellValue(cell);
			     System.out.print(value+" ");
			     Data[i][j]=value; //This formatter get my all values as string i.e integer, float all type data value
			     }
			     }
			     }
			     System.out.println();
			     }
			 
			    	
	}

		
	}


