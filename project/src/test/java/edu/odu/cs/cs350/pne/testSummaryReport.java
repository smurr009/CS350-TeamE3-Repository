package edu.odu.cs.cs350.pne;

import java.io.File;
import java.io.FileOutputStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;

import edu.odu.cs.cs350.pne.Summary_Report;

public class testSummaryReport {
    @Test
    public void testSummaryReportBasic()
    {
        assertThat("", is(""));
    }
}
