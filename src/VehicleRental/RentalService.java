package VehicleRental;

import java.util.ArrayList;
import java.util.List;

public class RentalService {
    List<Rental> rentals;
    List<Customer> customers;
    List<Vehicle> vehicles;

    public RentalService() {
        this.rentals = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.vehicles = new ArrayList<>();
    }

    public boolean addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
        return true;
    }

    public boolean addCustomer(Customer customer) {
        customers.add(customer);
        return true;
    }

    public boolean rentVehicle(int customerId, int vehicleId, int daysRented) {
        Customer customer = customers.stream()
                .filter(c -> c.getCustomerID() == customerId)
                .findFirst()
                .orElse(null);
        Vehicle vehicle = vehicles.stream()
                .filter(v -> v.getId() == vehicleId && !v.isRented())
                .findFirst()
                .orElse(null);

        if (customer == null || vehicle == null) {
            System.out.println("Error: Cliente o vehículo no encontrado/disponible.");
            return false;
        }

        if (vehicle.rent()) {
            int totalCost = daysRented * vehicle.getDailyRate();
            Rental rental = new Rental(rentals.size() + 1, customer, vehicle, daysRented, totalCost);
            rentals.add(rental);
            customer.getRentals().add(rental);
            return true;
        }

        return false;
    }

    public boolean returnVehicle(int rentalId) {
        Rental rental = rentals.stream()
                .filter(r -> r.getRentalId() == rentalId)
                .findFirst()
                .orElse(null);

        if (rental == null) {
            System.out.println("Error: Alquiler no encontrado.");
            return false;
        }

        rental.getVehicle().returnVehicle();

        return true;
    }

    public void showRentals() {
        rentals.forEach(System.out::println);
    }

    public void showVehicles() {
        vehicles.forEach(System.out::println);
    }

    public void showCustomers() {
        customers.forEach(System.out::println);
    }
}
