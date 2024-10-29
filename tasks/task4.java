package tasks;

import java.util.*;

public class task4 {
    public static void main(String[] args) {
        System.out.println("1 задача");
        System.out.println(nonRepeat("abracadabra"));
        System.out.println(nonRepeat("abababcac"));

        System.out.println("2 задача");
        System.out.println(bruteForce(1,5));
        System.out.println(bruteForce(2,2));
        System.out.println(bruteForce(5,3));

        System.out.println("3 задача");
        System.out.println(encode(new int[] {0, 31, 28, 10, 29},"MKIIT"));
        System.out.println(decode("MTUCI","MKIIT"));

        System.out.println("4 задача");
        System.out.println(split("()()()"));
        System.out.println(split("((()))"));
        System.out.println(split("((()))(())()()(()())"));
        System.out.println(split("((())())(()(()()))"));

        System.out.println("5 задача");
        System.out.println(shortHand("abbccc"));
        System.out.println(shortHand("vvvvaajaaaaa"));

        System.out.println("6 задача");
        System.out.println(convertToRome(8));
        System.out.println(convertToRome(1234));
        System.out.println(convertToRome(52));

        System.out.println("7 задача");
        System.out.println(uniqueSubstring("31312131"));
        System.out.println(uniqueSubstring("1111111"));
        System.out.println(uniqueSubstring("12223234333"));

        System.out.println("8 задача");
        System.out.println(labirint(new int[][] {
                {1, 3, 1},
                {1, -1, 1},
                {4, 2, 1}
        }));
        System.out.println(labirint(new int[][] {
                {2, -7, 3},
                {-4, -1, 8},
                {4, 5, 9}
        }));

        System.out.println("9 задача");
        System.out.println(numericOrder("t3o the5m 1One all6 r4ule ri2ng"));
        System.out.println(numericOrder("re6sponsibility Wit1h gr5eat power3 4comes g2reat"));

        System.out.println("10 задача");
        System.out.println(fibString("CCCABDD"));
        System.out.println(fibString("ABC"));

    }

    private static String nonRepeat(String line) {
        Map<Character, Integer> charCount = new HashMap<>();

        for (char c : line.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        StringBuilder result = new StringBuilder();
        for (char c : line.toCharArray()) {
            if (charCount.get(c) <= 3) {
                result.append(c);
            }
        }

        if (result.length() == line.length()) {
            return result.toString();
        }

        return nonRepeat(result.toString());
    }

    public static List<String> bruteForce(int n, int k) {
        List<String> results = new ArrayList<>();

        if (n > k) {
            return results;
        }

        char[] alphabet = new char[k];
        for (int i = 0; i < k; i++) {
            alphabet[i] = (char) ('0' + i);
        }

        generateCombinations(alphabet, "", n, results);

        return results;
    }

    private static void generateCombinations(char[] alphabet, String current, int n, List<String> results) {

        if (current.length() == n) {
            results.add(current);
            return;
        }

        for (char c : alphabet) {
            if (current.indexOf(c) == -1) {
                generateCombinations(alphabet, current + c, n, results);
            }
        }
    }

    public static String encode(int[] numbers, String key) {
        if (numbers.length != key.length()) {
            throw new IllegalArgumentException("Длина массива чисел и длина ключа должны совпадать.");
        }

        StringBuilder encodedText = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            char encodedChar = (char) (numbers[i] ^ key.charAt(i));
            encodedText.append(encodedChar);
        }

        return encodedText.toString();
    }

    public static List<Integer> decode(String text, String key) {
        if (text.length() != key.length()) {
            throw new IllegalArgumentException("Длина текста и длина ключа должны совпадать.");
        }

        List<Integer> decodedNumbers = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            int decodedNumber = text.charAt(i) ^ key.charAt(i);
            decodedNumbers.add(decodedNumber);
        }

