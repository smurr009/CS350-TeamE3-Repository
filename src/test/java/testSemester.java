package test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

// inclusion of local date and time libraries
import java.time.LocalDate;
import java.time.LocalDateTime;

public class TestSemester{

  

    /* This test will examine the semester code functionality of each semester directory */
    @Test
    public void testSemesterCode() {

        // each new semester directory must be constructed with two parameters start date and end date in YYYY,MM,DD format
        Semester semester = new Semester(LocalDate.of(2000, 9, 30), LocalDate.of(2000, 12, 30));
        
        

    }
}