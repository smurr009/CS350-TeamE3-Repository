package edu.odu.cs.cs350.pne;

import java.io.File;
import java.io.FileOutputStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;

import edu.odu.cs.cs350.pne.Detailed_Report;

public class testCommandLine {
    

    @Test 
    public void testInputParametersCreation()
    {
        inputParameters param = new inputParameters(2);
        String val = "directory";
        param.setString(val);

        assertThat(param.getString(), equalTo(val));

        
    }

    // test the attachment of the input parameters type 2
    // Type 2 being the connection to the enrollment projection files
    @Test
    public void testInputParameters2()
    {
        // test if function is exclusive to type 2 parameters
        inputParameters param = new inputParameters(1);
        try {
        param.findEnrollmentHistory(); 
        } catch (IllegalStateException e) {}

        // test the parameters ability to find a directory based on a string 
        // if exists return directory location, if file does not exist throw exception
        inputParameters param2 = new inputParameters(2);
        param2.setString("202010");
        assertThat(param.getString(), equalTo("202010"));
        File filepath = param2.findEnrollmentHistory(param.getString());
        assertTrue(filepath.exists());

    }

}