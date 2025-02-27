package VehicleRental;

public class Rental {
    int rentalId;
    Customer customer;
    Vehicle vehicle;
    int daysRented;
    int totalCost;

    public Rental(int rentalId, Customer customer, Vehicle vehicle, int daysRented, int totalCost) {
        this.rentalId = rentalId;
        this.customer = customer;
        this.vehicle = vehicle;
        this.daysRented = daysRented;
        this.totalCost = totalCost;
    }

    public int getRentalId() {
        return rentalId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    @Override
    public String toString() {
        return "Alquiler #" + rentalId + ": " + customer.customerName + " rentó " + vehicle.brand + " " + vehicle.model +
                " por " + daysRented + " días - Total: $" + totalCost;
    }
}
