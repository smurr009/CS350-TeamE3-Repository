package edu.odu.cs.cs350.pne;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;
import edu.odu.cs.cs350.pne.Enrollment_Projections;

//These are very generic tests but I needed to see if it was possible to work somehting out here.
public class testEnrollmentProjections
{
    @Test
    public void testCommandLineParamatersNoLine()
    {
        String nullPointer = "";
        String verify = "";
        String verify1 = "";
        Enrollment_Projections test = new Enrollment_Projections();
        Enrollment_Projections test2 = new Enrollment_Projections();
        try {
            String args[] = {};
            verify = test.CommandLineParameters(args);
            System.out.println(verify);
            verify1 = test2.CommandLineParameters(args);
		}
		catch(NullPointerException e)
        {
            nullPointer = "NullPointerException thrown!";
			System.out.println(nullPointer);
		}
        
        assertFalse(verify.equals(nullPointer));
        assertTrue(verify.equals(verify1));
    }
    @Test 
    public void testCommandLineParamatersOneLine()
    {
        Enrollment_Projections test = new Enrollment_Projections();
        String testArray[] = {"Historical enrollment"};
        String verify1 = test.CommandLineParameters(testArray);
        Enrollment_Projections test2 = new Enrollment_Projections();
        String Arr[] = {};
        String verify2 = test2.CommandLineParameters(Arr);
        assertFalse(verify1.equals(verify2));
        
        String testerArray[] = {"Historical Enrollment"};
        verify2 = test2.CommandLineParameters(testerArray);
        assertTrue(verify2.equals(verify1));
    }
    @Test 
    public void testCommandLineParamatersTwoLines()
    {
        Enrollment_Projections test = new Enrollment_Projections();
        String testArr1[] = {"Historical enrollment", "Semester directory"};
        String verify1 = test.CommandLineParameters(testArr1);
        Enrollment_Projections test2 = new Enrollment_Projections();
        String Arr[] = {};
        String verify2 = test2.CommandLineParameters(Arr);
        assertFalse(verify1.equals(verify2));
        
        String testArr2[] = {"Historical Enrollment"};
        verify2 = test2.CommandLineParameters(testArr2);
        assertFalse(verify2.equals(verify1));

        String testArr3[] = {"Historical Enrollment", "Another semester directory"};
        verify2 = test2.CommandLineParameters(testArr3);
        assertTrue(verify2.equals(verify1));
    }
    @Test
    public void testCommandLineParametersThreeLines()
    {
        Enrollment_Projections test = new Enrollment_Projections();
        String testArr1[] = {"Historical enrollment", "Semester directory", "path"};
        String verify1 = test.CommandLineParameters(testArr1);
        Enrollment_Projections test2 = new Enrollment_Projections();
        String Arr[] = {};
        String verify2 = test2.CommandLineParameters(Arr);
        assertFalse(verify1.equals(verify2));
        
        String testArr2[] = {"Historical Enrollment"};
        verify2 = test2.CommandLineParameters(testArr2);
        assertFalse(verify2.equals(verify1));

        String testArr3[] = {"Historical Enrollment", "Another semester directory"};
        verify2 = test2.CommandLineParameters(testArr3);
        assertFalse(verify2.equals(verify1));

        String testArr4[] = {"Historical Enrollment", "Another semester directory", "path"};
        verify2 = test2.CommandLineParameters(testArr4);
        System.out.println(verify2);
        assertFalse(verify1.equals(verify2));
        
    }
}
