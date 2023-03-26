package edu.odu.cs.cs350.pne;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;

public class testOffering {
    Section s1;
    Section s2;
    Section s3;

    @BeforeEach
    public void setup() {
        s1 = new Section("CS", "350", "12345", 20, 15);
        s2 = new Section("CS", "350", "13569", 20, 5);
        s3 = new Section("CS", "350", "14821", 20, 10);
    }

    @Test
    public void testDefaultConstructor() {
        // Testing Default Constructor
        Offering o = new Offering();
        assertThat(o.getCourseName(), is(""));
        assertThat(o.getInstructor(), is(""));
        assertThat(o.getOverallCap(), is(0));
        assertThat(o.getXlstGroup(), is(""));
        assertThat(o.getNumOfSections(), is(0));
        assertThat(o.getOverallEnrollment(), is(0));
        assertThat(o.getOpenSeats(), is(0));
    }

    @Test
    public void testNonDefaultConstructors() {
        // Testing NonDefault Constructor
        Offering o = new Offering("CS350", "POLAWAR,NISHA", 50);
        assertThat(o.getCourseName(), is("CS350"));
        assertThat(o.getInstructor(), is("POLAWAR,NISHA"));
        assertThat(o.getOverallCap(), is(50));
        assertThat(o.getXlstGroup(), is(""));
        assertThat(o.getNumOfSections(), is(0));
        assertThat(o.getOverallEnrollment(), is(0));
        assertThat(o.getOpenSeats(), is(50));
        // Testing Alternate NonDefault Constructor
        Offering o1 = new Offering("CS350", "POLAWAR,NISHA", 50, "SC051");
        assertThat(o1.getCourseName(), is("CS350"));
        assertThat(o1.getInstructor(), is("POLAWAR,NISHA"));
        assertThat(o1.getOverallCap(), is(50));
        assertThat(o1.getXlstGroup(), is("SC051"));
        assertThat(o1.getNumOfSections(), is(0));
        assertThat(o1.getOverallEnrollment(), is(0));
        assertThat(o1.getOpenSeats(), is(50));
    }

    @Test
    public void testChangeCapacity() {
        Offering o = new Offering();
        assertThat(o.getCourseName(), is(""));
        assertThat(o.getInstructor(), is(""));
        assertThat(o.getOverallCap(), is(0));
        assertThat(o.getXlstGroup(), is(""));
        assertThat(o.getNumOfSections(), is(0));
        assertThat(o.getOverallEnrollment(), is(0));
        assertThat(o.getOpenSeats(), is(0));
        // Apply Mutators
        o.setCourseName("CS350");
        o.setInstructor("POLAWAR,NISHA");
        o.setOverallCap(20);
        o.setXlstGroup("SC051");
        assertThat(o.getCourseName(), is("CS350"));
        assertThat(o.getInstructor(), is("POLAWAR,NISHA"));
        assertThat(o.getOverallCap(), is(20));
        assertThat(o.getXlstGroup(), is("SC051"));
        assertThat(o.getOverallEnrollment(), is(0));
        assertThat(o.getOpenSeats(), is(20));
    }

    @Test
    public void testAddSections() {
        Offering o = new Offering("CS350", "POLAWAR,NISHA", 50);
        assertThat(o.getCourseName(), is("CS350"));
        assertThat(o.getInstructor(), is("POLAWAR,NISHA"));
        assertThat(o.getOverallCap(), is(50));
        assertThat(o.getXlstGroup(), is(""));
        assertThat(o.getNumOfSections(), is(0));
        assertThat(o.getOverallEnrollment(), is(0));
        assertThat(o.getOpenSeats(), is(50));
        o.addSection(s1);
        assertThat(o.getNumOfSections(), is(1));
        assertThat(o.getOverallEnrollment(), is(15));
        assertThat(o.getOpenSeats(), is(35));
        o.addSection(s2);
        o.addSection(s3);
        assertThat(o.getNumOfSections(), is(3));
        assertThat(o.getOverallEnrollment(), is(30));
        assertThat(o.getOpenSeats(), is(20));
        o.addSection(s2); // Add duplicate Section
        assertThat(o.getNumOfSections(), is(3));
        assertThat(o.getOverallEnrollment(), is(30));
        assertThat(o.getOpenSeats(), is(20));
    }

    @Test
    public void testEquality() {
        // Create two Offerings to play with
        Offering o1 = new Offering();
        Offering o2 = new Offering();
        
        // Compare to a different object types
        assertThat(o1, not(equalTo(s1)));

        // Compare two empty Offerings
        assertThat(o1, equalTo(o2));
        
        // Apply Mutators then Compare
        o2.setCourseName("CS350");
        assertThat(o1, not(equalTo(o2))); // Different
        o1.setCourseName("CS350");
        assertThat(o1, equalTo(o2)); // Now the same

        o2.setInstructor("POLAWAR,NISHA");
        assertThat(o1, not(equalTo(o2))); // Different
        o1.setInstructor("POLAWAR,NISHA");
        assertThat(o1, equalTo(o2)); // Now the same
        
        o2.setOverallCap(50);
        assertThat(o1, not(equalTo(o2))); // Different
        o1.setOverallCap(50);
        assertThat(o1, equalTo(o2)); // Now the same

        o2.setXlstGroup("SC051");
        assertThat(o1, not(equalTo(o2))); // Different
        o1.setXlstGroup("SC051");
        assertThat(o1, equalTo(o2)); // Now the same

        // Check Adding A Single Section
        o2.addSection(s1);
        assertThat(o1, not(equalTo(o2))); // Different
        o1.addSection(s1);
        assertThat(o1, equalTo(o1)); // Now the same

        // Check Adding A Multiple Sections
        o2.addSection(s2);
        o2.addSection(s3);
        assertThat(o1, not(equalTo(o2))); // Different
        o1.addSection(s2);
        o1.addSection(s3);
        assertThat(o1, equalTo(o1)); // Now the same
    }

    @Test
    public void testClone() {
        // Create two Offerings to play with
        Offering o1 = new Offering();
        o1.addSection(s1);
        o1.addSection(s2);
        o1.addSection(s3);
        // Generate Offering with Copy Constructor
        Offering o2 = o1;
        assertThat(o1, equalTo(o2));
        // Generate Clone of Offering
        Offering o3 = o1.clone();
        assertThat(o1, equalTo(o3));
    }

}
