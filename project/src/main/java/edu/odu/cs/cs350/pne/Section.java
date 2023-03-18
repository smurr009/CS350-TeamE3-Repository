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
}
