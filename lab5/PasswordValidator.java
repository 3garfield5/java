package lab5;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class PasswordValidator {

    public static boolean validatePassword(String password) {
        if (password.length() < 8 || password.length() > 16) {
            System.out.println("Пароль должен быть длиной от 8 до 16 символов.");
            return false;
        }

        String regex = "(?=.*[A-Z])(?=.*[0-9])[A-Za-z0-9]{8,16}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);

        if (!matcher.matches()) {
            System.out.println("Пароль должен содержать только латинские буквы и цифры, а также хотя бы одну заглавную букву и одну цифру.");
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите пароль для проверки: ");

        try {
            String password = scanner.nextLine();
            if (validatePassword(password)) {
                System.out.println("Пароль корректен.");
            } else {
                System.out.println("Пароль не соответствует требованиям.");
            }
        } catch (Exception e) {
            System.out.println("Произошла ошибка при вводе пароля: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

