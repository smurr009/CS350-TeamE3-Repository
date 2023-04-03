package edu.odu.cs.cs350.pne;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.opencsv.exceptions.CsvValidationException;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;

public class testEnrollmentSnapshot {
    LocalDate today = LocalDate.now();
    LocalDate anyDay = LocalDate.of(2023, 1, 16);

    @Test
    public void testDefaultConstructor() {
        EnrollmentSnapshot e1 = new EnrollmentSnapshot();
        assertThat(e1.getSnapshotDate(), is(today));
        assertThat(e1.getNumOfOfferings(), is(0));
    }

    @Test
    public void testNonDefaultConstructor() throws CsvValidationException, IOException {
        try {
            EnrollmentSnapshot e1 = new EnrollmentSnapshot(anyDay, "src/test/data/TestFile.csv");
            assertThat(e1.getSnapshotDate(), is(anyDay));
            assertThat(e1.getNumOfOfferings(), is(0));
        } 
        catch(FileNotFoundException ex) { fail("File Does Exist"); }
        
        
    }
}
