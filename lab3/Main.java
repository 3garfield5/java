package lab3;

import java.util.Hashtable;

public class Main {

    public static void main(String[] args) {
        // 1 задача
        HashTable<Integer, String> table = new HashTable<>();

        System.out.println("Проверим пустая ли таблица? - "+table.isEmpty());

        table.put(1, "Жим от груди");

        System.out.println("Ищем индекс, где лежит Жим от груди - "+table.getIndex(1));

        table.put(6, "Бицепс");

        System.out.println("Ищем индекс, где лежит Бицепс - "+table.getIndex(6));

        table.put(3, "Трицепс");
        table.put(4, "Присед");
        table.put(7, "Присед + ");

        System.out.println("Ищем индекс, где лежит Трицепс - " +table.getIndex(3));
        System.out.println("Возьмем данные с ключом 3 - "+table.get(3));
        System.out.println("Возьмем данные с ключом 1 - "+table.get(1));
        System.out.println("Возьмем данные с ключом 6 - "+table.get(6));

        table.remove(1);

        System.out.println("Проверим есть ли в таблице значения с ключом 1 - "+table.get(1));
        System.out.println("Рассмотрим размер таблицы - "+table.size());
        System.out.println("Проверим пустая ли таблица? - "+table.isEmpty());


        // 2 задача
        Hashtable<Integer, Book> hashTable = new Hashtable<>();

        hashTable.put(273842395, new Book("Мастер и Марграрита", "Булгаков", 10));
        hashTable.put(782394034, new Book("Мертвые души", "Гоголь", 1));
        hashTable.put(912738475, new Book("Отцы и дети", "Тургенев", 100));

        System.out.println("Проверим есть ли в таблице значение по ключу - "+hashTable.containsKey(273842395));

        hashTable.remove(912738475);

        System.out.println("Проверим есть ли в таблице значение по ключу - "+hashTable.containsKey(912738475));

        System.out.println("Название книги из строки с ключом 273842395 - "+hashTable.get(273842395).getName());

    }
}
