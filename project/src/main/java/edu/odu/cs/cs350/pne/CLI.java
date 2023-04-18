package edu.odu.cs.cs350.pne;

//imports from apache 
//import org.apache.commons.cli.CommandLine;
//import org.apache.commons.cli.CommandLineParser;
import edu.odu.cs.cs350.pne.inputParameters;

public class CLI {

    public static void CreateInputObjects(String input1, String input2, String input3, String input4)
    {

    }

    public static void main(String [] args){

        String parameter1 = "";
        String parameter2 = "";
        String parameter3 = "";
        String parameter4 = "";

       
        // if args is less than or equal to zero no input provided then tell the terminal
        if (args.length <= 0){
            System.out.println("No command line input provided. Try again");
        }

        // else then parse the command line input to discover what is what
        else {
            int userInputLength = args.length ;

            // the user did not provide as many parameters as required
            if (userInputLength < 4){
                System.out.println("Not enough provided parameters. Try again");
            }
            // this is the required minimum size of the input
            else if (userInputLength == 4 ){
                parameter1 = args[0];
                parameter2 = args[1];
                parameter3 = args[2];
                parameter4 = args[3];

            }

            // any number greater than 4 assumes that the user inputted a list for parameter 1
            else if(userInputLength > 4){
                int amtOfHistoricalData = userInputLength - 3;

                for (int i = 1; i <= amtOfHistoricalData; i++){
                    parameter1= parameter1 + args[i-1];
                }

                parameter2 = args[userInputLength-3];
                parameter3 = args[userInputLength-2];
                parameter4 = args[userInputLength-1];

            }

            // create the relevant input parameter objects
            inputParameters stringOne = new inputParameters(1);
            stringOne.setString(parameter1);
            stringOne.executeCLI();
    
            inputParameters stringTwo = new inputParameters(2);
            stringTwo.setString(parameter2);
            stringTwo.executeCLI();
    
            inputParameters stringThree = new inputParameters(3);
            stringThree.setString(parameter3);
            stringThree.executeCLI();
    
            inputParameters stringFour = new inputParameters(4);
            stringFour.setString(parameter4);
            stringFour.executeCLI();

            //CreateInputObjects(parameter1, parameter2, parameter3, parameter4);
        }

    }

}
