/* **********************************
File:       COSC1200-02 Week 11 Demo 2
Author:     Clint MacDonald
Date:       March 2024
Purpose:    More examples on FileIO and learning basic wrapper Classes
************************************* */

public class Main {
    public static void main(String[] args) {

        AppSettings.Values.loadSettings();

        System.out.println("Min Value is " + AppSettings.Values.MIN_VALUE);
        System.out.println("Max Value is " + AppSettings.Values.MAX_VALUE);

        AppSettings.Values.MIN_VALUE = ToolsUI.getInt("Enter the min values", 0, 1000);
        AppSettings.Values.MAX_VALUE = ToolsUI.getInt("Enter the max values", 0, 1000);

        AppSettings.Values.saveSettings();


    }
}