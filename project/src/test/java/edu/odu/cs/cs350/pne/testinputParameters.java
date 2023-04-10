package edu.odu.cs.cs350.pne;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;

import edu.odu.cs.cs350.pne.Detailed_Report;

public class testinputParameters {
    

    @Test 
    public void testInputParametersCreation()
    {
        inputParameters param = new inputParameters(2);
        String val = "directory";
        param.setString(val);

        assertThat(param.getString(), equalTo(val));

        
    }

    // test the users ability to create a list of desired directory locations to search
    @Test
    public void testInputParameters1()
    {
       // test user ability to request one directory to search (expecting YYYYSM format) 
       // YYYY = year. SM = semester code.
       inputParameters input = new inputParameters(1);
       try{
       input.setString("202110");
       input.AddToList(input.getString());
       assertFalse(input.semesterDirList.isEmpty());
       assertEquals(input.semesterDirList.size(), 1);
       } catch (FileNotFoundException e) {};
    
       // what if the user provides an inaccurate dir name
       inputParameters input2 = new inputParameters(1);
       try{
       input2.setString("204710");
       input2.AddToList(input.getString());
       fail("Expected FileNotFoundException");
       } catch (FileNotFoundException e) {};

       // test the ability to add multiple directories to the list 
       // the directories will be one complete string that needs to be parsed
       inputParameters input3 = new inputParameters(1);
       input3.setString("202010 202130");
       try {
       input3.AddToList(input3.getString());
       assertFalse(input3.semesterDirList.isEmpty());
       File testFile = new File("/CS350-TeamE3-Repository/project/src/test/data/History/" + "202010");
       File testFile2 = new File("/CS350-TeamE3-Repository/project/src/test/data/History/" + "202130");
       assertEquals(input3.semesterDirList.get(0), testFile);
       assertEquals(input3.semesterDirList.get(1), testFile2);
       } catch (FileNotFoundException e){};

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

        // test users ability to create an output file with a predetermined location 
    // this output file will be subject to the reports (detailed and csv)
    @Test
    public void testInputParameters3()
    {
        inputParameters test1 = new inputParameters(3);
        test1.setString("src/outputFile.txt");
        assertThat(test1.getString(), equalTo("src/outputFile.txt"));
        File outFile = new File(test1.getString());
        try {
        test1.createOutputFile("src/outputFile.txt"); 
        } catch (IOException e){}
        assertTrue(outFile.exists());
    }

}