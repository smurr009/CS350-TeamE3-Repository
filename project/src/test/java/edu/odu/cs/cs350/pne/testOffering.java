package edu.odu.cs.cs350.pne;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;

public class testOffering {
    Section s1;
    Section s2;
    Section s3;

    @BeforeEach
    public void setup() {
        s1 = new Section("CS", "350", "12345");
        s2 = new Section("CS", "350", "13569");
        s3 = new Section("CS", "350", "14821");
        s1.setEnrollmentCap(20);
        s1.setEnrolled(15);
        s2.setEnrollmentCap(20);
        s2.setEnrolled(5);
        s3.setEnrollmentCap(20);
        s3.setEnrolled(10);
    }

    @Test
    public void testDefaultConstructor() {
        // Testing Default Constructor
        Offering o = new Offering();
        assertThat(o.getNumOfSections(), is(0));
        assertThat(o.getOverallCap(), is(0));
        assertThat(o.getOverallEnrollment(), is(0));
    }

    @Test
    public void testNonDefaultConstructor() {
        // Testing NonDefault Constructor
        Offering o = new Offering(50);
        assertThat(o.getNumOfSections(), is(0));
        assertThat(o.getOverallCap(), is(50));
        assertThat(o.getOverallEnrollment(), is(0));
    }

    @Test
    public void testAddSections() {
        Offering o = new Offering(50);
        assertThat(o.getNumOfSections(), is(0));
        assertThat(o.getOverallCap(), is(50));
        assertThat(o.getOverallEnrollment(), is(0));
        o.addSection(s1);
        assertThat(o.getNumOfSections(), is(1));
        assertThat(o.getOverallEnrollment(), is(15));
        o.addSection(s2);
        o.addSection(s3);
        assertThat(o.getNumOfSections(), is(3));
        assertThat(o.getOverallEnrollment(), is(30));
    }

    @Test
    public void testSectionLookup() {
        Offering o = new Offering(50);
        o.addSection(s1);
        o.addSection(s2);
        o.addSection(s3);
        // Test Lookup Known Section Number
        assertThat(o.getSectionByCRN("13569"), equalTo(s2));
        // Test Lookup Invaid Section Number
        try {
            Section lookup = o.getSectionByCRN("987654");
        } catch(NullPointerException ex) { }
    }

}
