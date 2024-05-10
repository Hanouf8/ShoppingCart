/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


/**
 *
 * @author vip
 */
public class ShoppingCartApp {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) {
       ItemFactory itemFactory = new SimpleItemFactory(); // Create an instance of the item factory
        ShoppingCartProxy shoppingCartProxy = new ShoppingCartProxy(itemFactory); // Create an instance of the ShoppingCartProxy

        shoppingCartProxy.createItem("Item 1", 10.0); // Add items via the proxy
        shoppingCartProxy.createItem("Item 2", 20.0);
        shoppingCartProxy.pay("CreditCard"); // Pay with credit card

        shoppingCartProxy.createItem("Item 3", 15.0); // Add more items
        shoppingCartProxy.pay("PayPal"); // Pay with PayPal

        int number = 5;
        int factorial = shoppingCartProxy.calculateFactorial(number); // Calculate factorial via proxy
        System.out.println("Factorial of " + number + " is: " + factorial);
    }
}
