package edu.odu.cs.cs350.pne;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

//I have to fix this later to make sure it runs with the program's requirements
public class Enrollment_Projections {
    public String CommandLineParameters(String[] args)
    {
        
        //Code to add later on and fix for the unit test
        /**
         * May need a Java version of an initializer for the list of semester directories
         * ArrayList<Integer> semesterDirectories = new ArrayList();
         * Check to see if the parameters have a date format at the end
         * Check to see the paramters include a list of semester directories
         * Check to see if the parameters are in order? If else statements?
         * Sample code below from Steven Zeil at:
         * https://www.cs.odu.edu/~zeil/cs350/polawar/Protected/enrollmentProjectionDesign/index.html
         * int i = 0;
		    for (String clParam: args) {
			    System.out.println("CLI param " + i + " is: " + clParam);
			    ++i;
		    }
         */
        String response = "";
        //If there is 0
        if (args.length == 0)
        {   
            response = "Nothing is provided. Cannot run the projections...";
            System.out.println(response);
        }
        //If there is 1
        else if(args.length < 2)
        {
            response = "Historical enrollment is provided. Directory location is still needed...";
            System.out.println(response);
        }
        //If there is 2
        else if(args.length < 3)
        {
            response = "Historical enrollment is provided.";
            response += "Direction location is provided.";
            response += "However, a path to write the report is still needed...";
            System.out.println(response);
        }
        else
        {
            for(int i = 0; i < args.length; i ++)
            {
                response += args[i];
                System.out.println(args[i]);
            }
        }
        return response;
    }
}
