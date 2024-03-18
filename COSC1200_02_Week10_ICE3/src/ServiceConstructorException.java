/* **********************************
File:       Service Constructor Exception Definition
Author:     Clint MacDonald
Date:       March 2024
Purpose:    Defining a common constructor error to
            consolidate many different setter exceptions
************************************* */

public class ServiceConstructorException extends Exception {

    // exception code
    private static final long serialVersionUID = 2L;

    public ServiceConstructorException(String message) {
        super(message);
    }
}
