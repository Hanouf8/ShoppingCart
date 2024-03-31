/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author vip
 */
public class ShoppingCart {
    
private Item[] items;
private int itemCount;
private double totalPrice;



public ShoppingCart() {
    items = new Item[10];
    itemCount = 0;
    totalPrice = 0.0;
}

public void addItem(Item item) {
    items[itemCount] = item;
    itemCount++;
    totalPrice += item.getPrice();
}

public void removeItem(Item item) {
    for (int i = 0; i < itemCount; i++) {
        if (items[i].equals(item)) {
            totalPrice -= item.getPrice();
            items[i] = null;
            itemCount--;
            condenseItems();
            break;
        }
    }
}

private void condenseItems() {
    int j = 0;
    for (int i = 0; i < itemCount; i++) {
        if (items[i] != null) {
            items[j] = items[i];
            j++;
        }
    }
}

public double calculateTotalPrice() {
    return totalPrice;
}

public void pay(String paymentMethod) {
    if (paymentMethod.equals("CreditCard")) {
        // Process credit card payment
        System.out.println("Processing credit card payment: $" + calculateTotalPrice());
    } else if (paymentMethod.equals("PayPal")) {
        // Process PayPal payment
        System.out.println("Processing PayPal payment: $" + calculateTotalPrice());
    } else if (paymentMethod.equals("Bitcoin")) {
        // Process Bitcoin payment
        System.out.println("Processing Bitcoin payment: $" + calculateTotalPrice());
    } else {
        System.out.println("Invalid payment method");
    }
}
}