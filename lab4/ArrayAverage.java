package lab4;

public class ArrayAverage {
    public static void main(String[] args) {
        String[] arr = {"1", "2", "abc", "4", "5"};
        int sum = 0;
        try {
            for (String s : arr) {
                sum += Integer.parseInt(s);
            }
            double arMean = (double) sum / arr.length;
            System.out.println("Среднее арифметическое массива - " + arMean);
            System.out.println("Пятый элемент массива - " + arr[5]);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Выход за пределы массива");
        } catch (NumberFormatException e) {
            System.err.println("Неверные типы данных");
        }

    }
}