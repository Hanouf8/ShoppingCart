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
        ShoppingCart shoppingCart = new ShoppingCart();
Item item1 = new Item("Item 1", 10.0);
Item item2 = new Item("Item 2", 20.0);
shoppingCart.addItem(item1);
shoppingCart.addItem(item2);
shoppingCart.pay("CreditCard");
}
}
    
    

