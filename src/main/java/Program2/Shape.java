package Program2;

//******************************************************************************
//
//  Developer:    Instructor
//
//  Program #:    Program 2
//
//  File Name:    Shape.java
//
//  Course:       ITSE 2317 Java Programming (Intermediate)
//
//  Due Date:     9/23/2022
//
//  Instructor:   Fred Kumi
//
//  Chapter:      10
//
//  Description:  This abstract superclass provides the general design
//	              of Shape objects. Please do NOT modify this class.
//                If you do, you will not receive credit for this program.
//
//******************************************************************************
public abstract class Shape
{
    protected final double PI = 3.14159; // For calculations involving radius

    public abstract double getArea();
}