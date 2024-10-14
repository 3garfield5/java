package lab2;

import java.util.List;

public class Shop extends Institution {
    private List<String> products;

    public Shop(String name, String address, List<String> products) {
        super(name, address);
        this.products = products;
    }

    public List<String> getProducts(){
        return products;
    }

    public void setProducts(List<String> products) {
        this.products = products;
    }

    @Override
    public void describe() {
        System.out.println("Магазин '" + getName() + "' находится по адресу '" + getAddress() + "'. Продукты: " + String.join(", ", products));
    }

        @Override
        public String toString() {
            return "Shop{" +
                    "products=" + products +
                    "} " + super.toString();
        }
}
