package edu.odu.cs.cs350.pne;

//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;

public class testSection {
    @Test
    public void testDefaultConstructor() {
        // Testing Default Constructor
        Section s = new Section();
        assertThat(s.getSubject(), is(""));
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
        assertThat(s.getSubject(), is("CS"));
        assertThat(s.getCourseNumber(), is("350"));
        assertThat(s.getCourseName(), is("CS350"));
        assertThat(s.getCRN(), is("123456"));
        assertThat(s.getEnrollmentCap(), is(0));
        assertThat(s.getEnrolled(), is(0));
        assertThat(s.getOpenSeats(), is(0));
        // Testing Alt Non-Default Constructor
        Section s1 = new Section("CS", "350", "359881", 25, 13);
        assertThat(s1.getSubject(), is("CS"));
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
        assertThat(s.getSubject(), is(""));
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
        assertThat(s.getSubject(), is("CS"));
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
    public void testEquality() {
        // Set One Object Equal To Another
        Section s1 = new Section("CS", "350", "123456");
        Section s2 = s1;
        assertThat(s2.getSubject(), is("CS"));
        assertThat(s2.getCourseNumber(), is("350"));
        assertThat(s2.getCourseName(), is("CS350"));
        assertThat(s2.getCRN(), is("123456"));
        assertThat(s2.getEnrollmentCap(), is(0));
        assertThat(s2.getEnrolled(), is(0));
        assertThat(s2.getOpenSeats(), is(0));
        assertThat(s1, equalTo(s2));
        // Create An Object with a Different Value
        Section s3 = new Section("CS", "350", "987651");
        assertThat(s1, not(equalTo(s3)));
        // Make a new one with the same values
        Section s4 = new Section("CS", "350", "123456");
        assertThat(s1, equalTo(s4));
    }
}
