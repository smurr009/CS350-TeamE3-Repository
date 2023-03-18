package edu.odu.cs.cs350.pne;

import java.time.LocalDate;

public class Semester {
    
    int semesterCode; 
    LocalDate addDate;
    LocalDate dropDate;

    /* creation of each semester directory should have a defined start date, end date, and semesterCode */
    public Semester(LocalDate start, LocalDate end, int semester) {
        this.addDate = start;
        this.dropDate = end;
        this.semesterCode = semester;
    }

    // creation of LocalDate variable start date
    public LocalDate getAddDate(){
        return addDate;
    }

    // creation of LocalDate variable end date
    public LocalDate getDropDate(){
        return dropDate;
    }

    // creation of int variable semester code
    public int getSemesterCode(){
        return semesterCode;
    }

    /*// appending of the year and semester code to create the name string
    public String nameString(){
        String name;

        name.append("");
        return name;
    }*/
}
