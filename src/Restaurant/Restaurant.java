package Restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Restaurant {
    List<Dish> dishes = new ArrayList<Dish>();
    List<Order> orders = new ArrayList<Order>();

    public boolean addDishToMenu(Dish dish) {
        return dishes.add(dish);
    }

    public boolean placeOrder(Order order) {
        return orders.add(order);
    }

    public List<Order> getOrderByCustomer(String customer) {
        return orders.stream().filter(order -> order.getCustomerName().equals(customer)).collect(Collectors.toList());
    }

    public List<Order> getAllOrders() {
        return orders;
    }

    public List<Order> getPendingOrders() {
        return orders.stream().filter(order -> !(order.delivered)).collect(Collectors.toList());
    }

    public int getTotalRevenue() {
        int total = 0;
        List<Order> delivered = orders.stream().filter(order -> order.delivered).toList();

        for (Order order : delivered) {
            for (Dish dish : order.getDishes()) {
                total += dish.getPrice();
            }
        }

        return total;
    }

}
