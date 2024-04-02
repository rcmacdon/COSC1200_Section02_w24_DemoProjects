/* **********************************
File:
Author:     Clint MacDonald
Date:
Purpose:
************************************* */
public class Tools {

    /**
     *
     * @param inputString
     * @return
     */
    public static boolean isStringDouble(String inputString) {
        boolean isValid = true;

        try {
            double test = Double.parseDouble(inputString);
        } catch (NumberFormatException nfe) {
            isValid = false;

        }

        return isValid;
    }

}
