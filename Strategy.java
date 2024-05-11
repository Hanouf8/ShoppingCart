
package behavioral;
import java.util.ArrayList;
import java.util.List;



public interface Strategy {
    void applyDiscount(ShoppingCart shoppingCart);
}

public class FreeShippingStrategy implements Strategy {
    @Override
    public void applyDiscount(ShoppingCart shoppingCart) {
        double totalPrice = shoppingCart.calculateTotalPrice();
        System.out.println("Applying free shipping ...");
        if (totalPrice >= 50.0) {
            // Apply free shipping
            shoppingCart.addObserver(new ShippingCostObserver(0.0));
        } else {
            // Remove free shipping
            shoppingCart.removeObserver(new ShippingCostObserver(0.0));
        }
    }
}
