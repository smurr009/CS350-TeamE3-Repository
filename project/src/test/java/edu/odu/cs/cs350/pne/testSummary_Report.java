package edu.odu.cs.cs350.pne;

//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;

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