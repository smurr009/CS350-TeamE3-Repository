package edu.odu.cs.cs350.pne;

//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;

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
        assertThat(e1.getCourses().size(), is(0));
    }

    @Test
    public void testNonDefaultConstructor() {
        // Attempt To Create Snapshot With Empty Path
        try { 
            EnrollmentSnapshot ebad1 = new EnrollmentSnapshot(anyDay, "");
        } catch(Exception ex) {  }
        // Attempt To Create Snapshot With Bad Path
        try { 
            EnrollmentSnapshot ebad2 = new EnrollmentSnapshot(anyDay, "/path_to_nowhere");
        } catch(Exception ex) {  }
        // Create Valid Snapshot
        try {
            EnrollmentSnapshot e1 = new EnrollmentSnapshot(anyDay, "src/test/data/TestFile.csv");
            assertThat(e1.getSnapshotDate(), is(anyDay));
            assertThat(e1.getNumOfOfferings(), is(4));
            assertThat(e1.getCourses().size(), is(1));
            assertThat(e1.getCourses().contains("CS250"), is(true));
            assertThat(e1.getOverallEnrollment("CS250"), is(84));
            assertThat(e1.getOverallCap("CS250"), is(200));
            EnrollmentSnapshot e2 = new EnrollmentSnapshot(anyDay, "src/test/data/BigTestFile.csv");
            assertThat(e2.getSnapshotDate(), is(anyDay));
            assertThat(e2.getNumOfOfferings(), is(258));
            assertThat(e2.getCourses().size(), is(80));
            assertThat(e2.getCourses().contains("CS250"), is(true));
            assertThat(e2.getOverallEnrollment("CS250"), is(84));
            assertThat(e2.getOverallCap("CS250"), is(200));
        } catch(Exception ex) { fail("File Does Exist"); }
    }

    @Test
    public void testDataCollection() {
        EnrollmentSnapshot e1 = new EnrollmentSnapshot();
        assertThat(e1.getSnapshotDate(), is(today));
        assertThat(e1.getNumOfOfferings(), is(0));
        assertThat(e1.getCourses().size(), is(0));
        try {
            // Call to Collect Snapshot Data
            e1.collectSnapshotData("src/test/data/TestFile.csv");
            assertThat(e1.getSnapshotDate(), is(today));
            assertThat(e1.getNumOfOfferings(), is(4));
            assertThat(e1.getCourses().size(), is(1));
            assertThat(e1.getCourses().contains("CS250"), is(true));
            assertThat(e1.getOverallEnrollment("CS250"), is(84));
            assertThat(e1.getOverallCap("CS250"), is(200));
        } catch(Exception ex) { fail("File Does Exist"); }
    }

    @Test
    public void testEquality() {
        try {
            EnrollmentSnapshot e1 = new EnrollmentSnapshot(today, "src/test/data/TestFile.csv");
            EnrollmentSnapshot e2 = new EnrollmentSnapshot(today, "src/test/data/TestFile.csv");
            EnrollmentSnapshot e3 = new EnrollmentSnapshot(today, "src/test/data/BigTestFile.csv");
            assertThat(e1, equalTo(e2));
            assertThat(e1, not(equals(e3)));
        } catch(Exception ex) { fail("File Does Exist"); }
        
    }   

    @Test
    public void testClone() {
        try {
            EnrollmentSnapshot e1 = new EnrollmentSnapshot(today, "src/test/data/TestFile.csv");
            EnrollmentSnapshot e2 = new EnrollmentSnapshot(e1);
            assertThat(e1, equalTo(e2));
            EnrollmentSnapshot e3 = e1.clone();
            assertThat(e1, equalTo(e3));
            assertThat(e2, equalTo(e3));
        } catch(Exception ex) { fail("File Does Exist"); }
    }

}
