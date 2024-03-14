/* **********************************
File:       COSC1200 - 02 Week 9 Exception Handling
Author:     Clint MacDonald
Date:       March 2024
Purpose:    Learning Exception Propagation
************************************* */
import java.io.IOException;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        //System.out.print("Test 1: " + test1());

        areaProgram();
    }

    public static String test1() {
        String retString = "";

        double subtotal = 0.0;
        System.out.print("Enter subtotal: ");

        try {
            subtotal = Double.parseDouble((sc.nextLine()));
            retString = String.format("Congrats, you entered a valid number: %s", subtotal);
        } catch (NumberFormatException ne) {
            retString = "That was not a number you silly goose!" + ne.toString();
        } catch (Exception e) {
            retString = "Unknown error: " + e.toString();
        } finally {
            retString += "\nThis should always show no matter what happens above!";
            // do what HAS TO happen no matter what happens in try-catch
        }

        return retString;
    }

    public static double test2(String customerType) {
        double discountPercent = 0.0;

        // preventing any exception through data validation
        // data validation is also exception handling
        if (customerType != null) {
            if (customerType.equalsIgnoreCase("R")) {
                discountPercent = 0.4;
            } else {
                discountPercent = 0.2;
            }
        }
        return discountPercent;
    }

    public static boolean isValidDouble(String inputString, double minValue, double maxValue) {
        boolean isValid = false;
        double dblValue;

        // test 1 - is it a double
        try {
            dblValue = Double.parseDouble(inputString);
        } catch (NumberFormatException ne) {
            System.out.println("Error! that was not a valid double!");
            return false;
        }

        // test 2 - is the number within the correct range
        if (dblValue >= minValue && dblValue <= maxValue) {
            isValid = true;
        } else {
            isValid = false;
        }

        return isValid;
    }

    /* ******************************************** */
    public static void areaProgram() {
        double length = 0.0, width = 0.0;
        System.out.println("********** Area of a Rectangle **********");

        length = getDoubleFromConsole("Enter the length (m): ");
        width = getDoubleFromConsole("Enter the width (m): ");

        System.out.printf("The area of the rectangle is: %f",
                Math.round(length * width * 100.)/100.);

        System.out.println("\n********** Done **********");
    }

    private static double getDoubleFromConsole(String prompt) {

        boolean isValid = false;
        double retDouble = 0.0;

        while (!isValid) {
            System.out.print(prompt);
            try{
                retDouble = Tools.getDoubleFromConsole(0,100);
                isValid = true;
            } catch (NumberFormatException ne) {
                System.out.println("That was not a valid double! Try again! " + ne.toString());
            }
        }

        return retDouble;
    }

}