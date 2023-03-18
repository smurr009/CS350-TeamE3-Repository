package edu.odu.cs.cs350.pne;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;

//import java.lang.String;

import edu.odu.cs.cs350.pne.Course;

public class testCourse {
 
    @Test
    public void testDefaultConstructor() {
        // Testing Default Constructor
        Course c = new Course();
        assertThat(c.getSubect(), is(""));
        assertThat(c.getCourseNumber(), is(""));
        assertThat(c.getCourseName(), is(""));
    }

    @Test
    public void testNonDefaultConstrutor() {
        // Testing Non-default Constructor
        Course c = new Course("CS", "350");
        assertThat(c.getSubect(), is("CS"));
        assertThat(c.getCourseNumber(), is("350"));
        assertThat(c.getCourseName(), is("CS350"));
    }

    @Test
    public void testMutators() {
        // Create Empty Course
        Course c = new Course();
        assertThat(c.getSubect(), is(""));
        assertThat(c.getCourseNumber(), is(""));
        assertThat(c.getCourseName(), is(""));
        // Apply Mutators
        c.setSubject("CS");
        c.setCourseNumber("350");
        assertThat(c.getSubect(), is("CS"));
        assertThat(c.getCourseNumber(), is("350"));
        assertThat(c.getCourseName(), is("CS350"));
    }

    @Test
    public void testEquality() {
        Course c1 = new Course("CS", "350");
        Course c2 = c1;
        Course c3 = new Course("CS", "150");
        assertThat(c1, equalTo(c2));
        assertThat(c1, not(equalTo(c3)));
    }

}