package lab6;

public class Product implements Comparable<Product> {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return price * quantity;
    }

    public void addQuantity(int amount) {
        this.quantity += amount;
    }

    @Override
    public int compareTo(Product other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return String.format("Товар: %s, Цена за единицу: %.2f, Количество: %d, Общая стоимость: %.2f",
                name, price, quantity, getTotalPrice());
    }
}
