/* **********************************
File:       Faculty Object Class Definition
Author:     Clint MacDonald
Date:       March 2024
Purpose:    To define the child class Faculty which inherits People
************************************* */


public class Faculty extends People {

    //<editor-fold desc="Global Vars and Constants">
    private final static String DEFAULT_FACULTY = "unknown";
    private final static String DEFAULT_SUPERVISOR = "tbd";
    private final static int DEFAULT_SIN = 0;
    private final static String DEFAULT_CREDENTIALS = "";
    private final static int DEFAULT_STEP_RATING = 6;
    //</editor-fold>

    //<editor-fold desc="Properties">
    private String faculty;
    private String supervisor;
    private int sin;
    private String credentials;
    private int stepRating;
    //</editor-fold>

    //<editor-fold desc="Getters (Accessors)">
    public String getFaculty() {
        return faculty;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public int getSin() {
        return sin;
    }

    public String getCredentials() {
        return credentials;
    }

    public int getStepRating() {
        return stepRating;
    }
//</editor-fold>

    //<editor-fold desc="Setters (Mutators)">

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public void setSin(int sin) {
        this.sin = sin;
    }

    public void setCredentials(String credentials) {
        this.credentials = credentials;
    }

    public void setStepRating(int stepRating) {
        this.stepRating = stepRating;
    }
//</editor-fold>

    //<editor-fold desc="Defaults">
    private void setDefaults() {
        setFaculty(DEFAULT_FACULTY);
        setSupervisor(DEFAULT_SUPERVISOR);
        setSin(DEFAULT_SIN);
        setCredentials(DEFAULT_CREDENTIALS);
        setStepRating(DEFAULT_STEP_RATING);
    }
    //</editor-fold>

    //<editor-fold desc="Constructors">
    // default constructor
    public Faculty() {
        super();
        setDefaults();
    }


    //parameterized Constructor
    public Faculty(String firstName, String lastName,
                   int dobMonth, int dobDay, int dobYear,
                   double phone, String email, String address,
                   String faculty, String supervisor, int sin,
                   String credentials, int stepRating){
        super(firstName, lastName, dobMonth, dobDay, dobYear, phone, email, address);
        setFaculty(faculty);
        setSupervisor(supervisor);
        setSin(sin);
        setCredentials(credentials);
        setStepRating(stepRating);
    }
    //</editor-fold>

    //<editor-fold desc="Instance Methods">
    @Override
    public String toString(){
        return String.format("""
            Person: %s %s, %s
            DOB (mm\\dd\\yy): %d\\%d\\%d
            Phone: %f
            Email: %s
            Faculty: %s
            Supervisor: %s
            """, getFirstName(), getLastName(), getCredentials(),
                getDobMonth(), getDobDay(), getDobYear(), getPhone(), getEmail(),
                getFaculty(), getSupervisor());
    }
    //</editor-fold>








}
