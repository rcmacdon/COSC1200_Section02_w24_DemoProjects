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
     private static void demo2() {
        System.out.println("""
                *********************************
                4 Pillars of OOP
                *********************************
                1. Encapsulation
                2. Inheritance
                3. Abstraction
                4. Polymorphism

                """);
        Tools.pauseProgram();

        //<editor-fold desc="Encapsulation">
        System.out.println("""
                ENCAPSULATION
                -------------------------------------------------------------------------
                - the bundling of data with the methods that operate on that data
                - hides structure of data inside a class preventing un-authorized access
                     - usually done through accessors (private, protected, public)
                - The tools.java is one example
                    - compared to a ProjectileMotion class or a Darts class
                - usually a property of object classes... Week 7
                """);
        Tools.pauseProgram();
        //</editor-fold>

        //<editor-fold desc="Inheritance">
        System.out.println("""
                INHERITANCE
                --------------------------------------------------------------
                - object classes define an object and its properties/methods
                - inheritance is used when child objects share common properties/methods
                - similar to 1-1 relationships from databases
                EXAMPLE:
                cars, trucks, and motorcycles share many common properties
                - could create a common object type called "Vehicle"
                    - then sub types "car", "truck", and "motorcycle" that all inherit
                      common properties from vehicle and contain only those properties
                      specific to each sub-type.
                """);
        Tools.pauseProgram();
        //</editor-fold>

        //<editor-fold desc="Abstraction">
        System.out.println("""
                ABSTRACTION
                -------------------------------------------------------------------------
                - Hiding implementation details but exposes functionality
                - ideas not events
                    - only know "what it does" vs. "how it does"
                Example:
                A driver will focus on the car functionality (Start/Stop -> Accelerate/ Break),
                he/she does not bother about how the Accelerate/Brake mechanism works internally.
                """);

        Tools.pauseProgram();
        //</editor-fold>

        //<editor-fold desc="Polymorphism">
        System.out.println("""
                POLYMORPHISM
                -------------------------------------------------------------------------
                - Is the process of creating a generic version of an object, but when it is
                  accessed, the code determines exactly which form it takes.  Each instance
                  of the object can be very different, but are similar enough they can be
                  accessed through a common interface.
                  i.e. each individual object is an independent instance of a common object type
                """);
        Tools.pauseProgram();
        //</editor-fold>

     }
    //</editor-fold>

    //<editor-fold desc="Demo 3 - Object Classes">
     private static void demo3(){

        //String myName = new String("Clint");

        Car car1 = new Car();
        car1.setVin(0);
        car1.setYear(1999);
        car1.setMake("Honda");
        car1.setModel("Civic");
        car1.setTrim("DX");
        car1.setColor("Yellow");
        car1.setOwner("Sam");

        Car car2 = new Car(0, 2022, "Toyota", "Corolla", "DX", "Bronze", "Oshawa Toyota");

         ArrayList<Car> cars = new ArrayList<Car>();
         cars.add(car1);
         cars.add(car2);
         cars.add(new Car(0, 2015, "Subaru", "Forrester", "RS", "White", "Clint"));

         for (Car car : cars) car.printCar();

         System.out.println("Testing find car");

         Car carFind = new Car();
         carFind = Car.findCarByVIN(2, cars);
         carFind.printCar();

        Tools.pauseProgram();
     }
    //</editor-fold>

}