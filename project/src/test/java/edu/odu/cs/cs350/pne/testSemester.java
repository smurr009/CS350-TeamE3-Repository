package edu.odu.cs.cs350.pne;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;

import java.time.LocalDate;

public class testSemester{
    String emptyPath;
    String invalidPath;
    String goodPath1;
    String goodPath2;
    String goodPath3;

    @BeforeEach
    public void setup() {
        emptyPath = "";
        invalidPath = "/Path_to_nowhere/";
        goodPath1 = "src/test/data/History/202010";
        goodPath2 = "src/test/data/History/202220/";
        goodPath3 = "src/test/data/History/202230/";
    }
  

    @Test
    public void testDefaultConstructor() {
        // Test Semester With Empty Path
        try {
            Semester failure = new Semester(emptyPath);
            fail("This path is empty and should not work");
        } catch(Exception ex) {
            assertThat(ex.getMessage(), is("Invalid Path Provided"));
        }

        // Test Semester With Bad Path
        try {
            Semester failure = new Semester(invalidPath);
            fail("This path is not real and should not work");
        } catch(Exception ex) {
            assertThat(ex.getMessage().contains("Missing dates.txt"), is(true));
        }

        // Test Semester Without "/" At End
        try {
            Semester s1 = new Semester(goodPath1);
            assertThat(s1.getSemesterCode(), is("202010"));
            assertThat(s1.getDirectory(), is(goodPath1 + "/"));
            assertThat(s1.getSemesterName(), is("Fall 2020"));
            assertThat(s1.getPreRegistration(), is(LocalDate.of(2020, 3, 30)));
            assertThat(s1.getAddDeadline(), is(LocalDate.of(2020, 8, 25)));
            assertThat(s1.getSnapshotCount(), is(112));
        } catch(Exception ex) { fail(ex.getMessage()); }

        // Test Semester With "/" At End
        try {
            Semester s2 = new Semester(goodPath2);
            assertThat(s2.getSemesterCode(), is("202220"));
            assertThat(s2.getDirectory(), is(goodPath2));
            assertThat(s2.getSemesterName(), is("Spring 2022"));
        } catch(Exception ex) { fail(ex.getMessage()); }

    }


    @Test
    public void testEquality() {
        try {
            Semester s1 = new Semester(goodPath1);
            Semester s2 = new Semester(goodPath1);
            Semester s3 = new Semester(goodPath2);
            Semester s4 = new Semester(goodPath3);
            assertThat(s1, equalTo(s2));
            assertThat(s1, not(equals(s3)));
            assertThat(s1, not(equals(s4)));
            assertThat(s3, not(equals(s4)));
        } catch(Exception ex) { fail(ex.getMessage()); }
    }


    @Test
    public void testClone() {
        try {
            Semester s1 = new Semester(goodPath1);
            Semester s2 = new Semester(goodPath1);
            assertThat(s1, equalTo(s2));
            Semester s3 = s1.clone();
            assertThat(s1, equalTo(s3));
            assertThat(s2, equalTo(s3));
        } catch(Exception ex) { fail(ex.getMessage()); }
    }

    @Test
    public void testDataExtraction() {
        try {
            // Create Test Semester to Read From
            Semester s1 = new Semester(goodPath1);
            // Get an Enrollment Snapshot by Target Date
            EnrollmentSnapshot snapshot = s1.getSnapshot(LocalDate.of(2020, 5, 6));
            // Inspect A Couple Offerings From Snapshot
            assertThat(snapshot.getDate(), is(LocalDate.of(2020, 5, 3)));
            assertThat(snapshot.getOverallCap("CS330"), is(151));
            assertThat(snapshot.getOverallEnrollment("CS330"), is(115));
            assertThat(snapshot.getOverallCap("CS121G"), is(220));
            assertThat(snapshot.getOverallEnrollment("CS121G"), is(95));
        } catch(Exception ex) { fail(ex.getMessage()); }
    }
    

}