/* ***************************************
COSC1200 - Section 2 - Week 6
Clint MacDonald
Feb 12, 2024
Array Lists and Intro to Object Classes
 */

import java.util.ArrayList;

// Main collection Class
public class Main {

    // Application starting point
    public static void main(String[] args) {
        mainMenu();
    }

    // running the main menu
    private static void mainMenu(){

        boolean isContinue = true;

        // loop until the user actually chooses to exit
        do {
            // output the menu
            System.out.println("""
                    Week 6 - Main Menu
                    1. Demo 1 - Array Lists
                    2. Demo 2 - OOP Concepts
                    3. Demo 3 - Intro to Object Classes
                    0. EXIT
                    """);
            int choice = Tools.getIntFromConsole("Please enter your choice:", 0, 3);
            System.out.println("You chose: " + choice);

            // process the users choice
            if (choice == 1) demo1();
            else if (choice == 2) demo2();
            else if (choice == 3) demo3();
            else if (choice == 0) isContinue = false;

        } while (isContinue);

    }

    //<editor-fold desc="Demo 1 - Array Lists">
    private static void demo1(){
        System.out.println("""
                **************************
                Array Lists
                **************************
                """);

        ArrayList<String> students = new ArrayList<String>();

        students.add("John");
        students.add("Bob");
        students.add("Sally");
        System.out.println("\nAdded 3 students to the array list!");
        System.out.println(students);

        System.out.println("\nAdded Jennifer at index 1!");
        students.add(1,"Jennifer");
        System.out.println(students);

        System.out.println("\nRetrieve an element from the array!");
        System.out.println(students.get(2));

        System.out.println("\nEdit a value of a given element index!");
        students.set(2, "Bobby");
        System.out.println(students);

        System.out.println("\nRemove a value from the list given an index number!");
        students.remove(2);
        System.out.println(students);

        System.out.println("\nRemove a value from list, but also use it!");
        String tempStudent = students.remove(1);
        System.out.println(students);
        System.out.println("We removed " + tempStudent);

        System.out.println("\nThe size of the list is: " + students.size());

        /*
        Lists are a part of Collections
        In Programming in general - there are 5 types of collections

        - Basic Array
        - Lists                                         -- PRIORITY LIST (C# box of items)
        - Queue (first in - first out  (FIFO) lilo)     -- LINE UP
        - Stack (Last in - first out (LIFO) )           -- STACK OF BOOKS
        - Ordered List                                  -- PRIORITY LIST (C# Only)
         */

        // Clear a list
        System.out.println("\nClear a list!");
        students.clear();
        System.out.println(students);

        // Add a list to another list
        students.add("John");
        students.add("Bob");
        students.add("Sally");

        ArrayList<String> students2 = new ArrayList<String>();
        students2.add("Jennifer");
        students2.add("Raj");
        students2.add("Minnie");

        System.out.println(students);
        System.out.println(students2);
        students.addAll(students2);
        System.out.println(students);
        System.out.println(students2);

        // Cloning
        ArrayList<String> students3 = new ArrayList<String>();
        students3 = (ArrayList<String>)students.clone();
        System.out.println(students3);






//        System.out.println("\nAdded 3 students to the array list!");
//        System.out.println("\nAdded 3 students to the array list!");
        Tools.pauseProgram();
    }
    //</editor-fold>

    //<editor-fold desc="Demo 2 - Basic OOP Concepts">
     private static void demo2(){}
    //</editor-fold>

    //<editor-fold desc="Demo 3 - Object Classes">
     private static void demo3(){}
    //</editor-fold>

}