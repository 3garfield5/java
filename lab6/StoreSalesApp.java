package lab6;

public class StoreSalesApp {
    public static void main(String[] args) {
        SalesManager manager = new SalesManager();

        manager.addSale("Телефон", 500.0, 2);
        manager.addSale("Ноутбук", 1500.0, 1);
        manager.addSale("Телефон", 500.0, 1);
        manager.addSale("Телефон", 500.0, 1);
        manager.addSale("Часы", 200.0, 3);

        manager.showSales();

        System.out.printf("Общая сумма продаж: %.2f%n", manager.calculateTotalSales());
        System.out.printf("Наиболее популярный товар: %s%n", manager.getMostPopularProduct());
    }
}
