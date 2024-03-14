/* **********************************
File:       Tools File to go with Exception Handling Demo
Author:     Clint MacDonald
Date:       March 2024
Purpose:    To separate error handling and user interface
************************************* */
import java.util.Scanner;

public class Tools {
    static Scanner sc = new Scanner(System.in);

    public static double getDoubleFromConsole() throws NumberFormatException {
        return Double.parseDouble(sc.nextLine());
    }

    public static double getDoubleFromConsole(double minValue, double maxValue)
            throws NumberFormatException {
        double dblValue = 0.0;
        dblValue = Double.parseDouble(sc.nextLine());

        if (dblValue >= minValue && dblValue <= maxValue) {
            return dblValue;
        } else {
            throw new NumberFormatException("That number was not in the valid range!");
        }

    }
}
