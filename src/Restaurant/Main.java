package Restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Restaurant restaurant = new Restaurant();

        String menu = """
                ===== Restaurante =====
                1. Agregar plato al menú
                2. Mostrar menú
                3. Realizar un pedido
                4. Mostrar todas las órdenes
                5. Marcar pedido como entregado
                6. Mostrar órdenes pendientes
                7. Ver ingresos totales
                8. Salir
                """;

        while (true) {
            System.out.println(menu);
            System.out.print("Seleccione una opción: ");
            int opc = sc.nextInt();
            sc.nextLine();

            switch (opc) {
                case 1 -> {
                    System.out.print("Ingrese el nombre del plato: ");
                    String name = sc.nextLine();
                    System.out.print("Ingrese el precio del plato: ");
                    int price = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Ingrese la categoría del plato: ");
                    String category = sc.nextLine();

                    if (restaurant.addDishToMenu(new Dish(name, price, category))) {
                        System.out.println("Plato agregado con éxito.");
                    } else {
                        System.out.println("Error al agregar el plato.");
                    }
                }
                case 2 -> {
                    System.out.println("===== Menú =====");
                    if (restaurant.dishes.isEmpty()) {
                        System.out.println("No hay platos en el menú.");
                    } else {
                        restaurant.dishes.forEach(dish ->
                                System.out.println(dish.getName() + " - $" + dish.getPrice() + " (" + dish.getCategory() + ")"));
                    }
                }
                case 3 -> {
                    if (restaurant.dishes.isEmpty()) {
                        System.out.println("No hay platos en el menú para hacer un pedido.");
                        break;
                    }
                    System.out.print("Ingrese el nombre del cliente: ");
                    String customerName = sc.nextLine();
                    List<Dish> orderDishes = new ArrayList<>();

                    while (true) {
                        System.out.print("Ingrese el nombre del plato a agregar (o 'fin' para terminar): ");
                        String dishName = sc.nextLine();
                        if (dishName.equalsIgnoreCase("fin")) break;

                        Dish selectedDish = restaurant.dishes.stream()
                                .filter(d -> d.getName().equalsIgnoreCase(dishName))
                                .findFirst()
                                .orElse(null);

                        if (selectedDish != null) {
                            orderDishes.add(selectedDish);
                            System.out.println("Plato agregado al pedido.");
                        } else {
                            System.out.println("Plato no encontrado en el menú.");
                        }
                    }

                    if (!orderDishes.isEmpty()) {
                        Order newOrder = new Order(restaurant.orders.size() + 1, orderDishes, customerName, false);
                        restaurant.placeOrder(newOrder);
                        System.out.println("Pedido realizado con éxito.");
                    } else {
                        System.out.println("No se realizó ningún pedido.");
                    }
                }
                case 4 -> {
                    System.out.println("===== Órdenes =====");
                    if (restaurant.getAllOrders().isEmpty()) {
                        System.out.println("No hay órdenes registradas.");
                    } else {
                        restaurant.getAllOrders().forEach(order ->
                                System.out.println("Orden #" + order.getOrderID() + " - Cliente: " + order.getCustomerName() +
                                        " - Total: $" + order.calculateTotal() + " - Entregada: " + order.isDelivered()));
                    }
                }
                case 5 -> {
                    System.out.print("Ingrese el número de orden a marcar como entregada: ");
                    int orderID = sc.nextInt();
                    sc.nextLine();

                    Order order = restaurant.getAllOrders().stream()
                            .filter(o -> o.getOrderID() == orderID)
                            .findFirst()
                            .orElse(null);

                    if (order != null) {
                        order.markAsDelivered(true);
                        System.out.println("Orden marcada como entregada.");
                    } else {
                        System.out.println("No se encontró la orden.");
                    }
                }
                case 6 -> {
                    System.out.println("===== Órdenes pendientes =====");
                    List<Order> pendingOrders = restaurant.getPendingOrders();
                    if (pendingOrders.isEmpty()) {
                        System.out.println("No hay órdenes pendientes.");
                    } else {
                        pendingOrders.forEach(order ->
                                System.out.println("Orden #" + order.getOrderID() + " - Cliente: " + order.getCustomerName()));
                    }
                }
                case 7 -> {
                    System.out.println("Ingresos totales del restaurante: $" + restaurant.getTotalRevenue());
                }
                case 8 -> {
                    System.out.println("Saliendo...");
                    return;
                }
                default -> System.out.println("Opción no válida.");
            }
        }
    }
}
