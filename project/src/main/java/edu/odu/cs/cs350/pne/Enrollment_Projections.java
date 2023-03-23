package edu.odu.cs.cs350.pne;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

//I have to fix this later to make sure it runs with the program's requirements
//I'm going to use an ArrayList to use
public class Enrollment_Projections {
    public void CommandLineParameters(String[] args) throws IOException
    {
        boolean semesterDirectoryhistorical = false;
        boolean semesterDirectoryLocation = false;
        //This doesn't take into consideration the last date option
        if(args.length < 4)
        {
            for(int i = 0; i < args.length;i++)
            {
                if(args[i].contains("2022"))
                {

                }
            }
            
        }
        //I need to take into consideration the last date option and the list of semester directories
        

    }
}
