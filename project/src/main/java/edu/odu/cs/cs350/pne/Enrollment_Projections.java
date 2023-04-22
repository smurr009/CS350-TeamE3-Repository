package edu.odu.cs.cs350.pne;
import java.util.List;
import java.util.Vector;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.math.*;
//Needs to get data from EnrollmentSpanshots
public class Enrollment_Projections {
    
    private  Map<String, Integer> Course_and_Enrollment = new HashMap<String, Integer>();
    private List<Semester> Semesters = new ArrayList<>();

    /**
     * Calculates the projection for the future semester with data from the current and historical snapshots
     *  
     */
    void Enrollment_Projection_Formula(LocalDate targetDate)
    {
     /**
      *  Current (projection) = [current(last day) /historical(last day)] * historical (enrollment on add deadline)
      */
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
          int historicalATDead =  historicalSnapshot.getOverallEnrollment(courseName);
          int currentAtTarget = currentSnapshot.getOverallEnrollment(courseName);
          int historicalAtTarget = historical.getSnapshot(targetDate).getOverallEnrollment(courseName);
          int currentAtDeadline = (currentAtTarget / historicalAtTarget) * historicalATDead;
          Course_and_Enrollment.put(courseName, Math.round(currentAtDeadline));
        }
      }
      //For semesters where there's more than two
      else
      {
        Semester current = Semesters.get(Semesters.size() - 1);
        EnrollmentSnapshot currenSnap = current.getSnapshot(targetDate);
        //A vector to hold historical semesters
        Vector <Semester> historicalSemesters = new Vector<Semester>();
        Vector<EnrollmentSnapshot> historicalSnapshots = new Vector<EnrollmentSnapshot>();
        for(int j = 0; j < Semesters.size()-1; j++)
        {
          historicalSemesters.add(Semesters.get(j));  //This gets the historical semesters
          historicalSnapshots.add(historicalSemesters.get(j).getSnapshot(targetDate)); //This gets the snapshots of the current date
        }
        int currentAtTargetD;
        int historicalATDead;
        int historicalAtTargetD;
        int currentATDeadline;
      }
      
    }
    
    /**
     * Calculates the interpolation between the current and historical snapshots
     * 
     */
    public void Interpolation(LocalDate aDate, LocalDate bDate)
    {
      int interpolation = 0;
      if(Semesters.size() >= 4)
      {
        Semester current = Semesters.get(Semesters.size()-1);
        Vector <Semester> historicalSemesters = new Vector<Semester>();
        Vector <EnrollmentSnapshot> historicalSemestersSnapshots = new Vector<EnrollmentSnapshot>();
        for(int k = 0; k < Semesters.size()-1; k++)
        {
          historicalSemesters.add(Semesters.get(k));  //This gets the historical semesters
        }
      }
      else
      {

      }
       
    }

    public int getSpecificEnrollment(String SemCourseName)
    {
      return Course_and_Enrollment.get(SemCourseName);
    }
}
