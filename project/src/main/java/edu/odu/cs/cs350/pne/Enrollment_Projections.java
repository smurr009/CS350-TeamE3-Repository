package edu.odu.cs.cs350.pne;
import java.util.List;
import java.util.Vector;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
//Needs to get data from EnrollmentSpanshots
public class Enrollment_Projections {
    private List<Semester> Semesters = new ArrayList<>();

    /**
     * Calculates the projection for the future semester with data from the current and historical snapshots
     *  
     */
    public int Enrollment_Projection_Formula(LocalDate targetDate)
    {
     /**
      *  Current (projection) = [current(last day) /historical(last day)] historical (enrollment on add deadline)
      */
      
      //This is to hold the enrollment Projections for all of the courses
      Vector<Integer> enrollment_Projections = new Vector<Integer>();
      Map<String, Integer> Course_and_Enrollment = new HashMap<String, Integer>();
      //For two semesters (one historical and one current)
      if(Semesters.size() == 2)
      {
        //Temporary variables
        Semester historical = Semesters.get(0);
        Semester current = Semesters.get(1);
        EnrollmentSnapshot currentSnapshot = current.getSnapshot(targetDate);
        EnrollmentSnapshot historicalSnapshot = historical.getSnapshot(targetDate);
        //For loop to iterate through courses and get the overall enrollment at that date
        for(String courseName : historicalSnapshot.getCourses())
        {
          //A list of courses and the number of students enrolled at this date and time
          Course_and_Enrollment.put(courseName, historicalSnapshot.getOverallEnrollment(courseName));
        }
      }
      //For semesters where there's more than two
      for(int i = 0; i < Semesters.size(); i++)
      {
        Semester current = Semesters.get(Semesters.size() - 1);
        //A vector to hold historical semesters
        Vector <Semester> historicalSemesters = new Vector<Semester>();
        for(int j = 0; j < Semesters.size()-1; i++)
        {
          historicalSemesters.add(Semesters.get(j));
        }
        

      }
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
