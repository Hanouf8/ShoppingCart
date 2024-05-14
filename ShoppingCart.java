import java.util.ArrayList;
import java.util.List;


// ShoppingCart interface
interface ShoppingCartInterface {
    void addItem(String name, double price);
    void removeItem(Item item);
    double calculateTotalPrice();
    void pay(String paymentMethod);
    int calculateFactorial(int number);
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
}

public class ShoppingCart implements ShoppingCartInterface {
    
    private ItemFactory itemFactory; // Factory for creating items
    private List<Item> items; // List of items in the shopping cart
    private double totalPrice; // Total price of the items
    private List<Observer> observers; // List of observers

    public ShoppingCart(ItemFactory itemFactory) {
        this.itemFactory = itemFactory;
        items = new ArrayList<>();
        totalPrice = 0.0;
        observers = new ArrayList<>();
    }

    @Override
    public void addItem(String name, double price) {
        Item item = itemFactory.createItem(name, price); // Create a new item using the factory
        items.add(item); // Add the item to the list
        totalPrice += item.getPrice(); // Update the total price
        notifyObservers(); // Notify observers about the item addition
    }

    @Override
    public void removeItem(Item item) {
        if (items.remove(item)) {
            totalPrice -= item.getPrice(); // Remove the item from the list and update the total price
            notifyObservers(); // Notify observers about the item removal
        }
    }

    @Override
    public double calculateTotalPrice() {
        return totalPrice; // Return the total price of the items
    }

    @Override
    public void pay(String paymentMethod) {
        if (paymentMethod.equals("CreditCard")) {
            System.out.println("Processing credit card payment: $" + calculateTotalPrice());
        } else if (paymentMethod.equals("PayPal")) {
            System.out.println("Processing PayPal payment: $" + calculateTotalPrice());
        } else {
            System.out.println("Invalid payment method");
        }
    }

    @Override
    public int calculateFactorial(int number) {
        if (number == 0) {
            return 1; // Base case: factorial of 0 is 1
        } else {
            return number * calculateFactorial(number - 1); // Recursive case: calculate factorial using recursion
        }
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer); // Add an observer to the list
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer); // Remove an observer from the list
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this); // Notify each observer about the state change
        }
    }
}
