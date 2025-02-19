package VehicleRental;

public class Vehicle {
    int id;
    String brand;
    String model;
    String type;
    int dailyRate;
    boolean isRented;

    public Vehicle(int id, String brand, String model, String type, int dailyRate, boolean isRented) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.type = type;
        this.dailyRate = dailyRate;
        this.isRented = isRented;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(int dailyRate) {
        this.dailyRate = dailyRate;
    }

    public boolean isRented() {
        return isRented;
    }

    public boolean rent() {
        if (isRented) {
            return false;
        } else {
            this.isRented = true;
            return true;
        }
    }

    public boolean returnVehicle() {
        if (isRented) {
            this.isRented = false;
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return brand + " " + model + " " + type + " " + dailyRate + " " + isRented;
    }
}
