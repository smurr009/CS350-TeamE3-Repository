package edu.odu.cs.cs350.pne;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

// changed to use the HSSFWorkbook class instead - The XSSF libraries are not working for some reason
// detailed instructions provided here - https://poi.apache.org/components/spreadsheet/quick-guide.html#NewWorkbook

public class Detailed_Report
{
    public void WriteToExcel() throws Exception
    {
        System.out.println("Starting detailed summary report...");
        HSSFWorkbook workbook = new HSSFWorkbook();
        Sheet sheet1 = workbook.createSheet("Sample sheet");
        
        // Create a new row and add some cells
        Row row = sheet1.createRow(0);
        Cell cell1 = row.createCell(0);
        cell1.setCellValue("Hello");
        Cell cell2 = row.createCell(1);
        cell2.setCellValue("World!");

        try (FileOutputStream outputStream = new FileOutputStream("detailed_report.xls")) {
            workbook.write(outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("writeExcelinJava.xlsx written successfully on disk.");
    }
    
    //This takes a CSV file?
    public void WriteMultipleToExcel()
    {
     
    }
}