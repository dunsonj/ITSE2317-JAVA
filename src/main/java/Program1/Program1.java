package Program1;

//********************************************************************
//
//  Developer:    Textbook Authors
//
//  Program #:    One
//
//  File Name:    Program1.java
//
//  Course:       ITSE 2317 Intermediate Java Programming
//
//  Due Date:     9/16/2022
//
//  Instructor:   Prof. Fred Kumi
//
//  Chapter:      10
//
//  Description:  Employee hierarchy test class.  You are allowed to
//                modify only line 88.  If you modify any other part
//                of the class, you will not receive credit for
//                this program.
//
//********************************************************************

public class Program1
{
    //***************************************************************
    //
    //  Method:       main
    //
    //  Description:  The main method of the program
    //
    //  Parameters:   String array
    //
    //  Returns:      N/A
    //
    //**************************************************************
    public static void main(String[] args)
    {
        // Create an object of the main class and use it to call
        // the non-static developerInfo method
        Program1 obj = new Program1();
        obj.developerInfo();

        // create five-element Employee array
        Employee[] employees = new Employee[5];

        // initialize array with Employees
        employees[0] = new SalariedEmployee(
                "John", "Smith", "111-11-1111", 800.00);

        employees[1] = new HourlyEmployee(
                "Karen", "Price", "222-22-2222", 16.75, 40);

        employees[2] = new CommissionEmployee(
                "Sue", "Jones", "333-33-3333", 10000, .06);

        employees[3] = new BasePlusCommissionEmployee(
                "Bob", "Lewis", "444-44-4444", 5000, .04, 300);

        employees[4] = new PieceWorker(
                "Rick", "Bridges", "555-55-5555", 2.25, 400);

        System.out.println("Employees processed polymorphically:\n");

        // generically process each element in array employees
        for (Employee currentEmployee : employees)
        {
            System.out.println(currentEmployee); // invokes toString
            System.out.printf(
                    "earned $%,.2f\n\n", currentEmployee.earnings());
        } // end for

    } // end main

    //***************************************************************
    //
    //  Method:       developerInfo (Non Static)
    //
    //  Description:  The developer information method of the program
    //
    //  Parameters:   None
    //
    //  Returns:      N/A
    //
    //**************************************************************
    public void developerInfo()
    {
        System.out.println("Name:    <Jakira Dunson>");
        System.out.println("Course:  ITSE 2317 Intermediate Java Programming");
        System.out.println("Program: One\n\n");

    } // End of the developerInfo method

} // End of class Program1
