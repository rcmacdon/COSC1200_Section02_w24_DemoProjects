/* ****************************
Title:      A file that contains various reusable tools for future programs
Author:     Clint MacDonald
Date:       Jan 22, 2024
Purpose:    Starting to learn how to build OOP methods across multiple files
 */
import java.util.Scanner;

// The main container class for our various tools that we will build
public class Tools {

    // generate a random integer within a provided range
    public static int genRandomInt(int lowerBound, int upperBound) {
        return (int)(Math.random() * (upperBound - lowerBound + 1) + lowerBound);
    }

    // have the system output a prompt and wait to receive an integer.
    public static int getIntFromConsole(String inputString){
        return getValidInteger(inputString);
    }

    public static int getIntFromConsole(String inputString, int lowerBound, int upperBound) {
        int myInt = lowerBound - 1;
        while (myInt < lowerBound || myInt > upperBound) {
            myInt = getValidInteger(inputString);

            if (myInt < lowerBound || myInt > upperBound ) {
                System.out.println("That number is not in the correct range!");
            }
        };

        return myInt;
    }

    private static int getValidInteger(String inputString) {
        Scanner scanner = new Scanner(System.in);
        int inputInt = -1;

        do {
            System.out.print(inputString + " > ");
            while (!scanner.hasNextInt()) {
                System.out.println("That was not a number!");
                System.out.print(inputString + " > ");
                scanner.next();
            }
            inputInt = scanner.nextInt();

        } while (inputInt <= 0);

        return inputInt;
        // source code partially obtained from polygenelubricants on Jun 17, 2010 from stackoverflow
        // url: https://stackoverflow.com/questions/3059333/validating-input-using-java-util-scanner
    }

}
