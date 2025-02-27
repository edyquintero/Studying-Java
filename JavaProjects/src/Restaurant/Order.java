package Restaurant;

import java.util.ArrayList;
import java.util.List;

public class Order {
    int orderID;
    String customerName;
    List<Dish> dishes = new ArrayList<Dish>();
    boolean delivered;

    public Order(int orderID, List<Dish> dishes, String customerName, boolean delivered) {
        this.orderID = orderID;
        this.dishes = dishes;
        this.customerName = customerName;
        this.delivered = delivered;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public boolean isDelivered() {
        return delivered;
    }

    public void markAsDelivered(boolean delivered) {
        this.delivered = delivered;
    }

    public int calculateTotal() {
        int total = 0;
        for (Dish dish : dishes) {
            total += dish.getPrice();
        }
        return total;
    }
}
