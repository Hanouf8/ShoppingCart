
public class DiscountedShoppingCartDecorator extends ShoppingCartDecorator {
    private double discountRate;

    public DiscountedShoppingCartDecorator(ShoppingCart decoratedShoppingCart, double discountRate) {
        super(decoratedShoppingCart);
        this.discountRate = discountRate;
    }

    @Override
    public double calculateTotalPrice() {
        double totalPrice = decoratedShoppingCart.calculateTotalPrice();
        return totalPrice * (1 - discountRate); // Apply the discount
    }
}
