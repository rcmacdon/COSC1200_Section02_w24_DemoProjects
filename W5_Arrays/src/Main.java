/* **************************************
Week 5 - Arrays Demonstration
Clint MacDonald
Feb 5, 2024
Review of Basic Arrays and arrays in Java
***************************************** */

import java.util.Arrays;

// Main collection class
public class Main {

    // main executable starting point
    public static void main(String[] args) {
        initializeApp();
        processMenu();
        closeApp();
    }

    //<editor-fold desc="initialization">
    private static void initializeApp(){
        System.out.println(
                """
                        *************************************
                          Welcome to Week 5 - Arrays\s
                        *************************************

                        """);
    }
    //</editor-fold>

    //<editor-fold desc="closing down">
    private static void closeApp(){
        System.out.println(
                """
                        *************************************
                          Good-bye\s
                        *************************************

                        """);
    }
    //</editor-fold>

    //<editor-fold desc="Main Menu">
    public static void processMenu() {
        int menuChoice = 0;

        do {
            System.out.println("""
                Main Menu
                ----------------------------------------------------------
                1. Demo 1 - Basic Array Declarations
                2. Demo 2 - Looping Through Arrays
                3. Demo 3 - 10x table demonstrating nested looping
                4. Demo 4 - 2D Arrays
                5. Demo 5 - Adding, removing, changing elements in arrays
                6. Demo 6 - Sorting and Searching Arrays
                ----------------------------------------------------------""");

            menuChoice = Tools.getIntFromConsole("Please enter your choice", 0, 6);

            switch (menuChoice) {
                case 1: demo1(); break;
                case 2: demo2(); break;
                case 3: demo3(); break;
                case 4: demo4(); break;
                case 5: demo5(); break;
                case 6: demo6(); break;
            }
            Tools.pauseProgram();
        } while (!(menuChoice == 0));

    }
    //</editor-fold>

    //<editor-fold desc="Demonstration 1 - Array Declarations">
    private static void demo1(){
        System.out.println("""
            
            Demo 1 - Array Declarations and Referencing them by Index number!
            ------------------------------------------------------------------
            """);

        int[] myInts = {1,2,3,4,5};
        String[] students = {"Bob", "John", "Raj", "Sally", "Jennifer", "Rutchie"};
        char[] myName = {67, 108, 105, 110, 116};

        // instantiating arrays - no huge difference for now, but will be later!
        int[] myInts2 = new int[] {3,4,5,6,7};
        int[] myInts3 = new int[5];
        // each element is initialized with null (noted acts like 0)

        int indexChoice = 2;
        System.out.printf("The value of the number at index %d is %d\n",
                indexChoice, myInts[indexChoice] );
        // %s for string
        // %d for signed integer
        // %f real number in standard notation

        indexChoice = 4;
        System.out.printf("The student name at index %d is %s\n",
                indexChoice, students[indexChoice] );

        System.out.print("\n");

        printIntArray(myInts);
        printStringArray(students);
        printCharArray(myName);
        printIntArray(myInts2);
        printIntArray(myInts3);
        System.out.printf("the product of the first element and 3 is: %d\n\n",
                3 * myInts3[0] );
        myInts3[0] = 5;
        System.out.printf("the product of the first element and 3 is: %d\n\n",
                3 * myInts3[0] );
    }

    private static void printIntArray(int[] input) {
        boolean first = true;
        for (int i : input ) {
            if (!first) System.out.print(" - ");
            first = false;
            System.out.print(String.valueOf(i));
        }
        System.out.print("\n");
    }

    private static void printStringArray(String[] input) {
        boolean first = true;
        for (String s : input ) {
            if (!first) System.out.print(" - ");
            first = false;
            System.out.print(s);
        }
        System.out.print("\n");
    }

    private static void printCharArray(char[] input) {
        boolean first = true;
        for (char i : input ) System.out.print(i);
        System.out.print("\n");
    }
    //</editor-fold>

