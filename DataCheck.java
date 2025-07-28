// Mahir Ashab Enan
// CSE 07 Homework 4

import java.util.Scanner;

public class DataCheck {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        // Variable to store course number (integer)
        int courseNumber;

        // Prompt user to enter course number and validate input
        System.out.println("Please enter the course number: ");
        while (true) {
            // Check if the input is an integer
            if (myScanner.hasNextInt()) {
                courseNumber = myScanner.nextInt();
                break; // Valid input, exit the loop
            } else {
                System.out.println("That's not a valid integer. Try again: ");
                myScanner.next(); // Clear the invalid input
            }
        }

        // Variable to store department name (single word string)
        String departmentName;

        // Prompt user to enter department name and validate input
        System.out.println("Please enter the department name: ");
        while (true) {
            // Check if the input is a valid string (word)
            if (myScanner.hasNext()) {
                departmentName = myScanner.next();
                break; // Valid input, exit the loop
            } else {
                System.out.println("That's not a valid department name. Try again: ");
                myScanner.next(); // Clear the invalid input
            }
        }

        // Variable to store number of class meetings per week (integer)
        int meetingsPerWeek;

        // Prompt user to enter number of weekly class meetings and validate input
        System.out.println("Please enter the number of times your class meets per week: ");
        while (true) {
            // Check if the input is an integer
            if (myScanner.hasNextInt()) {
                meetingsPerWeek = myScanner.nextInt();
                break; // Valid input, exit the loop
            } else {
                System.out.println("That's not a valid integer. Try again: ");
                myScanner.next(); // Clear the invalid input
            }
        }

        // Variable to store class start time in military format (integer)
        int classStartTime;

        // Prompt user to enter class start time in military format and validate input
        System.out.println("Please enter your class start time in military format (e.g., 1500 for 3 PM): ");
        while (true) {
            // Check if the input is an integer
            if (myScanner.hasNextInt()) {
                classStartTime = myScanner.nextInt();
                break; // Valid input, exit the loop
            } else {
                System.out.println("That's not a valid time. Try again: ");
                myScanner.next(); // Clear the invalid input
            }
        }

        // Variable to store instructor's name (single word string)
        String instructorName;

        // Prompt user to enter instructor's name and validate input
        System.out.println("Please enter your instructor's name: ");
        while (true) {
            // Check if the input is a valid string (word)
            if (myScanner.hasNext()) {
                instructorName = myScanner.next();
                break; // Valid input, exit the loop
            } else {
                System.out.println("That's not a valid name. Try again: ");
                myScanner.next(); // Clear the invalid input
            }
        }

        // Variable to store the number of students in the class (integer)
        int numberOfStudents;

        // Prompt user to enter the number of students and validate input
        System.out.println("Please enter the number of students in your class: ");
        while (true) {
            // Check if the input is an integer
            if (myScanner.hasNextInt()) {
                numberOfStudents = myScanner.nextInt();
                break; // Valid input, exit the loop
            } else {
                System.out.println("That's not a valid integer. Try again: ");
                myScanner.next(); // Clear the invalid input
            }
        }

        // Display all the collected information in a formatted output
        System.out.printf(
            "Course Number: %d, Department: %s, Weekly Meetings: %d, Start Time: %d, Instructor: %s, Number of Students: %d\n", 
            courseNumber, departmentName, meetingsPerWeek, classStartTime, instructorName, numberOfStudents
        );
    }
}


