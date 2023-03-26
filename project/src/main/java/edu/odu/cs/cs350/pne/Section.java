package edu.odu.cs.cs350.pne;

import java.lang.String;

public class Section extends Course {
    private String CRN;
    private int EnrollmentCap;
    private int Enrolled;
    
    /**
     * Create an "blank" Section
     */
    public Section() {
        Subject = "";
        CourseNumber = "";
        CRN = "";
        EnrollmentCap = 0;
        Enrolled = 0;
    }

    /**
     * Create a new Section
     * @param subj course subject e.g. "CS"
     * @param cnum numeric course identifier e.g. "350"
     * @param crn 6-digit course registration number e.g. "15641"
     */
    public Section(String subj, String cnum, String crn) {
        Subject = subj;
        CourseNumber = cnum;
        CRN = crn;
    }

    /**
     * Create a new Section
     * @param subj course subject e.g. "CS"
     * @param cnum numeric course identifier e.g. "350"
     * @param crn 6-digit course registration number e.g. "15641"
     * @param cap enrollment cap for this section
     * @param numStudents number of students enrolled
     */
    public Section(String subj, String cnum, String crn, int cap, int numStudents)
    {
        Subject = subj;
        CourseNumber = cnum;
        CRN = crn;
        EnrollmentCap = cap;
        Enrolled = numStudents;
    }

    /**
     * Get the CRN for this Section
     * @return CRN as string
     */
    public String getCRN() { return CRN; }

    /**
     * Get Enrollment Cap for this Section
     * @return Enrollment Cap
     */
    public int getEnrollmentCap() { return EnrollmentCap; }

    /**
     * Get Enrolled Students
     * @return Number of Enrolled students
     */
    public int getEnrolled() { return Enrolled; }

    /**
     * Get Number of Open Seats
     * @return differnece between Enrollment Cap and Current Enrollment
     */
    public int getOpenSeats() { return EnrollmentCap - Enrolled; }

    /**
     * Set the CRN for this Section
     * @param crn 6-digit course registration number e.g. "15641" 
     */
    public void setCRN(String crn) { CRN = crn; }

    /**
     * Set the Enrollment Cap for this Section
     * @param cap enrollment cap for this section
     */
    public void setEnrollmentCap(int cap) { EnrollmentCap = cap; }

    /**
     * Set Number of Enrolled Students
     * Enrolled is not changed if the value exceeds Enrollment Cap
     * @param numStudents number of students enrolled
     */
    public void setEnrolled(int numStudents) {
        if(numStudents <= EnrollmentCap) Enrolled = numStudents;
    }

    /**
     * Check for equality between two Offerings
     * @return Ture if Equal, False if Not Equal
     */
    public boolean equals(Object rhs) {
        // Check if same object type
        if(!(rhs instanceof Section)) return false;
        // Convert object type to Section
        Section rhsSection = (Section)rhs;
        
        if(Subject != rhsSection.Subject) return false;
        if(CourseNumber != rhsSection.CourseNumber) return false;
        if(CRN != rhsSection.CRN) return false;
        if(EnrollmentCap != rhsSection.EnrollmentCap) return false;
        if(Enrolled != rhsSection.Enrolled) return false;
        
        // Must be the same, so return True
        return true;
    }
}
