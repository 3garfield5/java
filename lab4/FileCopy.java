package lab4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) throws IOException {
        String firstFile = "lab4/first";
        String secondFile = "lab4/second";

        try (FileInputStream inputStream = new FileInputStream(firstFile); FileOutputStream outputStream = new FileOutputStream(secondFile)) {

            byte[] buffer = new byte[1024]; // Буфер для чтения данных
            int bytesRead; //  переменная bytesRead, которая будет хранить количество прочитанных байтов за одну итерацию цикла

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            } //   Если файл закончится, метод read() вернет -1, что означает конец файла.


            System.out.println("Копирование завершено успешно!");

        } catch (IOException e) {
            System.err.println("Ошибка при работе с файлами");
        }
    }
}