/* **********************************
File:       Main Class for Application Settings
Author:     Clint MacDonald
Date:       March 2024
Purpose:    To store static versions of application settings
            we will load these from a file on a later date!
************************************* */
import java.time.LocalDate;

public class AppSettings {

    //<editor-fold desc="Application Attributes">
    public static final String APP_AUTHOR = "Clint MacDonald";
    public static final LocalDate APP_VERSION_DATE = LocalDate.of(2024, 3, 18);
    //</editor-fold>

    //<editor-fold desc="Runtime Settings and Configuration">

        //<editor-fold desc="Services Settings">
        public static class Service {
            public static final int SERVICE_CODE_LENGTH = 4;
            public static final double MIN_BASE_PRICE = 0f;
            public static final double MAX_BASE_PRICE = 5000f;

            public static final String DEFAULT_SERVICE_CODE = "";
            public static final String DEFAULT_NAME = "";
            public static final String DEFAULT_DESCRIPTION = "";
            public static final double DEFAULT_BASE_PRICE = 0f;
            public static final double DEFAULT_TIME_REQUIRED = 0f;
            public static final boolean DEFAULT_IS_ACTIVE = false;
        }
        //</editor-fold>

        //<editor-fold desc="Car Settings">
        public static class Car {}
        //</editor-fold>

        //<editor-fold desc="Maintenance Settings">
        public static class Maintenance {}
        //</editor-fold>

    //</editor-fold>

}
