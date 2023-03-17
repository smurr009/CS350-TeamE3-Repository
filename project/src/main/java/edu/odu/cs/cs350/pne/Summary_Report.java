package edu.odu.cs.cs350.pne;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;

// org.apache.poi was added to the gradle depenancies list to resovle the first one
// check the remaining "xssf" imports, these dont seem to exist
// may be this example is a better option:  https://poi.apache.org/components/spreadsheet/how-to.html#sxssf

//This prints an excel worksheet
public class Summary_Report
{
    public static void WriteToExcel(String[] args) throws Exception
    {
        /*XSSFWorkbook test = new XSSFWorkbook();
        XSSFSheet spreadsheet = workbook.createSheet("Detailed Summary Report");

        XSSF row;

        test.put("1", new Object[]{"Historical", "Current", "Projected"});
        FileOutputStream out = new FileOutputStream(new File("C:/savedexcel/GFGsheet.xlsx"));
        workbook.write(out);
        out.close();
        */
    }
}