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
        Summary_Report c = new Summary_Report("CS350", 15);
        assertThat(c.getCourse(), is("CS350"));
        assertThat(c.getPercentage(), is(15));
        //assertThat(c.getCourseName(), is("CS350"));
    }
}
//To Do: write a test that will input schedule from a file and output
