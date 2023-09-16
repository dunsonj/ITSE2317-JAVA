package Program1;

//********************************************************************
//
//  Developer:    Textbook Authors
//
//  Program #:    One
//
//  File Name:    Employee.java
//
//  Course:       ITSE 2317 Intermediate Java Programming
//
//  Due Date:     9/16/2022
//
//  Instructor:   Prof. Fred Kumi
//
//  Chapter:      10
//
//  Description:  Employee abstract class.  Please do NOT modify
//                this class.  If you do, you will not receive
//                credit for this program.
//
//********************************************************************

public abstract class Employee
{
    private final String firstName;
    private final String lastName;
    private final String socialSecurityNumber;

    // constructor
    public Employee(String firstName, String lastName,
                    String socialSecurityNumber)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
    }

    // return first name
    public String getFirstName()
    {
        return firstName;
    }

    // return last name
    public String getLastName()
    {
        return lastName;
    }

    // return social security number
    public String getSocialSecurityNumber()
    {
        return socialSecurityNumber;
    }

    // return String representation of Employee object
    @Override
    public String toString()
    {
        return String.format("%s %s%nsocial security number: %s",
                getFirstName(), getLastName(), getSocialSecurityNumber());
    }

    // abstract method must be overridden by concrete subclasses
    public abstract double earnings(); // no implementation here

} // end abstract class Employee


