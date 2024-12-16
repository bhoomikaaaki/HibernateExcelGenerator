package com.bhoomi.sprig.HibernateExcelGenerator;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	System.out.println("table");
    	try
    	{
    	String excelFilePath = "D:\\Bhoomi\\file1.XLSX";
		
		
		Database database = new Database();
		
		List<Student> list = database.importData();			
		
		
		ExcelGenerator generator = new ExcelGenerator();
		
		generator.generateExcelDataFile(list, excelFilePath);
		
		System.out.println("Successfully Generated ");
    	}
	catch(Exception e)
	{
		e.printStackTrace();
	}

    }
}
