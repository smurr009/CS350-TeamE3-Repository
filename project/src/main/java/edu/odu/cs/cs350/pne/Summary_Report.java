package edu.odu.cs.cs350.pne;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

// org.apache.poi was added to the gradle depenancies list to resovle the first one
// check the remaining "xssf" imports, these dont seem to exist
// may be this example is a better option:  https://poi.apache.org/components/spreadsheet/how-to.html#sxssf

//This prints an excel worksheet
public class Summary_Report
{
    public static void WriteToExcel() throws Exception
    {
        System.out.println("Starting detailed summary report...");
        SXSSFWorkbook wb = new SXSSFWorkbook();
        Sheet sh = wb.createSheet();
        System.out.println("writeExcelinJava.xlsx written successfully on disk.");

    }
}