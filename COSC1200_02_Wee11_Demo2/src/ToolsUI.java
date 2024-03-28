import java.util.Scanner;

public class ToolsUI {

    static Scanner sc = new Scanner (System.in);

    public static String getString(String prompt) {
        System.out.print(prompt);
        String input = sc.nextLine();
        return input;
    }

    public static int getInt(String prompt) {
        int inputNumber = -1;
        do {
            System.out.print(prompt);
            while (!sc.hasNextInt()) {
                System.out.println("That was not a number!");
                sc.next();
            }
            inputNumber = sc.nextInt();
        } while (inputNumber <= 0);

        return inputNumber;
    }

    public static int getInt(String prompt, int minValue, int maxValue) {
        int inputNumber = -1;
        do {
            System.out.print(prompt);
            while (!sc.hasNextInt()) {
                System.out.println("Please enter a number between " + minValue + " and " + maxValue);
                sc.next();
            }
            inputNumber = sc.nextInt();
        } while (!Tools.isIntWithinRange(inputNumber, minValue, maxValue));

        return inputNumber;
    }

    public static void outputMessage(String message) {
        System.out.println(message);
    }

}
