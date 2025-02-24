package VehicleRental;

public class Vehicle {
    int id;
    String brand;
    String model;
    String type;
    int dailyRate;
    boolean isRented;

    public Vehicle(int id, String brand, String model, String type, int dailyRate) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.type = type;
        this.dailyRate = dailyRate;
        this.isRented = false;
    }

    public int getId() {
        return id;
    }

    public int getDailyRate() {
        return dailyRate;
    }

    public boolean isRented() {
        return isRented;
    }

    public boolean rent() {
        if (isRented) return false;
        this.isRented = true;
        return true;
    }

    public boolean returnVehicle() {
        if (!isRented) return false;
        this.isRented = false;
        return true;
    }

    @Override
    public String toString() {
        return id + " - " + brand + " " + model + " (" + type + ") - $" + dailyRate + "/día - " + (isRented ? "Alquilado" : "Disponible");
    }
}
