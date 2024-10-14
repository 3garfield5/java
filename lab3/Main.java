package lab3;

import java.util.Hashtable;

public class Main {
    public static void main(String[] args) {

        HashTable<Integer, String> table = new HashTable<>();

//        System.out.println(table.isEmpty());

        table.put(1, "Жим от груди");
//        System.out.println(table.get(1));
        System.out.println("вывыы"+table.getIndex(1));
        table.put(6, "Бицепс");
        System.out.println("вывыы"+table.getIndex(6));
//        System.out.println(table.get(1));
        table.put(3, "Трицепс");
        table.put(4, "Присед");
        table.put(7, "Присед + ");


        System.out.println(table.getDataAtIndex(1));
        System.out.println(table.getDataAtIndex(2));
        System.out.println(table.getDataAtIndex(3));
        System.out.println(table.getDataAtIndex(4));
        System.out.println(table.getDataAtIndex(5));

//        System.out.println(table.getIndex(8));



        Hashtable<Integer, Book> hashTable = new Hashtable<>();

        hashTable.put(273842395, new Book("Мастер и Марграрита", "Булгаков", 10));
        hashTable.put(782394034, new Book("Мертвые души", "Гоголь", 1));
        hashTable.put(912738475, new Book("Отцы и дети", "Тургенев", 100));

        System.out.println(hashTable.containsKey(273842395));

        hashTable.remove(912738475);

        System.out.println(hashTable.get(273842395).getName());

    }
}
