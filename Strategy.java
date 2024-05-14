
import java.util.ArrayList;
import java.util.List;




public abstract class Strategy implements ShoppingCartInterface {
    protected ShoppingCartInterface shoppingCart;

    public Strategy(ShoppingCartInterface shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    @Override
    public void addItem(Item item) {
        shoppingCart.addItem(item);
    }

    @Override
    public void removeItem(Item item) {
        shoppingCart.removeItem(item);
    }

    @Override
    public double calculateTotalPrice() {
        return shoppingCart.calculateTotalPrice();
    }

    public abstract void applyDiscount();
}

public class FreeShippingStrategy extends Strategy {
    public FreeShippingStrategy(ShoppingCartInterface shoppingCart) {
        super(shoppingCart);
    }

    @Override
    public void applyDiscount() {
        double totalPrice = calculateTotalPrice();
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
