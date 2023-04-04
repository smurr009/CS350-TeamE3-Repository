package edu.odu.cs.cs350.pne;

import java.time.LocalDate;

//Needs to get data from EnrollmentSpanshots
public class Enrollment_Projections {
    LocalDate currentEndDate;
    LocalDate historicalEndDate;

    /**
     * The default Constructor
     */
    public Enrollment_Projections()
    {
        currentEndDate = LocalDate.now();
        historicalEndDate =  LocalDate.now();
    }
    
    /**
     * Create a new Enrollment_Projection
     * @param ceDate
     * @param heDate
     */
    public Enrollment_Projections(LocalDate ceDate, LocalDate heDate)
    {
        currentEndDate = ceDate;
        historicalEndDate = heDate;
    }
    /**
     * Calculates the projection for the future semester with data from the current and historical snapshots
     * @param cDate
     * @param hDate
     */
    public void Enrollment_Projection_Formula(LocalDate cDate, LocalDate hDate)
    {
        
    }
    
    /**
     * Calculates the interpolation between the current and historical snapshots
     * @param cDate
     * @param haDate
     * @param hbDate
     */
    public void Interpolation(LocalDate cDate, LocalDate haDate, LocalDate hbDate)
    {
        //Current and historical enrollments as well (I don't understand the formula all that well)
        //Fill in later
    }
}
