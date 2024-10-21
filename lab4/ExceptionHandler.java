package lab4;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.FileWriter;
import java.io.IOException;

public class ExceptionHandler {

    // Метод для записи исключений в лог
    public static void logException(Exception e) {
        try (FileWriter writer = new FileWriter("lab4/exception_log.txt", true)) {
            writer.write("Exception: " + e.toString() + "\n");
        } catch (IOException ioException) {
            System.err.println("Ошибка при записи в файл лога: " + ioException.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Введите целое число: ");
            int number = scanner.nextInt();
            System.out.println("Вы ввели число: " + number);
        } catch (InputMismatchException e) {
            // Создаем и выбрасываем свое исключение
            CustomInputMismatchException customException = new CustomInputMismatchException("Введено не целое число!");
            System.err.println(customException.getMessage());
            logException(customException);
        }
    }
}
