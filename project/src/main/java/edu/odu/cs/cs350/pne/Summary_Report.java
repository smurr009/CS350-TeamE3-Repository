package edu.odu.cs.cs350.pne;

import java.lang.String;

public class Summary_Report {
    protected String Course;
    Course obj;
    Section obj2;
    /**
     *
     */
    public int percent;
    public int enrollment;
    public int Projected;
    public int cap;
    //string course;



/**
     * Create new "blank" Course
     */
    public Summary_Report() {
        Course = "";
        percent = 0;
        enrollment = 0;
        cap = 0;
    }

    /**
     * Create new copy of the current Course
     */
    public Summary_Report(String c, int p, int e, int pr, int ca) {
        Course = c;
        percent = p;
        enrollment = e;
        Projected = pr;
        cap = ca;
    }
/**
 * Return the course name
 * @return
 */
    public String getCourse(){
        return Course;
    }

    /**
 * Return the percentage
 * @return
 */
    public int getPercentage(){
        return percent;
}

public int getEnrollment(){
    return enrollment;
}

public int getEnrollmentCap(){
    return cap;
}

public int getProjected(){
    return Projected;
}
    public void setCourseName(String c){
        obj.setSubject(c);
    }
/**
 * 
 * Display the report 
 */
    public void Display(){
        int cap,actual;
        cap = obj2.getEnrollmentCap();
        actual = obj2.getEnrolled();
        percent = actual/cap *100;
        System.out.print(percent);
        System.out.println("% of enrollment period has elapsed. \n");
        System.out.println("Course Enrollment Projected Cap \n");
        //while()
        System.out.print("CS");
        System.out.println(obj2.getCourseNumber());
    }





}






    