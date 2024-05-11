
package project;
import java.util.ArrayList;
import java.util.List;


public interface Observer {
    void update(ShoppingCart shoppingCart);
}

public class ShippingCostObserver implements Observer {
    private double shippingCost;

    public ShippingCostObserver(double shippingCost) {
        this.shippingCost = shippingCost;
    }

    @Override
    public void update(ShoppingCart shoppingCart) {
        double totalPrice = shoppingCart.calculateTotalPrice();
        System.out.println("Updating shipping cost...");
        if (totalPrice >= 100.0) {
            // Free shipping
            shippingCost = 0.0;
        } else {
            // Apply shipping cost
            shippingCost = 10.0;
        }
        System.out.println("New shipping cost: $" + shippingCost);
    }
}
