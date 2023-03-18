package edu.odu.cs.cs350.pne;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

// inclusion of local date and time libraries
import java.time.LocalDate;
import java.time.LocalDateTime;

public class testSemester{

  

    /* This test will examine the semester code functionality of each semester directory */
    @Test
    public void testSemesterCodeCreation() {

        int code = 10;
        // each new semester directory must be constructed with two parameters start date and end date in YYYY,MM,DD format and then an int of semester code
        Semester semester = new Semester(LocalDate.of(2000, 9, 30), LocalDate.of(2000, 12, 30), code);
        
        // test the constructor
        assertThat(semester.getPreRegistrationDate(), equalTo(LocalDate.of(2000, 9, 30)));
        assertThat(semester.getAddDeadlineDate(), equalTo(LocalDate.of(2000, 12, 30)));
        assertThat(semester.getSemesterCode(), equalTo(10));

        // creation of a Semester name according to the year and semester
        assertThat(semester.nameString(), equalTo("200010"));
        

    }
    //recommit
}