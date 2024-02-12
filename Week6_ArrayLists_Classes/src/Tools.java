/* *************************************************
Title:      Tools Class file for our template project
Author:     Clint MacDonald
Date:       Jan 22, 2024
Purpose:    A Collection class to store a series of user-defined tools
************************************************* */
import java.io.IOException;
import java.util.Scanner;
import java.io.Console;

// Main Tools Class for this files
public class Tools {

    static Scanner sc = new Scanner(System.in);

    // a simple tool that returns a random integer within a provided range
    public static int genRandomInt(int lowerBound, int upperBound) {
        return (int)(Math.random() * (upperBound - lowerBound + 1) + lowerBound);
    }

    //<editor-fold desc="Console Input">

    public static void pauseProgram() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Press Enter to continue...");
        scanner.nextLine(); // Waits for user to hit Enter
    }

    //<editor-fold desc="Numbers">
    // a simple tool to obtain an integer from the console user
    public static int getIntFromConsole(String inputPrompt){

        int inputNumber = -1;
        do {
            System.out.print(inputPrompt);
            while (!sc.hasNextInt()) {
                System.out.println("That was not a number!");
                sc.next();
            }
            inputNumber = sc.nextInt();
        } while (inputNumber <= 0);

        return inputNumber;

        // code was originally sourced from polygenelubricants on Jun 17, 2010
        // https://stackoverflow.com/questions/3059333/validating-input-using-java-util-scanner
    }

    public static int getIntFromConsole(String inputPrompt, int lowerBound, int upperBound) {
        int inputNumber = -1;
        String inputString;

        do {
            System.out.print(inputPrompt + " ( " + lowerBound + " - " + upperBound + ") > ");
            inputString = sc.nextLine();
        } while (!isStringNumeric(inputString, lowerBound, upperBound));

        return Integer.parseInt(inputString);
    }

    public static double getDblFromConsole(String inputPrompt){
        double inputNumber = -1.;
        String inputString;
        do {
            System.out.print(inputPrompt + " > ");
            inputString = sc.nextLine();
        } while (!isStringDecimal(inputString));

        return Double.parseDouble(inputString);
    }
    //</editor-fold>

    //<editor-fold desc="Strings">
    // simple method to obtain a single char from the user in the console window
    public static String getSingleCharFromConsole(String inputPrompt) {

        String inputString;
        String returnString = "";
        boolean isValid = true;

        do {
            System.out.print(inputPrompt + " > ");
            try {
                inputString = sc.nextLine();
                returnString = inputString.substring(0, 1);
                //System.out.println("TEST: user input: " + returnString);
                isValid = true;
            } catch (Exception e) {
                isValid = false;
            }
        } while (!isValid);

        return returnString;
    }

    public static String getStringFromConsole(String inputPrompt) {
        System.out.print(inputPrompt + " > ");
        return sc.nextLine();
    }

    public static String getStringKeyPress(String inputPrompt) {
        System.out.print(inputPrompt + " > ");
        String keyPressed = "";

        try {
            keyPressed = String.valueOf(System.console().reader().read());
        } catch(IOException ioe) {
            System.out.println("Error: " + ioe.toString());
        }

        return keyPressed;
    }
    //</editor-fold>
    //</editor-fold>

    //<editor-fold desc="Input Validations">
    private static boolean isStringNumeric(String inputString) {
        boolean isValid = true;

        try {
            int testNumber = Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            isValid = false;
        }

        return isValid;
    }

    private static boolean isStringDecimal(String inputString) {
        boolean isValid = true;

        try {
            double testNumber = Double.parseDouble(inputString);
        } catch (NumberFormatException e) {
            isValid = false;
        }

        return isValid;
    }

    private static boolean isStringNumeric(String inputString, int lowerBound, int upperBound) {
        int testNumber;

        // is the number numeric
        try {
            testNumber = Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            return false;
        }

        // is the number within the correct range?
        return testNumber <= upperBound && testNumber >= lowerBound;
    }

    //</editor-fold>

}