    //<editor-fold desc="Demonstration 2 - Looping through Arrays">
    private static void demo2(){
        System.out.println("""
            
            Demo 1 - Iterating Through Arrays!
            ------------------------------------------------------------------
            """);

        // iterating through arrays
        String[] students = {"Bob", "John", "Raj", "Sally", "Jennifer", "Rutchie"};

        // basic for loop
        System.out.println("--------------\nBasic for-loop\n--------------");
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i]);
        }

        // foreach loop - best option
        System.out.println("--------------\nforeach-loop\n--------------");
        for (String student : students) {
            System.out.println(student);
        }

    }
    //</editor-fold>

    //<editor-fold desc="Demonstration 3 - Nested Looping - 10x table">
    private static void demo3(){
        System.out.println("""
            
        Demo 3 - Iterating Through Arrays!
        ------------------------------------------------------------------
        """);

        // let r represent rows, let c represent columns
        // let rh represent header row, let ch represent header column

        // print the header row
        System.out.print("    ");
        for (int rh = 0; rh <= 10; rh++) {
            System.out.printf(" %d   ",rh);
        }
        System.out.print("\n");

        int ch = 0;
        for (int r = 0; r <= 10; r++) { // one row at a time....

            // add the column header
            System.out.printf(" %d  ", ch);
            ch++;

            // add each column
            for (int c = 0; c <= 10; c++) {
                System.out.printf(" %d   ", r*c);
            }
            System.out.print("\n");
        }





    }
    //</editor-fold>

    //<editor-fold desc="Demonstration 4 - 2-Dimensional Arrays and Nested Looping">
    private static void demo4(){
        System.out.println("""
            
            Demonstration 4 - 2-Dimensional Arrays and Nested Looping
            ------------------------------------------------------------------
            """);

        // let a represent the assignment number
        // let s represent the student number
        // mark[a,s] would represent the mark obtain by student s on assignment a

        // so if there are 4 students and 3 assignments...
        int[][] marks = {   { 34, 78, 45, 76}, // assignment 1 (index 0) - 4 marks
                            { 89, 78, 56, 82}, // assignment 2 (index 1) - 4 marks
                            { 78, 93, 79, 86}  // assignment 3 (index 2) - 4 marks
                        };

        int a = 1; // assignment 2
        int s = 2; // student 3
        System.out.printf("Student %d received a grade of %d on assignment %d\n\n",
                s+1, marks[a][s], a+1 );
        // returns - Student 3 received a grade of 56 on assignment 2

        // Do this using a loop
        System.out.println("All student grades \n -----------------------");
        for (a = 0; a < 3; a++) {  // for each assignment
            for (s = 0; s < 4; s++) {  // each student
                System.out.printf("Student %d received a grade of %d on assignment %d\n",
                        s+1, marks[a][s], a+1 );
            }
        }


        // Example Golf Scores
        // index number of first dimension represents player number (group of 4 for instance) (indexes 0-3)
        // index number of second dimension represents hole number (9 hole golf course) (indexes 0-8)
        // the value stored represents the score achieved by that player on that hole!

        // enums are strongly typed methods to represent values by names
        enum players { JOHN, BOB, JENNIFER, BRENDA };
        // in this case john is enum 0, bob is enum 1, jennifer is enum 2, and brenda is enum 3

        int[][] golfScores = {
                { 3,2,4,3,5,3,4,2,3 },  // John's scores
                { 3,3,4,3,4,3,4,3,4 },  // Bob's scores
                { 4,5,3,4,4,4,4,4,5 },  // Jennifer's scores
                { 3,3,3,4,5,4,3,3,4 }   // Brenda's scores
        };

        int[] totals = new int[] {0,0,0,0};
        for (players player : players.values()) {
            for (int hole = 1; hole <= 9; hole++) {
                System.out.printf("%s scored a %d on hole %d\n",
                        player, golfScores[player.ordinal()][hole-1], hole);
                totals[player.ordinal()] += golfScores[player.ordinal()][hole-1];
            }
        }

        System.out.println();
        for (players player : players.values()) {
            System.out.printf("%s scored a total of %d\n", player, totals[player.ordinal()]);
        }
    }
    //</editor-fold>

    //<editor-fold desc="Demonstration 5 - Adding, removing, changing elements in arrays">
    private static void demo5(){
        String[] students = {"Bob", "John", "Raj", "Sally", "Jennifer", "Rutchie"};
        String[] students2 = students.clone();
        String[] students3 = new String[students2.length];
        students3 = students2;
        // does NOT copy array, students 3 simply refers to students 2,
        // if a change in students 3 occurs, students 2 is therefore changed as it is the SAME ARRAY.
        // use the clone() method to make a copy!

        printStringArray(students);
        printStringArray(students2);
        printStringArray(students3);
        students3[0] = "Bobby";
        System.out.println("\nChange Bob to Bobby in array 3!");
        printStringArray(students2);
        printStringArray(students3);
        // note that Bob became bobby is both students2 and students3 because they are the same array.
        students2[1] = "Johnny";
        System.out.println("\nChange John to Johnny in array 2!");
        printStringArray(students2);
        printStringArray(students3);
        // both changed because again they are the same array
        students[2] = "Rajesh";
        System.out.println("\nChange Raj to Rajesh in array 1!");
        printStringArray(students);
        printStringArray(students2);
        printStringArray(students3);
        // note only students changed as students2 was a clone of students

        // adding a new element
        // want to add a new student, Mike, to students
        // no way to resize arrays without re-instantiating them.
        System.out.println("\nAdd Mike to the original students array!");
        String[] newStudents = new String[students.length+1];
        System.arraycopy(students,0,newStudents,0,students.length);
        newStudents[students.length] = "Mike";
        //students = new String[newStudents.length];
        students = newStudents.clone();
        newStudents = null; // remove memory used for temp array
        printStringArray(students);

    }
    //</editor-fold>

    //<editor-fold desc="Demonstration 6 - Searching and Sorting Arrays>
    private static void demo6() {
        String[] students = {"Bob", "John", "Raj", "Sally", "Jennifer", "Rutchie"};

        // searching

        // does it contain?
        printStringArray(students);
        System.out.printf("John can be found at index %d\n",Arrays.binarySearch(students, "John"));
        printStringArray(students);
        System.out.printf("John can be found at index %d\n",Arrays.binarySearch(students, "John"));
        printStringArray(students);
        System.out.printf("Sally can be found at index %d\n",Arrays.binarySearch(students, "Sally"));
        printStringArray(students);
        System.out.printf("JENNIFER can be found at index %d\n",Arrays.binarySearch(students, "JENNIFER"));
        printStringArray(students);
        // ???

        String searchString = "JennIFER";
        int foundIndex = -1;
        for (int i = 0; i < students.length; i++) {
            if (students[i].equalsIgnoreCase(searchString)) {
                foundIndex = i;
                break;
            }
        }
        System.out.printf("The string %s was found at index %d\n", searchString, foundIndex);

        // Sorting
        printStringArray(students);
        Arrays.sort(students);
        printStringArray(students);
    }
    //</editor-fold>
}