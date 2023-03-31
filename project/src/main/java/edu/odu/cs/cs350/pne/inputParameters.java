package edu.odu.cs.cs350.pne;

import java.io.File;
import java.io.FileNotFoundException;

// each parameter entered in CLI.java would become a new inputParameter(int val)
public class inputParameters{

    int type;
    String userInput;

    // creation of an object of a type
    public inputParameters(int val)
    {
        this.type = val;
    }

    // allow user to set a string 
    public void setString(String val)
    {
        this.userInput = val;
    }

    // allow user to retrieve an input string
    public String getString()
    {
        return this.userInput;
    }

    public File findEnrollmentHistory(String directoryName) throws IllegalStateException, FileNotFoundException
    {
        if (this.type == 2){
            // try to find the directory matching the provided directory name
            File fileLocation = new File ("/CS350-TeamE3-Repository/project/src/test/data/History/" + directoryName);

            if (fileLocation.exists() == true) {return fileLocation;}
            else {
                throw new FileNotFoundException("file not found");
            }
        }
        
        // if parameter is of wrong type throw exception
        else {throw new IllegalStateException("invalid parameter");}
    }

    // based on the parameters received, execute their desired instruction
    private void executeCLI(){
        
        /* Reference of input parameter types
         * 
         * 1) A list of one or more semester directory locations, indicating the locations of historical enrollment data.
         * 2) A single semester directory location, indicating the enrollment data for the semester for which a projection is desired.
         * 3) A path indicating the file location where the detailed projection report will be written.
         * 4) Optionally, a date, written in the format YYYY-MM-DD, indicating the last day on which enrollment data from he semester being projected should be examined.
         */

    if (this.type == 1){ /* historical enrollment list */ }
    else if (this.type ==  2){ /* desired enrollment projection, data location */ }
    else if (this.type ==  3){ /* write-back location */ }
    else if (this.type ==  4){ /* YYYY-MM-DD format input */ }

    }
}