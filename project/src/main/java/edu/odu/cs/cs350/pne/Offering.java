package edu.odu.cs.cs350.pne;

import java.util.ArrayList;
import java.util.List;

public class Offering {
    /**
     * Container of Course Sections in this Offering
     */
    private List<Section> sections = new ArrayList<>();

    /**
     * Overall Capacity for this Section
     */
    private int OverallCap;

    /**
     * Create new "blank" Offering
     */
    public Offering() {
        OverallCap = 0;
    }

    /**
     * Create new Offering
     * @param cap Overall Capacity for this offering
     */
    public Offering(int cap) {
        OverallCap = cap;
    }

    /**
     * Get Number of Sections in this Offering
     * @return Number of entries in sections container
     */
    public int getNumOfSections() { return sections.size(); }

    /**
     * Get Overall Capacity
     * @return Overall Capacity
     */
    public int getOverallCap() { return OverallCap; }

    /**
     * Get Number of Available Seats in this Offering
     * @return Difference between Capacity and Enrollment
     */
    public int getOpenSeats() { return OverallCap - getOverallEnrollment(); }

    /**
     * Get Total Students Enrolled in all Sections of this Offering
     * @return Total Students Enrolled
     */
    public int getOverallEnrollment() { 
        int TotalEnrollment = 0;
        for(Section sect: sections) 
            TotalEnrollment = TotalEnrollment + sect.getEnrolled();
        return TotalEnrollment;
    }

    /**
     * Lookup a Section by its CRN
     * @param CRN 6-digit course registration number e.g. "15641"
     * @return Section found or Null if not found
     */
    public Section getSectionByCRN(String CRN) {
        for(Section sect: sections)
            if(CRN == sect.getCRN()) return sect;
        // Return Null if No Section was found
        return null;
    }

    /**
     * Check if Section already exists in container
     * @param CRN 6-digit course registration number e.g. "15641"
     * @return True if Section Found, False if not found
     */
    public Boolean checkForSection(String CRN) {
        try {
            Section lookup = getSectionByCRN(CRN);
            if(lookup == null) return false;
            else return true;
        } catch(NullPointerException ex) { 
            return false;
        }
    }

    /**
     * Sets Overall Capacity
     * @param cap Overall Capacity for this offering
     */
    public void setOverallCap(int cap) { OverallCap = cap; }

    /**
     * Adds a Section to this Offering
     * Section is not added if another with the same CRN already exists
     * @param sect A Section to be added
     */
    public void addSection(Section sect) { 
        if(!checkForSection(sect.getCRN()))
            sections.add(sect);
    }

}
