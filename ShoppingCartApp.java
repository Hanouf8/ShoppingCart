
public class ShoppingCartApp {

     public static void main(String[] args) {
     ItemFactory itemFactory = new SimpleItemFactory(); // Create an instance of the item factory

        // Get the singleton instance of the ShoppingCart
        ShoppingCart shoppingCart = ShoppingCart.getInstance(itemFactory);

        // Create a decorated shopping cart with a discount
        ItemFactory decoratedCart = new DiscountedShoppingCartDecorator(shoppingCart, 0.2); // 20% discount

        decoratedCart.createItem("Item 1", 10.0);
        decoratedCart.createItem("Item 2", 20.0);
        decoratedCart.pay("CreditCard");

        double totalPrice = decoratedCart.calculateTotalPrice();
        System.out.println("Total price after discount: $" + totalPrice);

        // Create a strategy instance
        Strategy strategy = new FreeShippingStrategy();

        // Create an observer instance
        Observer observer = new ShippingCostObserver(0.0);

        // Register the observer with the shopping cart
        decoratedCart.addObserver(observer);

        // Apply the strategy
        strategy.applyDiscount(decoratedCart);

        // Calculate the total price after applying the strategy
        totalPrice = decoratedCart.calculateTotalPrice();
        System.out.println("Total price after strategy: $" + totalPrice);
    }
}
