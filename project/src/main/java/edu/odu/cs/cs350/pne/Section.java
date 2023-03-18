package edu.odu.cs.cs350.pne;

import java.lang.String;
import edu.odu.cs.cs350.pne.Course;

public class Section extends Course {
    private String CRN;
    private int EnrollmentCap;
    private int Enrolled;

    public Section() {
        super("", "");
        CRN = "";
        EnrollmentCap = 0;
        Enrolled = 0;
    }

    public Section(String _Subject, String _CourseNumber, String _CRN) {
        super(_Subject, _CourseNumber);
        CRN = _CRN;
    }

    public String getCRN() { return CRN; }
    public int getEnrollmentCap() { return EnrollmentCap; }
    public int getEnrolled() { return Enrolled; }

    public void setCRN(String _CRN) { CRN = _CRN; }
    public void setEnrollmentCap(int _EnrollmentCap) { EnrollmentCap = _EnrollmentCap; }
    public void setEnrolled(int _Enrolled) {
        if(_Enrolled <= EnrollmentCap) Enrolled = _Enrolled;
    }

    public void addToEnrollment(int numStudents) {
        int openSeats = EnrollmentCap - Enrolled;
        if(numStudents <= openSeats) Enrolled = Enrolled + numStudents;
    }
}
