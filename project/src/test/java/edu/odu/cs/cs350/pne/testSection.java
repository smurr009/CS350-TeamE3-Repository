package edu.odu.cs.cs350.pne;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;

public class testSection {
    @Test
    public void testDefaultConstructor() {
        // Testing Default Constructor
        Section s = new Section();
        assertThat(s.getSubect(), is(""));
        assertThat(s.getCourseNumber(), is(""));
        assertThat(s.getCourseName(), is(""));
    }

    @Test
    public void testMutators() {
        // Create Empty Course
        Section s = new Section();
        assertThat(s.getSubect(), is(""));
        assertThat(s.getCourseNumber(), is(""));
        assertThat(s.getCourseName(), is(""));
        // Apply Mutators
        s.setSubject("CS");
        s.setCourseNumber("350");
        assertThat(s.getSubect(), is("CS"));
        assertThat(s.getCourseNumber(), is("350"));
        assertThat(s.getCourseName(), is("CS350"));
    }
}