        return decodedNumbers;
    }

    public static List<String> split(String input) {
        List<String> clusters = new ArrayList<>();
        int balance = 0;
        StringBuilder cluster = new StringBuilder();

        for (char ch : input.toCharArray()) {
            cluster.append(ch);

            if (ch == '(') {
                balance++;
            } else if (ch == ')') {
                balance--;
            }

            if (balance == 0) {
                clusters.add(cluster.toString());
                cluster.setLength(0);
            }
        }
        return clusters;
    }

    public static String shortHand(String s) {
        StringBuilder result = new StringBuilder();
        int count = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                if (count > 1) {
                    result.append(s.charAt(i - 1)).append("*").append(count);
                } else {
                    result.append(s.charAt(i - 1));
                }
                count = 1;
            }
        }

        if (count > 1) {
            result.append(s.charAt(s.length() - 1)).append("*").append(count);
        } else {
            result.append(s.charAt(s.length() - 1));
        }

        return result.toString();
    }

    public static String convertToRome(int number) {
        if (number < 1 || number > 1502) {
            throw new IllegalArgumentException("Число должно быть от 1 до 1502");
        }

        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (number >= values[i]) {
                result.append(symbols[i]);
                number -= values[i];
            }
        }

        return result.toString();
    }

    public static String uniqueSubstring(String s) {

        Map<Character, Integer> counts = new HashMap<>();

        int maxCount = 0;
        int maxIndex = -1;

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            counts.put(currentChar, counts.getOrDefault(currentChar, 0) + 1);
            int currentCount = counts.get(currentChar);

            if (currentCount > maxCount || (currentCount == maxCount && maxIndex == -1)) {
                maxCount = currentCount;
                maxIndex = i;
            }
        }

        return maxIndex % 2 == 0 ? "чет" : "нечет";
    }

    public static List<String> labirint(int[][] grid) {
        int n = grid.length;

        if (grid[0][0] < 0 || grid[n-1][n-1] < 0) {
            return List.of("Прохода нет");
        }

        int[][] cost = new int[n][n];

        int[][] path = new int[n][n];

        cost[n-1][n-1] = grid[n-1][n-1];

        for (int i = n - 2; i >= 0; i--) {
            if (grid[n-1][i] >= 0 && cost[n-1][i+1] > 0) {
                cost[n-1][i] = cost[n-1][i+1] + grid[n-1][i];
                path[n-1][i] = 1;
            } else {
                cost[n-1][i] = -1;
            }

            if (grid[i][n-1] >= 0 && cost[i+1][n-1] > 0) {
                cost[i][n-1] = cost[i+1][n-1] + grid[i][n-1];
                path[i][n-1] = 2;
            } else {
                cost[i][n-1] = -1;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if (grid[i][j] >= 0) {
                    int costFromRight = cost[i][j+1] > 0 ? cost[i][j+1] + grid[i][j] : Integer.MAX_VALUE;
                    int costFromBottom = cost[i+1][j] > 0 ? cost[i+1][j] + grid[i][j] : Integer.MAX_VALUE;

                    if (costFromRight < costFromBottom) {
                        cost[i][j] = costFromRight;
                        path[i][j] = 1;
                    } else if (costFromBottom < costFromRight) {
                        cost[i][j] = costFromBottom;
                        path[i][j] = 2;
                    } else {
                        cost[i][j] = -1;
                    }
                }
            }
        }

        if (cost[0][0] == -1) {
            return List.of("Прохода нет");
        }

        List<String> resultPath = new ArrayList<>();
        int i = 0, j = 0;
        while (i != n - 1 || j != n - 1) {
            resultPath.add(String.valueOf(grid[i][j]));
            if (path[i][j] == 1) {
                j++;
            } else {
                i++;
            }
        }
        resultPath.add(String.valueOf(grid[n-1][n-1]));
        Collections.reverse(resultPath);
        return (List.of(String.join("-", resultPath), String.valueOf(cost[0][0])));
    }

    public static String numericOrder(String sentence) {
        String[] words = sentence.split(" ");

        Arrays.sort(words, (a, b) -> Integer.compare(extractNumber(a), extractNumber(b)));

        StringBuilder result = new StringBuilder();
        for (String word : words) {
            result.append(word.replaceAll("\\d", "")).append(" ");
        }

        return result.toString().trim();
    }

    private static int extractNumber(String word) {
        return Integer.parseInt(word.replaceAll("\\D", ""));
    }

    public static boolean fibString(String input) {

        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char ch : input.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        ArrayList<Integer> frequencies = new ArrayList<>(frequencyMap.values());
        Collections.sort(frequencies);

        ArrayList<Integer> fibonacci = new ArrayList<>();
        fibonacci.add(1);
        fibonacci.add(1);
        while (fibonacci.size() < frequencies.size()) {
            int size = fibonacci.size();
            fibonacci.add(fibonacci.get(size - 1) + fibonacci.get(size - 2));
        }

        return frequencies.equals(fibonacci.subList(0, frequencies.size()));
    }
}
