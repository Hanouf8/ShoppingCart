/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author vip
 */
public class SimpleItemFactory implements ItemFactory {
    @Override
    public Item createItem(String name, double price) {
        return new Item(name, price);
    }
}
