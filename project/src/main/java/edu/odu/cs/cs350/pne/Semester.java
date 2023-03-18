package edu.odu.cs.cs350.pne;

import java.time.LocalDate;

public class Semester {
    
    int semesterCode; 
    LocalDate PreRegistrationDate;
    LocalDate AddDeadlineDate;

    /* creation of each semester directory should have a defined start date, end date, and semesterCode */
    public Semester(LocalDate start, LocalDate end, int semester) {
        this.PreRegistrationDate = start;
        this.AddDeadlineDate = end;
        this.semesterCode = semester;
    }

    // creation of LocalDate variable start date
    public LocalDate getPreRegistrationDate(){
        return PreRegistrationDate;
    }

    // creation of LocalDate variable end date
    public LocalDate getAddDeadlineDate(){
        return AddDeadlineDate;
    }

    // creation of int variable semester code
    public int getSemesterCode(){
        return semesterCode;
    }

    // appending of the year and semester code to create the name string
    public String nameString(){
        String name;

        // create the integer for the year and append it to the semester Code
        int year = PreRegistrationDate.getYear();
        name = Integer.toString(year) + Integer.toString(semesterCode); 

        return name;
    }
}
