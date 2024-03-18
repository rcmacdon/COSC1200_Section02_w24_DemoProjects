/* **********************************
File:       Service Code Exception Definition
Author:     Clint MacDonald
Date:       March 2024
Purpose:    Defining the custom exception to specifically handle incorrect
            Service Codes (values and formatting)
************************************* */

public class ServiceCodeException extends Exception {

    // exception error code
    private static final long serialVersionUID = 1L;

    public ServiceCodeException(String message) {
        super(message);
    }

}
