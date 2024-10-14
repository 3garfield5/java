package lab2;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        List<String> cafeMenu = new ArrayList<>();
        cafeMenu.add("Кофе");
        cafeMenu.add("Круассан");
        cafeMenu.add("Хот-дог");

        List<String> shopProducts = new ArrayList<>();
        shopProducts.add("Мясо");
        shopProducts.add("Лук");
        shopProducts.add("Молоко");

        List<String> libBooks = new ArrayList<>();
        libBooks.add("Мастер и Маргарита");
        libBooks.add("Разумный инвестор");
        libBooks.add("Идиот");


        Cafe cafe1 = new Cafe();

        Cafe cafe3 = new Cafe("У дома", "Проспект Вернадского дом 14", cafeMenu);
        Cafe cafe2 = new Cafe("Не у дома", "Проспект Вернадского дом 15", cafeMenu);
        Shop shop = new Shop("Лента", "Улица Маршала Тухачевского дом 23", shopProducts);
        Lib lib = new Lib("Библиотека имени Ленина", "Улица Андреева дом 54", libBooks);

        cafe1.describe();
        cafe2.describe();
        cafe3.describe();
        shop.describe();
        lib.describe();

        System.out.println("Количество созданных кафе: " + Cafe.getCafeCount());
    }
}
