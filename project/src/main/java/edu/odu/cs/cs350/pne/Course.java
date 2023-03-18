package edu.odu.cs.cs350.pne;

import java.lang.String;

public class Course{
    private String CourseNumber;
    private String Subject;

    public Course() {
        CourseNumber = "";
        Subject = "";
    }

    public Course(String _Subject, String _CourseNumber) {
        Subject = _Subject;
        CourseNumber = _CourseNumber;
    }

    public String getCourseName() { return Subject + CourseNumber; }
    public String getCourseNumber() { return CourseNumber; }
    public String getSubect() { return Subject; }

    public void setCourseNumber(String _CourseNumber) { CourseNumber = _CourseNumber; }
    public void setSubject(String _Subject) { Subject = _Subject; }
}
