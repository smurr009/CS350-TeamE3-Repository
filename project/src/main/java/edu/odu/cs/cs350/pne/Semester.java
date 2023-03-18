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
}
