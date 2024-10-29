package lab5;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindBigLetter {

    public static String CapitalAfterLowercase(String text) {
        String regex = "([a-z])([A-Z])";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        StringBuffer result = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(result, matcher.group(1) + "!" + matcher.group(2) + "!");
        }
        matcher.appendTail(result);

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите текст для обработки: ");
        String text = scanner.nextLine();

        String result = CapitalAfterLowercase(text);
        System.out.println("Результат: " + result);

        scanner.close();
    }
}

