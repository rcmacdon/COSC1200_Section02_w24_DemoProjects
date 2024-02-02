/* *********************************
Title:      COSC1200-02 Project Template Creation
Author:     Clint MacDonald
Date:       Jan 22, 2024
Purpose:    To start to develop a reusable template for multiple projects we will use for demos
 */

// Main Class where the program starts
public class Main {

    // Global Variables
    static int correctNumber;
    static final int MIN_NUM = 1, MAX_NUM = 100;

    // Main method to start the application
    public static void main(String[] args) {

        initializeGame();
        runGame();
        closeGame();

    }

    private static void initializeGame() {
        System.out.println("Welcome to our Guess the number console game!");
        System.out.println("*********************************************");
        System.out.println("I have randomized a number between " + MIN_NUM +
                " and " + MAX_NUM + "!");
        System.out.println("Can you guess the number?");

        correctNumber = Tools.genRandomInt(MIN_NUM, MAX_NUM);
        // System.out.println("A random number is: " + correctNumber);
    }

    private static void runGame(){
        int guessedNumber = Tools.getIntFromConsole("Take a guess at the number!");

        guessedNumber = Tools.getIntFromConsole("Take a guess at the number!", MIN_NUM, MAX_NUM);

        System.out.println("Random number: " + correctNumber + " - your guess: " + guessedNumber);
    }

    private static void closeGame(){
        System.out.println("Good-bye!!!");
    }

}