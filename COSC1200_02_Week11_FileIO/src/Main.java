/* **********************************
File:       COSC1200 - 02 - Week 11 - File IO Main File
Author:     Clint MacDonald
Date:       March 2024
Purpose:    Learning basic read and write operations to text files.
************************************* */
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

// Main Program where the application starts
public class Main {

    static Scanner sc = new Scanner(System.in);

    // Main method where the application starts
    public static void main(String[] args) {
        //initializeApp();
        runProgram();
        //closeApp();
    }

    /**
     * The method to actually run the application workflow
     */
    private static void runProgram() {

        // obtain a filename from the user
        String filename = "";
        filename = getFileName();

        // read the file into the Queue of Tasks
        readFile(filename);

        // Iterate through the data and change all dates
        for (Task task: Task.tasks) {
            task.setDueDate(task.getDueDate().plusDays(7));
        }

        // Write back out to the file
        writeFile(filename);

    }

    /**
     * A quick method to obtain a string based filename from the user console window
     * @return String - representing the name of the file
     */
    private static String getFileName() {
        System.out.print("Enter the file name, including the path: ");
        String fileName = sc.nextLine();
        return fileName;
        // don't forget the data validation and exception handling
    }

    /**
     * Wrapper function to read tasks from a file and populate the tasks queue
     * @param filename - string received previously from user input
     */
    private static void readFile(String filename) {
        System.out.println("Let's go reading files !");

        try {
            Task.readFromFile(filename);
        } catch (IOException ioe) {
            System.out.println("IO Error: " + ioe.getMessage());
        }

        // output tasks to screen to show they loaded
        for (Task task: Task.tasks) {
            System.out.print(task.toString());
        }

    }

    /**
     * A wrapper function to execute the task file write method including
     * exception handling and messaging to the UI
     * @param filename
     */
    private static void writeFile(String filename) {
        try {
            Task.writeToFile(filename);
        } catch (IOException ioe) {
            System.out.println("IO Write Exception: " + ioe.getMessage());
        }
    }
}