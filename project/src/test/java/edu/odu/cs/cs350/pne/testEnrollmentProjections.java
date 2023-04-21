package edu.odu.cs.cs350.pne;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;
import edu.odu.cs.cs350.pne.Enrollment_Projections;

//These are very generic tests but I needed to see if it was possible to work somehting out here.
public class testEnrollmentProjections
{
    String S1;
    String S2;
    String S3;
    String S4;
    
    @BeforeEach
    public void setUp()
    {
        S1 = "src/test/data/History/202010";
        S2 = "src/test/data/History/202110/";
        S3 = "src/test/data/History/202210/";
        S4 = "src/test/data/History/202230/";

    }
    @Test
    public void TwoSemesterEnrollmentProjections()
    {
        try {
            Semester Semester1 = new Semester(S1);
            Semester Semester2 = new Semester(S2);
        } catch (IOException e) {System.out.print("Failure to create Semester");}
    }

    @Test
    public void ThreeSemesterEnrollmentProjections()
    {
        try {
            Semester Semester1 = new Semester(S1);
            Semester Semester2 = new Semester(S2);
            Semester Semester3 = new Semester(S3);
        } catch (IOException e) {System.out.print("Failure to create Semester");}
    }

    @Test
    public void FourSemesterEnrollmentProjections()
    {
        try {
            Semester Semester1 = new Semester(S1);
            Semester Semester2 = new Semester(S2);
            Semester Semester3 = new Semester(S3);
            Semester Semester4 = new Semester(S4);
        } catch (IOException e) {System.out.print("Failure to create Semester");}
    }
}
