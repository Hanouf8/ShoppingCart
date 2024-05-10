public class DiscountedShoppingCartDecorator implements ItemFactory {
    private ItemFactory itemFactory; // Reference to the original ItemFactory
    private double discountRate; // Discount rate

    public DiscountedShoppingCartDecorator(ItemFactory itemFactory, double discountRate) {
        this.itemFactory = itemFactory;
        this.discountRate = discountRate;
    }

    @Override
    public Item createItem(String name, double price) {
        return itemFactory.createItem(name, price); // Delegate the item creation to the original ItemFactory
    }

    @Override
    public double calculateTotalPrice() {
        double totalPrice = itemFactory.calculateTotalPrice();
        return totalPrice * (1 - discountRate); // Apply the discount
    }

    @Override
    public void pay(String paymentMethod) {
        itemFactory.pay(paymentMethod); // Delegate the payment operation to the original ItemFactory
    }

    @Override
    public int calculateFactorial(int number) {
        return itemFactory.calculateFactorial(number); // Delegate the factorial calculation to the original ItemFactory
    }
}
