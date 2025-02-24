package VehicleRental;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    int customerID;
    String customerName;
    List<Vehicle> rentedVehicles;
    List<Rental> rentals;

    public Customer(int customerID, String customerName) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.rentedVehicles = new ArrayList<>();
        this.rentals = new ArrayList<>();
    }

    public int getCustomerID() {
        return customerID;
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    @Override
    public String toString() {
        return customerID + " - " + customerName;
    }
}
