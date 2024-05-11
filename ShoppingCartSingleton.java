public class ShoppingCartSingleton {
    private static ShoppingCart instance; // Singleton instance of the shopping cart

    private ShoppingCartSingleton() {
    }

    public static ShoppingCart getInstance(ItemFactory itemFactory) {
        if (instance == null) {
            synchronized (ShoppingCartSingleton.class) {
                if (instance == null) {
                    instance = new ShoppingCart(itemFactory); // Create a new instance if it doesn't exist
                }
            }
        }
        return instance; // Return the existing instance
    }
}
