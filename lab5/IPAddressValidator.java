package lab5;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class IPAddressValidator {

    public static boolean validateIPAddress(String ipAddress) {
//        Регулярное выражение для проверки IP-адреса:
//        25[0-5] — соответствует числам от 250 до 255.
//        2[0-4][0-9] — соответствует числам от 200 до 249.
//        1[0-9]{2} — соответствует числам от 100 до 199.
//        [1-9]?[0-9] — соответствует числам от 0 до 99.
//        ((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])\\.){3} — проверяет первые три числа с точками.
//        (25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])$ — проверяет последнее число без точки.
        String regex = "^((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])\\.){3}(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ipAddress);

        return matcher.matches();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите IP-адрес для проверки: ");

        try {
            String ipAddress = scanner.nextLine();
            if (validateIPAddress(ipAddress)) {
                System.out.println("IP-адрес корректен.");
            } else {
                System.out.println("Некорректный IP-адрес.");
            }
        } catch (Exception e) {
            System.out.println("Произошла ошибка при вводе IP-адреса: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

