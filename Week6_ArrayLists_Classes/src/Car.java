/* *************************************
Car Class Definition
Clint MacDonald
Feb 15, 2024
***************************************** */

import java.util.ArrayList;

// car class
public class Car {

    private static int autoVin = 1;

    //<editor-fold desc="Properties">
    private int vin;
    private int year;
    private String make;
    private String model;
    private String trim;
    private String color;
    private String owner;
    //</editor-fold>

    //<editor-fold desc="Constructors">

    // default constructor
    public Car(){}

    // parameterized constructor
    public Car(int vin, int year, String make, String model,
                    String trim, String color, String owner){
        setVin(vin);
        setYear(year);
        setMake(make);
        setModel(model);
        setTrim(trim);
        setColor(color);
        setOwner(owner);
    }

    //</editor-fold>

    //<editor-fold desc="Getters and Setters">
    public int getVin() { return vin; }
    public int getYear() { return year; }
    public String getMake() { return make; }
    public String getModel() { return model; }
    public String getTrim() { return trim; }
    public String getColor() { return color; }
    public String getOwner() { return owner; }

    public void setVin (int vin){
        // validation
        if (vin == 0) {
            vin = autoVin++;
        }
        this.vin = vin;
    }
    public void setYear (int year){ this.year = year; }
    public void setMake (String make){ this.make = make; }
    public void setModel (String model){ this.model = model; }
    public void setTrim (String trim){ this.trim = trim; }
    public void setColor (String color){ this.color = color; }
    public void setOwner (String owner){ this.owner = owner; }


    //</editor-fold>

    //<editor-fold desc="Instance Methods">
    public void printCar() {
        System.out.println(String.format("""
                 -------------------------------
                 vin: %d - %s %d %s %s %s
                    owner: %s
                 -------------------------------
                 """, getVin(), getColor(), getYear(), getMake(), getModel(), getTrim(), getOwner()));
    }
    //</editor-fold>

    //<editor-fold desc="Static Methods">
    public static Car findCarByVIN(int vin, ArrayList<Car> cars) {
        Car retCar = new Car();
        for (Car car: cars) {
            if (car.getVin() == vin) retCar = car;
        }
        return retCar;
    }
    //</editor-fold>


}
