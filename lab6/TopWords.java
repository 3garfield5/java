package lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TopWords {
    public static void main(String[] args) {
        String filePath = "lab6/text.txt";
        File file = new File(filePath);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        HashMap<String, Integer> map = new HashMap<>();

        while (scanner.hasNext()) {
            String s = scanner.next();

            s = s.toLowerCase(); // все слова в нижний регистр, чтобы не было повторов типа "Я" и "я"
            s = s.replaceAll("\\p{Punct}", ""); // убирает знаки пунктцации

            if (s.isEmpty() || s.equals("—")) {
                continue;
            }

            if (map.containsKey(s)) {
                map.put(s,map.get(s) + 1);
            } else {
                map.put(s, 1);
            }

        }

        scanner.close();
        List<Map.Entry<String, Integer>> el = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());

        el.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o1.getValue().compareTo(o2.getValue()));
            }
        });

        for (int i = 1; i <= 10; i++) {
            System.out.println(i + ".Слово: " + el.get(el.size()-i).getKey() +
                    " - Количество повторений: " + el.get(el.size()-i).getValue());
        }
    }
}
