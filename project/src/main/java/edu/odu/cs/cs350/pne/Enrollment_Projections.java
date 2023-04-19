package edu.odu.cs.cs350.pne;
import java.util.List;
import java.util.ArrayList;

//Needs to get data from EnrollmentSpanshots
public class Enrollment_Projections {
    private List<Semester> Semesters = new ArrayList<>();
    
    /**
     * The default Constructor
     */
    public Enrollment_Projections()
    {
        
    }

    /**
     * Calculates the projection for the future semester with data from the current and historical snapshots
     *  
     */
    public int Enrollment_Projection_Formula()
    {
     /**
      *  Current (projection) = [current(last day) /historical(last day)] historical (enrollment on add deadline)
      */
      int enrollmentProjections = 0;

      return enrollmentProjections;

    }
    
    /**
     * Calculates the interpolation between the current and historical snapshots
     * 
     */
    public int Interpolation()
    {
      int interpolation = 0;
      return interpolation;  
    }
}
