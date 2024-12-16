package com.bhoomi.sprig.HibernateExcelGenerator;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelGenerator {
	
	public void generateExcelDataFile(List<Student> list, String excelFilePath) throws IOException
	{
		FileOutputStream fos=null;
		DataOutputStream dos=null;
		
		XSSFWorkbook workbook=null;
		
		try
		{
			File filePath=new File(excelFilePath);
			
			fos=new FileOutputStream(filePath);
			
			dos=new DataOutputStream(fos);
			
			workbook=new XSSFWorkbook();
			
			XSSFSheet sheet=workbook.createSheet("student");
			
			Iterator<Student> iterator=list.iterator();
			
			int index=0;
			
			while(iterator.hasNext())
			{
				Student student=iterator.next();
				
				XSSFRow row=sheet.createRow(index++);
				
				XSSFCell cell = row.createCell(0);
				
				cell.setCellType(CellType.NUMERIC );
				
				cell.setCellValue(student.getId());
				
				
				cell = row.createCell(1);
				
				cell.setCellType(CellType.STRING );
				
				cell.setCellValue(student.getName());
				

				cell = row.createCell(3);
				
				cell.setCellType(CellType.NUMERIC );
				
				cell.setCellValue(student.getAge());
				
				cell = row.createCell(2);
				
				cell.setCellType(CellType.STRING );
				
				cell.setCellValue(student.getGender());
			}
			
			workbook.write(dos);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if( workbook !=null)
			{
				workbook.close();
			}
			
			if( dos!=null)
			{
				dos.close();
			}
			
			if( fos!=null)
			{
				fos.close();
			}
		}
		
	}


}
