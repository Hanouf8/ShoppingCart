public abstract class ShoppingCartDecorator implements ShoppingCart {
    protected ShoppingCart decoratedShoppingCart;

    public ShoppingCartDecorator(ShoppingCart decoratedShoppingCart) {
        this.decoratedShoppingCart = decoratedShoppingCart;
    }

    @Override
    public Item createItem(String name, double price) {
        return decoratedShoppingCart.createItem(name, price);
    }

    @Override
    public abstract double calculateTotalPrice();

    @Override
    public void pay(String paymentMethod) {
        decoratedShoppingCart.pay(paymentMethod);
    }

    @Override
    public int calculateFactorial(int number) {
        return decoratedShoppingCart.calculateFactorial(number);
    }
}