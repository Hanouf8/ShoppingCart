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
        ShoppingCart shoppingCart = ShoppingCart.getInstance(itemFactory); // Get the instance of the shopping cart

        shoppingCart.addItem("Item 1", 10.0); // Add items to the shopping cart
        shoppingCart.addItem("Item 2", 20.0);
        shoppingCart.pay("CreditCard"); // Pay with credit card
        
        ShoppingCart shoppingCart2 = ShoppingCart.getInstance(itemFactory); // Get the existing instance of the shopping cart
        shoppingCart2.addItem("Item 3", 15.0); // Add items to the shopping cart
        shoppingCart2.pay("PayPal"); // Pay with PayPal
        
        int number = 5;
        int factorial = shoppingCart.calculateFactorial(number); // Calculate the factorial of a number
        System.out.println("Factorial of " + number + " is: " + factorial);
    }
}
    
    

