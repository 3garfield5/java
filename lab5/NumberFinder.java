package lab5;

import java.util.regex.*;

public class NumberFinder {
    public static void main(String[] args) {
        String text = "Черная футболка с надписью -99.99 стоит всего 5$";

        Pattern pattern = Pattern.compile("\\b\\d+(\\.\\d+)?\\b");

        Matcher matcher = pattern.matcher(text);

        try {
            boolean found = false;
            while (matcher.find()) {
                System.out.println("Найдено число: " + matcher.group());
                found = true;
            }
            if (!found) {
                System.out.println("Числа не найдены.");
            }
        } catch (PatternSyntaxException e) {
            System.err.println("Ошибка в регулярном выражении: " + e.getDescription());
        } catch (Exception e) {
            System.err.println("Произошла ошибка: " + e.getMessage());
        }
    }
}
