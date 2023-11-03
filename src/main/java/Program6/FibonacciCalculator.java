package Program6;
//***************************************************************
//  Developer:         <Jakira Dunson>
//
//  Program #:         <Program 6>
//
//  File Name:         <FibonacciCalculator.java>
//
//  Course:            ITSE 2317 Java Programming (Intermediate)
//
//  Due Date:          <Oct 31, 2023>
//
//  Instructor:        Prof. Fred Kumi
//
//  Description: <Recursion>
//***************************************************************

// Fig. 18.5: FibonacciCalculator.java
// Recursive fibonacci method.
// Fig. 18.5: FibonacciCalculator.java
// Recursive fibonacci method.

import Program5.Program5;

import java.math.BigInteger;

public class FibonacciCalculator {
    private static BigInteger TWO = BigInteger.valueOf(2);

    // recursive declaration of method fibonacci
    //***************************************************************
    //  Method:       BigInteger
    //
    //  Description:
    //
    //  Parameters:   BigInteger
    //
    //  Returns:      BigInteger
    //**************************************************************
    public static BigInteger fibonacci(BigInteger number) {
        if (number.equals(BigInteger.ZERO) || number.equals(BigInteger.ONE)) { // base cases
            return number;
        } else { // recursion step
            return fibonacci(number.subtract(BigInteger.ONE)).add(fibonacci(number.subtract(TWO)));
        }
    }

    //***************************************************************
    //  Method:       main
    //
    //  Description:  The main method of the program
    //
    //  Parameters:   String array
    //
    //  Returns:      N/A
    //**************************************************************
    public static void main(String[] args) {

        Program5 obj = new Program5();
        obj.developerInfo();


        //this needs to be removed
        // displays the fibonacci values from 0-40
        for (int counter = 0; counter <= 40; counter++) {
            System.out.printf("Fibonacci of %d is: %d%n", counter, fibonacci(BigInteger.valueOf(counter)));
        }
    }

    //***************************************************************
    //
    //  Method:       developerInfo
    //
    //  Description:  The developer information method of the program
    //
    //  Parameters:   None
    //
    //  Returns:      N/A
    //
    //**************************************************************
    public void developerInfo() {
        System.out.println("Name:    Jakira Dunson");
        System.out.println("Course:   ITSE 2317 Java Programming (Intermediate)");
        System.out.println("Program: Six \n");

    } // End of developerInfo
}