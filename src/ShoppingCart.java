/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author vip
 */
public class ShoppingCart {
    
private ItemFactory itemFactory; // Factory for creating items
    private List<Item> items; // List of items in the shopping cart
    private double totalPrice; // Total price of the items
    private static ShoppingCart instance; // Singleton instance of the shopping cart

    private ShoppingCart(ItemFactory itemFactory) {
        this.itemFactory = itemFactory;
        items = new ArrayList<>();
        totalPrice = 0.0;
    }

    public static ShoppingCart getInstance(ItemFactory itemFactory) {
        if (instance == null) {
            instance = new ShoppingCart(itemFactory); // Create a new instance if it doesn't exist
        }
        return instance; // Return the existing instance
    }

    public void addItem(String name, double price) {
        Item item = itemFactory.createItem(name, price); // Create a new item using the factory
        items.add(item); // Add the item to the list
        totalPrice += item.getPrice(); // Update the total price
    }

    public void removeItem(Item item) {
        if (items.remove(item)) {
            totalPrice -= item.getPrice(); // Remove the item from the list and update the total price
        }
    }

    public double calculateTotalPrice() {
        return totalPrice; // Return the total price of the items
    }

    public void pay(String paymentMethod) {
        if (paymentMethod.equals("CreditCard")) {
            System.out.println("Processing credit card payment: $" + calculateTotalPrice());
        } else if (paymentMethod.equals("PayPal")) {
            System.out.println("Processing PayPal payment: $" + calculateTotalPrice());
        } else {
            System.out.println("Invalid payment method");
        }
    }

    public int calculateFactorial(int number) {
        if (number == 0) {
            return 1; // Base case: factorial of 0 is 1
        } else {
            return number * calculateFactorial(number - 1); // Recursive case: calculate factorial using recursion
        }
    }}