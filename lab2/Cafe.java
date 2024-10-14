package lab2;

import java.util.ArrayList;
import java.util.List;

public class Cafe extends Institution{
    private List<String> menu;
    private static int cafeCount = 0;

    public Cafe(String name, String address, List<String> menu) {
        super(name, address);
        this.menu = menu;
        cafeCount++;
    }

    public Cafe() {
        super();
        List<String> cafeMenu = new ArrayList<>();
        cafeMenu.add("Нету");
        this.menu = cafeMenu ;
        cafeCount++;
    }

    public List<String> getMenu() {
        return menu;
    }

    public void setMenu(List<String> menu) {
        this.menu = menu;
    }

    @Override
    public void describe() {
        System.out.println("Кафе '" + getName() + "' находится по адресу '" + getAddress() + "'. Меню: " + String.join(", ", menu));
    }

    public static int getCafeCount() {
        return cafeCount;
    }

    @Override
    public String toString() {
        return "Cafe{" +
                "menu=" + menu +
                "} " + super.toString();
    }
}
