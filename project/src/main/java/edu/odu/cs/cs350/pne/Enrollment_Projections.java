package edu.odu.cs.cs350.pne;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Enrollment_Projections {
    public String CommandLineParameters(String[] args)
    {
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
