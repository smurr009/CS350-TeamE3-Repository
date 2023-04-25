package edu.odu.cs.cs350.pne;

//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;
// import java.io.File;  // Import the File class
// import java.io.FileNotFoundException;  // Import this class to handle errors
// import java.util.Scanner; // Import the Scanner class to read text files

public class testSummary_Report {
 
    @Test
    public void testDefaultConstructor() {
        // Testing Default Constructor
        Summary_Report c = new Summary_Report();
        assertThat(c.getCourse(), is(""));
        assertThat(c.getPercentage(), is(0));
        //assertThat(c.getCourseName(), is(""));
    }

    @Test
    public void testNonDefaultConstrutor() {
        // Testing Non-default Constructor
        Summary_Report c = new Summary_Report("CS350", 15, 31, 45, 50);
        assertThat(c.getCourse(), is("CS350"));
        assertThat(c.getPercentage(), is(15));
        assertThat(c.getEnrollment(), is(31));
        assertThat(c.getProjected(), is(45));
        assertThat(c.getEnrollmentCap(), is(50));
        System.out.print(c.getPercentage());
        System.out.println("% of enrollment period has elapsed. \n");
        System.out.println("Course Enrollment Projected Cap \n");
        System.out.print(c.getCourse());
        System.out.print("     ");
        System.out.print(c.getEnrollment());
        System.out.print("       ");
        System.out.print(c.getProjected());
        System.out.print("       ");
        System.out.print(c.getEnrollmentCap());



        //assertThat(c.getCourseName(), is("CS350"));
    }

    @Test
    public void testMultiple() {
        // Testing Non-default Constructor
        Summary_Report c = new Summary_Report("CS350", 15, 31, 45, 50);
        assertThat(c.getCourse(), is("CS350"));
        assertThat(c.getPercentage(), is(15));
        assertThat(c.getEnrollment(), is(31));
        assertThat(c.getProjected(), is(45));
        assertThat(c.getEnrollmentCap(), is(50));
        System.out.print(c.getPercentage());
        System.out.println("% of enrollment period has elapsed. \n");
        System.out.println("Course Enrollment Projected Cap \n");
        System.out.print(c.getCourse());
        System.out.print("     ");
        System.out.print(c.getEnrollment());
        System.out.print("       ");
        System.out.print(c.getProjected());
        System.out.print("       ");
        System.out.print(c.getEnrollmentCap());

        System.out.print("\n");

        Summary_Report d = new Summary_Report("CS252", 35, 17, 32, 35);
        assertThat(d.getCourse(), is("CS252"));
        assertThat(d.getPercentage(), is(35));
        assertThat(d.getEnrollment(), is(17));
        assertThat(d.getProjected(), is(32));
        assertThat(d.getEnrollmentCap(), is(35));
        System.out.print(d.getCourse());
        System.out.print("     ");
        System.out.print(d.getEnrollment());
        System.out.print("       ");
        System.out.print(d.getProjected());
        System.out.print("       ");
        System.out.print(d.getEnrollmentCap());

        System.out.print("\n");


        Summary_Report e = new Summary_Report("CS390", 3, 10, 11, 20);
        assertThat(e.getCourse(), is("CS390"));
        assertThat(e.getPercentage(), is(3));
        assertThat(e.getEnrollment(), is(10));
        assertThat(e.getProjected(), is(11));
        assertThat(e.getEnrollmentCap(), is(20));
        System.out.print(e.getCourse());
        System.out.print("     ");
        System.out.print(e.getEnrollment());
        System.out.print("       ");
        System.out.print(e.getProjected());
        System.out.print("       ");
        System.out.print(e.getEnrollmentCap());

        System.out.print("\n");


        //assertThat(c.getCourseName(), is("CS350"));
    }
}
//To Do: write a test that will input schedule from a file and output
