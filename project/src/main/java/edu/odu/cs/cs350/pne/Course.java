package edu.odu.cs.cs350.pne;

import java.lang.String;

public class Course{
    protected String CourseNumber;
    protected String Subject;

    /**
     * Create new "blank" Course
     */
    public Course() {
        CourseNumber = "";
        Subject = "";
    }

    /**
     * Create new Course
     * @param subj course subject e.g. "CS"
     * @param cnum numeric course identifier e.g. "350"
     */
    public Course(String subj, String cnum) {
        Subject = subj;
        CourseNumber = cnum;
    }

    /**
     * Get Course Name for this Course
     * @return concatenation of Subject and Course Number
     */
    public String getCourseName() { return Subject + CourseNumber; }

    /**
     * Get Course Number for this Course
     * @return Course Number
     */
    public String getCourseNumber() { return CourseNumber; }

    /**
     * Get Subject for this Course
     * @return Subject
     */
    public String getSubject() { return Subject; }

    /**
     * Set Subject for this Course
     * @param subj course subject e.g. "CS"
     */
    public void setSubject(String subj) { Subject = subj; }

    /**
     * Set Course Number for this Course
     * @param cnum numeric course identifier e.g. "350"
     */
    public void setCourseNumber(String cnum) { CourseNumber = cnum; }
    
}
