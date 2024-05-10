
public class ShoppingCartApp {

     public static void main(String[] args) {
    ItemFactory itemFactory = new SimpleItemFactory(); // Create an instance of the item factory

    // Create an instance of the ShoppingCartProxy as the base object
    ShoppingCartProxy shoppingCartProxy = new ShoppingCartProxy(itemFactory);

    // Create a decorated shopping cart with a discount
    ItemFactory decoratedCart = new DiscountedShoppingCartDecorator(shoppingCartProxy, 0.2); // 20% discount

    decoratedCart.createItem("Item 1", 10.0);
    decoratedCart.createItem("Item 2", 20.0);
    decoratedCart.pay("CreditCard");

    double totalPrice = decoratedCart.calculateTotalPrice();
    System.out.println("Total price after discount: $" + totalPrice);
}
