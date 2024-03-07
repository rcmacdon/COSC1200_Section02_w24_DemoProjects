/* **********************************
File:       People Object Class Definition
Author:     Clint MacDonald
Date:       March 2024
Purpose:    Defining the Parent Class for People
************************************* */


public class People {

    //<editor-fold desc="Global Class Vars and Constants">
    // static variable to autonumber the peopleID
    private static int autoPeopleID = 0;

    // default values
    private final static String DEFAULT_STRING = "-";
    private final static int DEFAULT_INT = 0;
    private final static double DEFAULT_DBL = 0.0;
    //</editor-fold>

    //<editor-fold desc="Properties">
    private int peopleID;
    private String firstName;
    private String lastName;
    private int dobMonth;
    private int dobDay;
    private int dobYear;
    private double phone;
    private String email;
    private String address;
    //</editor-fold>

    //<editor-fold desc="Getters">
    public int getPeopleID() { return this.peopleID; }
    public String getFirstName() { return this.firstName; }
    public String getLastName() { return this.lastName; }
    public int getDobMonth() { return this.dobMonth; }
    public int getDobDay() { return this.dobDay; }
    public int getDobYear() { return this.dobYear; }
    public double getPhone() { return this.phone; }
    public String getEmail() { return this.email; }
    public String getAddress() { return this.address; }
    //</editor-fold>

    //<editor-fold desc="Setters">
    private void setPeopleID() {
        this.peopleID = autoPeopleID;
        autoPeopleID++;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setDobMonth(int dobMonth) {
        this.dobMonth = dobMonth;
    }
    public void setDobDay(int dobDay) {
        this.dobDay = dobDay;
    }
    public void setDobYear(int dobYear) {
        this.dobYear = dobYear;
    }
    public void setPhone(double phone) {
        this.phone = phone;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    //</editor-fold>

    //<editor-fold desc="Defaults">
    private void setDefaults(){
        setPeopleID();
        setFirstName(DEFAULT_STRING);
        setLastName(DEFAULT_STRING);
        setDobMonth(DEFAULT_INT);
        setDobDay(DEFAULT_INT);
        setDobYear(DEFAULT_INT);
        setPhone(DEFAULT_DBL);
        setEmail(DEFAULT_STRING);
        setAddress(DEFAULT_STRING);
    }
    //</editor-fold>

    //<editor-fold desc="Constructors">
    //default constructor
    public People() {
        this(DEFAULT_STRING, DEFAULT_STRING,
                DEFAULT_INT, DEFAULT_INT, DEFAULT_INT,
                DEFAULT_DBL, DEFAULT_STRING, DEFAULT_STRING);
    }

    // parameterized constructor
    public People(String firstName, String lastName,
                  int dobMonth, int dobDay, int dobYear,
                  double phone, String email, String address) {
        setPeopleID();
        setFirstName(firstName);
        setLastName(lastName);
        setDobMonth(dobMonth);
        setDobDay(dobDay);
        setDobYear(dobYear);
        setPhone(phone);
        setEmail(email);
        setAddress(address);
    }
    //</editor-fold>

    //<editor-fold desc="Instance Methods">
    @Override
    public String toString(){
        return String.format("""
            Person: %s %s
            DOB (mm\\dd\\yy): %d\\%d\\%d
            Phone: %f
            Email: %s
            """, getFirstName(), getLastName(),
                getDobMonth(), getDobDay(), getDobYear(), getPhone(), getEmail());
    }
    //</editor-fold>

    //<editor-fold desc="Static Methods">
    //</editor-fold>

}
