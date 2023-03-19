package edu.odu.cs.cs350.pne;

import java.io.File;
import java.io.FileOutputStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;

import edu.odu.cs.cs350.pne.Detailed_Report;

public class testDetailedReport {
    @Test
    public void testSummaryReportBasic()
    {
        Detailed_Report test = new Detailed_Report();
        try {
            test.WriteToExcel();
        } catch(Exception ex) { fail("failed to create excel"); }
    }
}
