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
        assertThat(s.getCRN(), is(""));
        assertThat(s.getEnrollmentCap(), is(0));
        assertThat(s.getEnrolled(), is(0));
        assertThat(s.getOpenSeats(), is(0));
    }

    @Test
    public void testNonDefaultConstructor() {
        // Testing Non-Default Constructor
        Section s = new Section("CS", "350", "123456");
        assertThat(s.getSubect(), is("CS"));
        assertThat(s.getCourseNumber(), is("350"));
        assertThat(s.getCourseName(), is("CS350"));
        assertThat(s.getCRN(), is("123456"));
        assertThat(s.getEnrollmentCap(), is(0));
        assertThat(s.getEnrolled(), is(0));
        assertThat(s.getOpenSeats(), is(0));
        // Testing Alt Non-Default Constructor
        Section s1 = new Section("CS", "350", "359881", 25, 13);
        assertThat(s1.getSubect(), is("CS"));
        assertThat(s1.getCourseNumber(), is("350"));
        assertThat(s1.getCourseName(), is("CS350"));
        assertThat(s1.getCRN(), is("359881"));
        assertThat(s1.getEnrollmentCap(), is(25));
        assertThat(s1.getEnrolled(), is(13));
        assertThat(s1.getOpenSeats(), is(12));
    }

    @Test
    public void testMutators() {
        // Create Empty Course
        Section s = new Section();
        assertThat(s.getSubect(), is(""));
        assertThat(s.getCourseNumber(), is(""));
        assertThat(s.getCourseName(), is(""));
        assertThat(s.getCRN(), is(""));
        assertThat(s.getEnrollmentCap(), is(0));
        assertThat(s.getEnrolled(), is(0));
        assertThat(s.getOpenSeats(), is(0));
        // Apply Mutators
        s.setSubject("CS");
        s.setCourseNumber("350");
        s.setCRN("987654");
        s.setEnrollmentCap(15);
        s.setEnrolled(10);
        assertThat(s.getSubect(), is("CS"));
        assertThat(s.getCourseNumber(), is("350"));
        assertThat(s.getCourseName(), is("CS350"));
        assertThat(s.getCRN(), is("987654"));
        assertThat(s.getEnrollmentCap(), is(15));
        assertThat(s.getEnrolled(), is(10));
        assertThat(s.getOpenSeats(), is(5));
        s.setEnrolled(16); // Try adding too many
        assertThat(s.getEnrolled(), is(10)); // Should not change
        assertThat(s.getOpenSeats(), is(5));
    }

    @Test
    public void testAddingEnrollment() {
        // Testing NonDefault Constructor
        Section s = new Section("CS", "350", "123456");
        assertThat(s.getSubect(), is("CS"));
        assertThat(s.getCourseNumber(), is("350"));
        assertThat(s.getCourseName(), is("CS350"));
        assertThat(s.getCRN(), is("123456"));
        assertThat(s.getEnrollmentCap(), is(0));
        assertThat(s.getEnrolled(), is(0));
        assertThat(s.getOpenSeats(), is(0));
        // Setup Current Enrolmlent
        s.setEnrollmentCap(25);
        s.setEnrolled(15);
        assertThat(s.getEnrollmentCap(), is(25));
        assertThat(s.getEnrolled(), is(15));
        assertThat(s.getOpenSeats(), is(10));
        // Add More Students
        s.addToEnrollment(5);
        assertThat(s.getEnrolled(), is(20));
        assertThat(s.getOpenSeats(), is(5));
        // Add Too Many Students
        s.addToEnrollment(9);
        assertThat(s.getEnrolled(), is(20)); // Did not change
        assertThat(s.getOpenSeats(), is(5));
    }

    @Test
    public void testEquality() {
        Section s1 = new Section("CS", "350", "123456");
        Section s2 = s1;
        Section s3 = new Section("CS", "350", "987651");
        assertThat(s1, equalTo(s2));
        assertThat(s1, not(equalTo(s3)));
    }
}
