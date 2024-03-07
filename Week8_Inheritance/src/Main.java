/* **********************************
File:       COSC1200 - 02 - Week 8 Demo
Author:     Clint MacDonald
Date:       March 2024
Purpose:    To learn how the code the basics of inheritance
************************************* */

public class Main {
    public static void main(String[] args) {

        People person1 = new People();
        person1.setFirstName("Bob");
        System.out.println("Person: " + person1.getPeopleID() + " - " + person1.getFirstName());
        System.out.print(person1.toString());

        Faculty clint = new Faculty("Clint", "MacDonald", 5,16,1972, 9055551212f,
                "clint.macdonald@durhamcollege.ca", "my House",
                "SEIT", "Nazneen", 123456789, "BASc", 17);

        System.out.print(clint.toString());
    }


}

