package edu.odu.cs.cs350.pne;

import java.lang.String;
import java.time.LocalDate;

public class Course {
    private String CourseName;
    private LocalDate RegistrationDate;

    public Course() {
        CourseName = "";
        RegistrationDate = LocalDate.now();
    }

    public Course(String CName, LocalDate RegDate) {
        CourseName = CName;
        RegistrationDate = RegDate;
    }

    public String getCourseName() { return CourseName; }
    public LocalDate getRegistrationDate() { return RegistrationDate; }

    public void setCourseName(String CName) { CourseName = CName; }
    public void setRegistrationDate(LocalDate RegDate) { RegistrationDate = RegDate; }
    

}
