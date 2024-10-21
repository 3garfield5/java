package tasks;

import java.util.ArrayList;
import java.util.Arrays;

public class task2 {

    public static void main(String[] args) {

        System.out.println("1 задача");
        System.out.println(duplicateChars("Barack", "Obama"));

        System.out.println("2 задача");
        int[] num = {3, 12, 7, 81, 52};
        System.out.println(dividedByThree(num));

        System.out.println("3 задача");
        System.out.println(getInitials("simonov sergei evgenievich"));
        System.out.println(getInitials("kozhevnikova tatiana vitalevna"));

        System.out.println("4 задача");
        double[] array_1 = {3.5, 7.0, 1.5, 9.0, 5.5};
        System.out.println(normalizator(array_1));
        double[] array_2 = {10.0, 10.0, 10.0, 10.0};
        System.out.println(normalizator(array_2));

        System.out.println("5 задача");
        double[] array = {1.6, 0, 212.3, 34.8, 0, 27.5};
        System.out.println(Arrays.toString(compressedNums(array)));

        System.out.println("6 задача");
        System.out.println(camelToSnake("helloWorld"));

        System.out.println("7 задача");
        System.out.println(secondBiggest(new int[]  {3, 5, 8, 1, 2, 4}));

        System.out.println("8 задача");
        System.out.println(localReverse("baobab", 'b'));
        System.out.println(localReverse("Hello, I'm under the water, please help me", 'e'));

        System.out.println("9 задача");
        System.out.println(equal(8, 1, 8));
        System.out.println(equal(5,5,5));
        System.out.println(equal(4,9,6));

        System.out.println("10 задача");
        System.out.println(isAnagram("LISTEN", "silent"));
        System.out.println(isAnagram("Eleven plus two", "Twelve plus one"));
        System.out.println(isAnagram("hello", "world"));

    }

    public static String duplicateChars(String first, String second) {
        StringBuilder result = new StringBuilder();
        String first_lower = first.toLowerCase();
        String second_lower = second.toLowerCase();

        for (char c: first_lower.toCharArray()) {
            if (!second_lower.contains(String.valueOf(c))) {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static int dividedByThree(int[] array) {
        int count = 0;

        for (int i: array) {
            if (i % 2 != 0 && i % 3 == 0) {
                count++;
            }
        }
        return count;
    }

    public static String getInitials(String name){
        String[] parts = name.split("\\s+");
        StringBuilder result = new StringBuilder();
        String upFam = parts[0].substring(0,1);

        for (int i = 1; i < parts.length; i++) {
            result.append(parts[i].charAt(0)).append(".");
        }
        return result.toString().toUpperCase() + upFam.toUpperCase() + parts[0].replace(parts[0].substring(0,1), "");
    }

    public static double findMaxDouble(double[] array) {

        double max = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        return max;
    }

    public static double findMin(double[] array) {

        double min = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }

        return min;
    }

    public static ArrayList<Double> normalizator(double[] array) {
        double max = findMaxDouble(array);
        double min = findMin(array);
        ArrayList<Double> result = new ArrayList<>();

        for (double v : array) {
            double x = (v - min) / (max - min);

            if ((max - min) == 0) {
                result.add(0.0);
            } else {
                result.add(x);
            }
        }
        return result;
    }

    public static double[] compressedNums(double[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = Math.floor(array[i]);
            if (array[i] != 0) {
                count++;
            }
        }

        double[] result = new double[count];
        int j = 0;
        for (double val: array) {
            if (val != 0) {
                result[j++] = val;
            }
        }
        return Arrays.stream(result).sorted().toArray();
    }

    public static String camelToSnake(String camel) {
        String first = "";
        String second = "";
        boolean registre = true;

        while (registre) {
            for (int i = 0; i < camel.length(); i++) {
                char letter = camel.charAt(i);
                if (Character.isUpperCase(letter)) {
                    first = camel.substring(0, i);
                    second = camel.substring(i);
                    second = second.toLowerCase();
                    registre = false;
                }
            }
        }
        return first + "_" + second;
    }

    public static int secondBiggest(int[] array) {
        int secondNum = 0;
        int max = 0;

        for (int num: array) {
            if (num > max) {
                secondNum = max;
                max = num;
            }
            else if (num > secondNum && num != max){
                secondNum = num;
            }
        }
    return secondNum;
    }

    public static String localReverse(String str, char marker) {
        StringBuilder sb = new StringBuilder();
        int start = -1;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == marker) {
                if (start!= -1) {
                    String substring = str.substring(start + 1, i);
                    sb.append(new StringBuilder(substring).reverse());
                    sb.append(marker);
                    start = -1;
                } else {
                    sb.append(marker);
                    start = i;
                }
            } else if (start == -1) {
                sb.append(str.charAt(i));
            }
        }
        if (start!= -1) {
            sb.append(str.substring(start + 1));
        }

        return sb.toString();
    }

    public static int equal(int x, int y, int z) {
        int count = 0;
        if (x == y && y == z) {
            return 3;
        } else if (x == y || y == z || x == z) {
            return 2;
        } else {
            return count;
        }
    }

    public static boolean isAnagram(String first, String second) {
        if (first.length()!= second.length()) {
            return false;
        }

        char[] charArray1 = first.toLowerCase().toCharArray();
        char[] charArray2 = second.toLowerCase().toCharArray();

        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        return Arrays.equals(charArray1, charArray2);
    }
}