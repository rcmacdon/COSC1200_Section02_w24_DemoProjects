/* ************************************
File:   Service Class Definition
Author: Clint MacDonald
Date:   Feb. 2024
 */
import java.util.ArrayList;

public class Service {

    //<editor-fold desc="Class Global Variables">
    public static ArrayList<Service> services;
    //</editor-fold>

    //<editor-fold desc="Properties">
    private String serviceCode;
    private String serviceName;
    private String description;
    private double basePrice;
    private double timeRequired;
    private boolean isActive;
    //</editor-fold>

    //<editor-fold desc="Constructors">
    public Service() {
        setDefaults();
    }

    public Service(String serviceCode, String serviceName, String description, double basePrice, double timeRequired, boolean isActive) {
        setServiceCode(serviceCode);
        setServiceName(serviceName);
        setDescription(description);
        setBasePrice(basePrice);
        setTimeRequired(timeRequired);
        setActive(isActive);
    }

    public Service(String serviceCode, String serviceName) {
        setDefaults();
        setServiceCode(serviceCode);
        setServiceName(serviceName);
    }
    //</editor-fold>

    //<editor-fold desc="Getters and Setters">
    public String getServiceCode() {
    return serviceCode;
}

    public void setServiceCode(String serviceCode) {
        if (serviceCode.length() == 4) {
            System.out.println("Must be 4 characters long.");
            if (isServiceCodeUnique(serviceCode)) {
                this.serviceCode = serviceCode;
            } else {
                System.out.println("Service Code is not unique!");
            }
        } else {
            System.out.println("Service code must be a 4-digit alphanumeric value!");
        }
    }

    public String getServiceName() {
        return serviceName;
    }
    
    public void setServiceName(String serviceName) {
        if (serviceName.length() > 50) {
            System.out.println("50 character max exceeded.");
        } else {
            this.serviceName = serviceName;
        }

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        if (basePrice < 0 || basePrice > 5000) {
            System.out.println("Price out of range 0-5000.");
        } else {
            this.basePrice = basePrice;
        }

    }

    public double getTimeRequired() {
        return timeRequired;
    }

    public void setTimeRequired(double timeRequired) {
        if (timeRequired < 0 || timeRequired > 100) {
            System.out.println("Time for service outside of range.");
        }
        this.timeRequired = timeRequired;
    }

    public boolean getIsActive() {
        return isActive;
    }


    public void setActive(boolean active) {
        isActive = active;
    }
//</editor-fold>

    //<editor-fold desc="Instance Methods">
    @Override
    public String toString() {
        return "Services{" +
                "serviceCode='" + this.serviceCode + '\'' +
                ", serviceName='" + this.serviceName + '\'' +
                ", description='" + this.description + '\'' +
                ", basePrice=" + this.basePrice +
                ", timeRequired=" + this.timeRequired +
                ", isActive=" + this.isActive +
                '}';
    }

    public void flipActive() {
        this.isActive = !this.isActive;
    }

    private void setDefaults() {
        this.serviceCode = "";
        this.serviceName = "Default Service";
        this.description = "";
        this.basePrice = 0.00;
        this.timeRequired = 0.00;
        this.isActive = false;
    }
    //</editor-fold>

    //<editor-fold desc="Static Methods">
    public static String toTable(ArrayList<Service> services) {
        StringBuilder table = new StringBuilder();
        table.append(String.format("| %-10s | %-50s | %-10s | %-10s | %-10s | %-10s |%n", "Code", "Name", "Price", "Time", "Active", "Description"));
        table.append("|------------|--------------------------------------------------|------------|------------|------------|------------|%n");
        for (Service service : services) {
            table.append(String.format("| %-10s | %-50s | %-10.2f | %-10.2f | %-10b | %-10s |%n",
                    service.getServiceCode(), service.getServiceName(), service.getBasePrice(),
                    service.getTimeRequired(), service.getIsActive(), service.getDescription()));
        }
        return table.toString();
    }

    public static double getPrice(String serviceCode, ArrayList<Service> services) {
        for (Service service : services) {
            if (service.getServiceCode().equals(serviceCode)) {
                return service.getBasePrice();
            }
        }
        return 0.00;
    }

    public static Service findService(String serviceCode, ArrayList<Service> services) {
        for (Service service : services) {
            if (service.getServiceCode().equals(serviceCode)) {
                return service;
            }
        }

        //returns null when object related with the service code is not found.
        return null;
    }

    private static Boolean isServiceCodeUnique(String serviceCode) {
        for (Service service: services) {
            if (service.serviceCode.equalsIgnoreCase(serviceCode)) return false;
        }
        return true;
    }

    //</editor-fold>
}
