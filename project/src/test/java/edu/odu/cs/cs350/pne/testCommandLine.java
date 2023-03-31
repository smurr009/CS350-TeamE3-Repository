package edu.odu.cs.cs350.pne;

import java.io.File;
import java.io.FileNotFoundException;
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
        param.findEnrollmentHistory("test");
        fail("Expected Illegal State Exception"); 
        } catch (IllegalStateException | FileNotFoundException e) {}

        // test the parameters ability to find a directory based on a string 
        // if exists return directory location, if file does not exist throw exception
        inputParameters param2 = new inputParameters(2);
        param2.setString("202010");
        assertThat(param2.getString(), equalTo("202010"));
        try{
        File filepath2 = param2.findEnrollmentHistory(param2.getString());
        assertTrue(filepath2.exists());
        } catch (FileNotFoundException e){}

        // test the parameters ability to notice non existing filepaths and throw exception
        inputParameters param3 = new inputParameters(2);
        param3.setString("dumb");
        assertThat(param3.getString(), equalTo("dumb"));
        try{
        File filepath3 = param3.findEnrollmentHistory(param3.getString());
        assertFalse(filepath3.exists());
        fail("Expected File Not Found Exception");
        }
        catch (FileNotFoundException e){}

    }

}