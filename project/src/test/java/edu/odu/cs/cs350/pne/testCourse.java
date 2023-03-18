package edu.odu.cs.cs350.pne;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;

import java.lang.String;
import java.time.LocalDate;

import edu.odu.cs.cs350.pne.Course;

public class testCourse {
 
    @Test
    public void testDefaultConstructor() {
        // Testing Default Constructor
        Course c = new Course();
        assertThat(c.getCourseName(), is(""));
        assertThat(c.getRegistrationDate(), is(LocalDate.now()));
    }

    @Test
    public void testNonDefaultConstrutor() {
        // Testing Non-default Constructor
        LocalDate regDate = LocalDate.of(2023, 1, 2);
        Course c1 = new Course("CS350", regDate);
        assertThat(c1.getCourseName(), is("CS350"));
        assertThat(c1.getRegistrationDate(), is(regDate));
    }

    @Test
    public void testMutators() {
        // Testing Default Constructor
        Course c = new Course();
        LocalDate regDate = LocalDate.of(2023, 1, 2);
        assertThat(c.getCourseName(), is(""));
        assertThat(c.getRegistrationDate(), is(LocalDate.now()));
        // Apply Mutators
        c.setCourseName("CS350");
        c.setRegistrationDate(regDate);
        assertThat(c1.getCourseName(), is("CS350"));
        assertThat(c1.getRegistrationDate(), is(regDate));
    }




}