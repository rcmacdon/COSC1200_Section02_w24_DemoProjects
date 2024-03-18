/* **********************************
File:       Main Project Application File - ICE 3
Author:     Clint MacDonald
Date:       March 2024
Purpose:    To learn about custom exceptions and Application Settings
************************************* */

import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String[] serviceCodes = {"ABC", "123", "ABC12", "ABCD", "1234", "A123",
                "AB12", "ABC1", "AB02", "ABC1"};

        initializeApplication();

        // test the setter!

        Service service1 = new Service();
        for (String serviceCode : serviceCodes) {
            try {
                service1.setServiceCode(serviceCode);
                System.out.printf("\n%s - set successfully", serviceCode);
                Service.services.add(service1);
            } catch (ServiceCodeException sce) {
                System.out.printf("\n%s - There was an error with the service code - %s",
                        serviceCode, sce.getMessage());
            }
        }  // end of for each loop






        try {
            Service service2 = new Service("AA13", "name", "description", 19.99, 45f, true);
        } catch (ServiceConstructorException sce) {
            System.out.printf("An error occurred creating the service - %s", sce.getMessage());
        }


    }

    private static void initializeApplication() {
        // instantiate array lists
        Service.services = new ArrayList<Service>();

        // Output a header
        System.out.printf("""
                ---------------------------------------
                Program: Auto Service Application
                Author:  %s
                Date:    %s
                """, AppSettings.APP_AUTHOR, AppSettings.APP_VERSION_DATE.toString());

    }
}