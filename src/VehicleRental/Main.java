package VehicleRental;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RentalService rentalService = new RentalService();

        while (true) {
            System.out.println("\n----- Menú de Alquiler de Vehículos -----");
            System.out.println("1. Agregar vehículo");
            System.out.println("2. Agregar cliente");
            System.out.println("3. Alquilar vehículo");
            System.out.println("4. Devolver vehículo");
            System.out.println("5. Ver alquileres");
            System.out.println("6. Ver vehículos");
            System.out.println("7. Ver clientes");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Marca: ");
                    String brand = scanner.nextLine();
                    System.out.print("Modelo: ");
                    String model = scanner.nextLine();
                    System.out.print("Tipo: ");
                    String type = scanner.nextLine();
                    System.out.print("Tarifa diaria: ");
                    int rate = scanner.nextInt();
                    rentalService.addVehicle(new Vehicle(rentalService.vehicles.size() + 1, brand, model, type, rate));
                    break;
                case 2:
                    System.out.print("Nombre del cliente: ");
                    String name = scanner.nextLine();
                    rentalService.addCustomer(new Customer(rentalService.customers.size() + 1, name));
                    break;
                case 3:
                    System.out.print("ID Cliente: ");
                    int customerId = scanner.nextInt();
                    System.out.print("ID Vehículo: ");
                    int vehicleId = scanner.nextInt();
                    System.out.print("Días de alquiler: ");
                    int days = scanner.nextInt();
                    rentalService.rentVehicle(customerId, vehicleId, days);
                    break;
                case 4:
                    System.out.print("ID Alquiler: ");
                    int rentalId = scanner.nextInt();
                    rentalService.returnVehicle(rentalId);
                    break;
                case 5:
                    rentalService.showRentals();
                    break;
                case 6:
                    rentalService.showVehicles();
                    break;
                case 7:
                    rentalService.showCustomers();
                    break;
                case 8:
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}
