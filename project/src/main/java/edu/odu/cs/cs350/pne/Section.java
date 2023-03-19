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
        super("", "");
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
        super(subj, cnum);
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
        super(subj, cnum);
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
     * Adds provided number of students to Enrolled
     * Enrolled is not changed if the added students exceeds Enrollment Cap
     * @param numStudents number of additional students enrolled
     */
    public void addToEnrollment(int numStudents) {
        if(numStudents <= getOpenSeats()) Enrolled = Enrolled + numStudents;
    }
}
