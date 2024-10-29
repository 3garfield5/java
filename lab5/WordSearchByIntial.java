package lab5;

import java.util.regex.*;
import java.util.Scanner;

public class WordSearchByIntial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите текст:");
        String text = scanner.nextLine();

        System.out.println("Введите букву для поиска слов:");
        String letter = scanner.nextLine();

        if (letter.length() != 1) {
            System.out.println("Ошибка: введите только одну букву.");
            return;
        }

        String regex = "\\b" + Pattern.quote(letter) + "\\w*";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        boolean found = false;

        while (matcher.find()) {
            System.out.println("Найдено слово: " + matcher.group());
            found = true;
        }

        if (!found) {
            System.out.println("Слова, начинающиеся с '" + letter + "', не найдены.");
        }

        scanner.close();
    }
}