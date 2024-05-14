
package project;


public class ShoppingCartProxy implements ShoppingCart {
    private ItemFactory itemFactory; // Factory for creating items
    private ShoppingCart realShoppingCart; // Reference to the real ShoppingCart instance

    public ShoppingCartProxy(ItemFactory itemFactory) {
        this.itemFactory = itemFactory;
    }

    @Override
    public Item createItem(String name, double price) {
        loadShoppingCart();
        return realShoppingCart.createItem(name, price); // Forward the item creation to the real ShoppingCart
    }

    // Lazy loading of the real ShoppingCart instance
    private void loadShoppingCart() {
        if (realShoppingCart == null) {
            realShoppingCart = ShoppingCart.getInstance(itemFactory);
        }
    }

    // Additional functionalities that the proxy can provide
    public double calculateTotalPrice() {
        loadShoppingCart();
        return realShoppingCart.calculateTotalPrice();
    }

    public void pay(String paymentMethod) {
        loadShoppingCart();
        realShoppingCart.pay(paymentMethod);
    }

    public int calculateFactorial(int number) {
        loadShoppingCart();
        return realShoppingCart.calculateFactorial(number);
    }
}
