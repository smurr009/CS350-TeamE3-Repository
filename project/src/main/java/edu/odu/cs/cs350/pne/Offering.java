package edu.odu.cs.cs350.pne;

import java.lang.String;
import java.util.ArrayList;
import java.util.List;

public class Offering {
    private List<Section> Sections = new ArrayList<>();
    private String CourseName;
    private String Instructor;
    private String XlstGroup;
    private int OverallCap;

    /**
     * Create new "blank" Offering
     */
    public Offering() {
        CourseName = "";
        Instructor = "";
        XlstGroup = "";
        OverallCap = 0;
    }

    /**
     * Create new Offering
     * @param cName course name e.g. "CS350"
     * @param instr instructor assigned to this offering
     * @param cap overall capacity for this offering
     */
    public Offering(String cName, String instr, int cap) {
        CourseName = cName;
        Instructor = instr;
        OverallCap = cap;
        XlstGroup = "";
    }

    /**
     * Create new Offering with Cross-List Group
     * @param cName course name e.g. "CS350"
     * @param instr instructor assigned to this offering
     * @param cap overall capacity for this offering 
     * @param group cross-list group to identify related sections
     */
    public Offering(String cName, String instr, int cap, String group) {
        CourseName = cName;
        Instructor = instr;
        OverallCap = cap;
        XlstGroup = group;
    }

    /**
     * Offering Copy Constructor
     * @param src source Offering obeject to copy
     */
    public Offering(Offering src) {
        CourseName = src.CourseName;
        Instructor = src.Instructor;
        OverallCap = src.OverallCap;
        XlstGroup = src.XlstGroup;
        Sections = src.Sections;
    }
    
    /**
     * Get Course Name of this Offering
     * @return Course Name
     */
    public String getCourseName() { return CourseName; }

    /**
     * Get Instructor for this Offering
     * @return Instructor's Name
     */
    public String getInstructor() { return Instructor; }

    /**
     * Get Overall Capacity of this Offering
     * @return Overall Capacity
     */
    public int getOverallCap() { return OverallCap; }

    /**
     * Get Cross-List Group for this Offering
     * @return Cross-List Group or Empty String
     */
    public String getXlstGroup() { return XlstGroup; }

    /**
     * Get Number of Sections in this Offering
     * @return Number of entries in sections container
     */
    public int getNumOfSections() { return Sections.size(); }

    /**
     * Get Total Students Enrolled in all Sections of this Offering
     * @return Total Students Enrolled
     */
    public int getOverallEnrollment() {
        int TotalEnrollment = 0;
        for(Section sect: Sections) 
            TotalEnrollment = TotalEnrollment + sect.getEnrolled();
        return TotalEnrollment;
    }

    /**
     * Get Number of Available Seats in this Offering
     * @return Difference between Capacity and Enrollment
     */
    public int getOpenSeats() { return OverallCap - getOverallEnrollment(); }
    
    /**
     * Set Course Name
     * @param cName course name e.g. "CS350"
     */
    public void setCourseName(String cName) { CourseName = cName; }

    /**
     * Set Instructor Name
     * @param instr instructor assigned to this offering
     */
    public void setInstructor(String instr) { Instructor = instr; }

    /**
     * Sets Overall Capacity
     * @param cap Overall Capacity for this offering
     */
    public void setOverallCap(int cap) { OverallCap = cap; }

    /**
     * Set Cross-List Group Name
     * @param group cross-list group to identify related sections
     */
    public void setXlstGroup(String group) { XlstGroup = group; }
    
    /**
     * Adds a Section to this Offering
     * Section is not added if another with the same CRN already exists
     * @param sect A Section to be added
     */
    public void addSection(Section sect) {
        if(!Sections.contains(sect))
            Sections.add(sect);
    }

    /**
     * Generate clone of this object with deep copy
     * @return clone of this Offering
     */
    public Offering clone() {
        Offering copy = new Offering(this);
        return copy;
    }

    /**
     * Check for equality between two Offerings
     * @return Ture if Equal, False if Not Equal
     */
    public boolean equals(Object rhs) {
        // Check if same object type
        if(!(rhs instanceof Offering)) return false;
        // Convert object type to Offering
        Offering rhsOffering = (Offering)rhs;
        // Validate Offering Data Members
        if(CourseName != rhsOffering.CourseName) return false;
        if(Instructor != rhsOffering.Instructor) return false;
        if(OverallCap != rhsOffering.OverallCap) return false;
        if(XlstGroup != rhsOffering.XlstGroup) return false;
        // Validate List of Sections as Final Step
        return this.Sections.equals(rhsOffering.Sections);
    }

}