/* ************************************
File:   Service Class Definition
Author: Clint MacDonald
Date:   Feb. 2024
 */
import java.util.ArrayList;
import java.util.regex.*;

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

    public Service(String serviceCode, String serviceName, String description,
                   double basePrice, double timeRequired, boolean isActive)
                    throws ServiceConstructorException {
        try {
            setServiceCode(serviceCode);
        } catch (ServiceCodeException sce) {
            throw new ServiceConstructorException(sce.getMessage());
        }
        setServiceName(serviceName);
        setDescription(description);
        setBasePrice(basePrice);
        setTimeRequired(timeRequired);
        setActive(isActive);
    }

    public Service(String serviceCode, String serviceName) throws ServiceConstructorException {
        setDefaults();
        try {
            setServiceCode(serviceCode);
        } catch (ServiceCodeException sce) {
            throw new ServiceConstructorException(sce.getMessage());
        }

        setServiceName(serviceName);
    }
    //</editor-fold>

    //<editor-fold desc="Getters and Setters">
    public String getServiceCode() {
    return serviceCode;
}

    public void setServiceCode(String serviceCode) throws ServiceCodeException {

        // check the length of the string
        if (serviceCode.length() != AppSettings.Service.SERVICE_CODE_LENGTH) {
            throw new ServiceCodeException(
                    String.format("Service Code must be a %d long alphanumeric code!",
                            AppSettings.Service.SERVICE_CODE_LENGTH));
        }

        // check that the code fits the right pattern
        String requiredPattern = "^[A-Z]{2}\\d{2}$|^[A-Z]{3}\\d{1}$";
        // obtained this regex code using MS Copilot
        Pattern p = Pattern.compile(requiredPattern);

        if (!p.matcher(serviceCode).find()) {
            throw new ServiceCodeException(
                    "The service code must be in the format of AAA# or AA##");
        }

        // test for uniqueness
        if (!isServiceCodeUnique(serviceCode)) {
            throw new ServiceCodeException("Service Code is not unique!");
        }

        // passed all the tests
        this.serviceCode = serviceCode;
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
        this.serviceCode = AppSettings.Service.DEFAULT_SERVICE_CODE;
        this.serviceName = AppSettings.Service.DEFAULT_NAME;
        this.description = AppSettings.Service.DEFAULT_DESCRIPTION;
        this.basePrice = AppSettings.Service.DEFAULT_BASE_PRICE;
        this.timeRequired = AppSettings.Service.DEFAULT_TIME_REQUIRED;
        this.isActive = AppSettings.Service.DEFAULT_IS_ACTIVE;
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
