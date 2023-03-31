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

}