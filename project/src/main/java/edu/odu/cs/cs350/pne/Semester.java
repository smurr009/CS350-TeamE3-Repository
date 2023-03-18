package edu.odu.cs.cs350.pne;

import java.time.LocalDate;

public class Semester {
    
    int semesterCode; 
    LocalDate startDate;
    LocalDate endDate;

    /* creation of each semester directory should have a defined start date, end date, and semesterCode */
    public Semester(LocalDate start, LocalDate end, int semester) {
        this.startDate = start;
        this.endDate = end;
        this.semesterCode = semester;
    }

    // creation of LocalDate variable start date
    public LocalDate getStartDate(){
        return startDate;
    }

    // creation of LocalDate variable end date
    public LocalDate getEndDate(){
        return endDate;
    }

    // creation of int variable semester code
    public int getSemesterCode(){
        return semesterCode;
    }
}
