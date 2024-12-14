package tasks;

import java.math.BigInteger;
import java.net.*;
import java.util.*;

public class task6 {
    public static void main(String[] args) {
        System.out.println("--Задача 1--");
        System.out.println(hiddenAnagram("My world evolves in a beautiful space called Tesh.", "sworn love lived"));
        System.out.println(hiddenAnagram("An old west action hero actor", "Clint Eastwood"));
        System.out.println(hiddenAnagram("Mr. Mojo Rising could be a song title", "Jim Morrison"));
        System.out.println(hiddenAnagram("Banana? margaritas", "ANAGRAM"));
        System.out.println(hiddenAnagram("D  e b90it->?$ (c)a r...d,,#~", "bad credit"));
        System.out.println(hiddenAnagram("Bright is the moon", "Bongo mirth"));

        System.out.println("--Задача 2--");
        System.out.println(stripUrlParams("https://edabit.com?a=1&b=2&a=2", null));
        System.out.println(stripUrlParams("https://edabit.com?a=1&b=2&a=2", new String[] {"b"}));
        System.out.println(stripUrlParams("https://edabit.com", new String[] {"b"}));

        System.out.println("--Задача 3--");
        System.out.println(nicoCipher("myworldevolvesinhers", "tesh"));
        System.out.println(nicoCipher("andiloveherso", "tesha"));
        System.out.println(nicoCipher("mubashirhassan", "crazy"));
        System.out.println(nicoCipher("edabitisamazing", "matt"));
        System.out.println(nicoCipher("iloveher", "612345"));

        System.out.println("--Задача 4--");
        System.out.println(java.util.Arrays.toString(twoProduct(new int[]{1, 2, 3, 9, 4, 5, 15, 3}, 45)));
        System.out.println(java.util.Arrays.toString(twoProduct(new int[]{1, 2, 3, 9, 4, 15, 3, 5}, 45)));
        System.out.println(java.util.Arrays.toString(twoProduct(new int[]{1,  2, -1,  4,  5,  6,  10, 7}, 20)));
        System.out.println(java.util.Arrays.toString(twoProduct(new int[]{1, 2, 3, 4, 5,  6, 7, 8, 9, 10}, 10)));
        System.out.println(java.util.Arrays.toString(twoProduct(new int[]{100, 12, 4, 1, 2}, 15)));

        System.out.println("--Задача 5--");
        System.out.println(Arrays.toString(isExact(6)));
        System.out.println(Arrays.toString(isExact(24)));
        System.out.println(Arrays.toString(isExact(125)));
        System.out.println(Arrays.toString(isExact(720)));
        System.out.println(Arrays.toString(isExact(1024)));
        System.out.println(Arrays.toString(isExact(40320)));

        System.out.println("--Задача 6--");
        System.out.println(fractions("0.(6)"));
        System.out.println(fractions("1.(1)"));
        System.out.println(fractions("3.(142857)"));
        System.out.println(fractions("0.19(2367)"));
        System.out.println(fractions("0.1097(3)"));

        System.out.println("--Задача 7--");
        System.out.println(pilishString("33314444"));
        System.out.println(pilishString("TOP"));
        System.out.println(pilishString("X"));
        System.out.println(pilishString(""));

        System.out.println("--Задача 8--");
        System.out.println(formula("6 * 4 = 24"));
        System.out.println(formula("18 / 17 = 2"));
        System.out.println(formula("16 * 10 = 160 = 14 + 120"));

        System.out.println("--Задача 9--");
        System.out.println(isValid("aabbcd"));
        System.out.println(isValid("aabbccddeefghi"));
        System.out.println(isValid("abcdefghhgfedecba"));

        System.out.println("--Задача 10--");
        System.out.println(palindromeDescendant(11211230));
        System.out.println(palindromeDescendant(13001120));
        System.out.println(palindromeDescendant(23336014));
        System.out.println(palindromeDescendant(11));
    }

    public static String hiddenAnagram(String sentence, String phrase) {
        String cleanSentence = sentence.replaceAll("[^a-zA-Z]", "").toLowerCase();
        String cleanPhrase = phrase.replaceAll("[^a-zA-Z]", "").toLowerCase();

        Map<Character, Integer> targetCounter = getCharFrequency(cleanPhrase);
        int phraseLength = cleanPhrase.length();

        for (int i = 0; i <= cleanSentence.length() - phraseLength; i++) {
            String substring = cleanSentence.substring(i, i + phraseLength);

            if (getCharFrequency(substring).equals(targetCounter)) {
                return substring;
            }
        }

        return "noutfond";
    }

    private static Map<Character, Integer> getCharFrequency(String str) {
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : str.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        return frequencyMap;
    }

    public static String stripUrlParams(String url, String[] excludeParams) {
        try {
            URL parsedUrl = new URL(url);
            String query = parsedUrl.getQuery();
            if (query == null) return url;

            String[] pairs = query.split("&");
            LinkedHashMap<String, String> params = new LinkedHashMap<>();

            Set<String> excludeSet = excludeParams != null ? new HashSet<>(Arrays.asList(excludeParams)) : Collections.emptySet();

            for (String pair : pairs) {
                String[] keyValue = pair.split("=");
                String key = keyValue[0];
                String value = keyValue.length > 1 ? keyValue[1] : "";
                if (!excludeSet.contains(key)) {
                    params.put(key, value);
                }
            }

            StringBuilder newQuery = new StringBuilder();
            for (Map.Entry<String, String> entry : params.entrySet()) {
                if (newQuery.length() > 0) {
                    newQuery.append("&");
                }
                newQuery.append(entry.getKey()).append("=").append(entry.getValue());
            }

            return new URL(parsedUrl.getProtocol(), parsedUrl.getHost(), parsedUrl.getPort(), parsedUrl.getPath() + (newQuery.length() > 0 ? "?" + newQuery : "")).toString();

        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Invalid URL: " + url, e);
        }
    }

    public static String nicoCipher(String message, String key) {
        int keyLength = key.length();
        List<Integer> keyOrder = getKeyOrder(key);

        List<String> rows = new ArrayList<>();
        for (int i = 0; i < message.length(); i += keyLength) {
            String chunk = message.substring(i, Math.min(i + keyLength, message.length()));
            rows.add(String.format("%-" + keyLength + "s", chunk)); // Дополнить пробелами
        }

        StringBuilder encodedMessage = new StringBuilder();
        for (String row : rows) {
            char[] transposedRow = new char[keyLength];
            for (int i = 0; i < keyLength; i++) {
                transposedRow[i] = row.charAt(keyOrder.get(i));
            }
            encodedMessage.append(new String(transposedRow));
        }

        return encodedMessage.toString();
    }

    private static List<Integer> getKeyOrder(String key) {
        List<Character> keyChars = new ArrayList<>();
        for (char c : key.toCharArray()) keyChars.add(c);

        List<Character> sortedKeyChars = new ArrayList<>(keyChars);
        Collections.sort(sortedKeyChars);

        List<Integer> keyOrder = new ArrayList<>();
        for (char c : sortedKeyChars) {
            keyOrder.add(keyChars.indexOf(c));
            keyChars.set(keyChars.indexOf(c), '\0');
        }
        return keyOrder;
    }

    public static int[] twoProduct(int[] arr, int n) {
        Map<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];

            if (n % current == 0) {
                int pair = n / current;

                if (seen.containsKey(pair)) {
                    return new int[]{pair, current};
                }
            }

            seen.put(current, i);
        }

        return new int[]{};
    }

    public static int[] isExact(int num) {
        return helper(num, 1, 1);
    }

    private static int[] helper(int num, int factorial, int n) {
        if (factorial == num) {
            return new int[]{num, n};
        } else if (factorial > num) {
            return new int[]{};
        }
        return helper(num, factorial * (n + 1), n + 1);
    }

    public static String fractions(String decimal) {
        String[] parts = decimal.split("\\(");
        String nonRepeating = parts[0];
        String repeating = parts.length > 1 ? parts[1].replace(")", "") : "";

        String[] nonRepeatingParts = nonRepeating.split("\\.");
        String integerPart = nonRepeatingParts[0];
        String fractionalPart = nonRepeatingParts.length > 1 ? nonRepeatingParts[1] : "";

        String fullNonRepeating = fractionalPart;
        String fullRepeating = fractionalPart + repeating;

        int nonRepeatingLength = fractionalPart.length();
        int repeatingLength = repeating.length();

        BigInteger numeratorFull = new BigInteger(fullRepeating);
        BigInteger numeratorNonRepeating = new BigInteger(fractionalPart.isEmpty() ? "0" : fractionalPart);

        BigInteger denominatorFull = BigInteger.TEN.pow(nonRepeatingLength + repeatingLength).subtract(BigInteger.TEN.pow(nonRepeatingLength));
        BigInteger numerator = numeratorFull.subtract(numeratorNonRepeating);

        BigInteger integerValue = new BigInteger(integerPart);
        numerator = numerator.add(integerValue.multiply(denominatorFull));

        BigInteger gcd = numerator.gcd(denominatorFull);
        numerator = numerator.divide(gcd);
        denominatorFull = denominatorFull.divide(gcd);

        return numerator + "/" + denominatorFull;
    }

    private static final int[] PI_DIGITS = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5, 8, 9, 7, 9};

    public static String pilishString(String txt) {
        if (txt.isEmpty()) {
            return "";
        }

        List<String> resultWords = new ArrayList<>();
        int index = 0;

        for (int length : PI_DIGITS) {
            if (index >= txt.length()) {
                break;
            }

            StringBuilder word = new StringBuilder();
            for (int i = 0; i < length; i++) {
                if (index < txt.length()) {
                    word.append(txt.charAt(index++));
                } else {
                    word.append(word.charAt(word.length() - 1));
                }
            }
            resultWords.add(word.toString());
        }

        return String.join(" ", resultWords);
    }

    public static String isValid(String str) {
        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (char c : str.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        Map<Integer, Integer> frequencyCounts = new HashMap<>();

        for (int frequency : frequencyMap.values()) {
            frequencyCounts.put(frequency, frequencyCounts.getOrDefault(frequency, 0) + 1);
        }

        if (frequencyCounts.size() == 1) {
            return "YES";
        }

        if (frequencyCounts.size() == 2) {
            int freq1 = (int) frequencyCounts.keySet().toArray()[0];
            int freq2 = (int) frequencyCounts.keySet().toArray()[1];
            int count1 = frequencyCounts.get(freq1);
            int count2 = frequencyCounts.get(freq2);

            if ((count1 == 1 && (freq1 - freq2 == 1 || freq1 == 1)) ||
                    (count2 == 1 && (freq2 - freq1 == 1 || freq2 == 1))) {
                return "YES";
            }
        }

        return "NO";
    }

    public static boolean isPalindrome(int number) {
        String str = String.valueOf(number);
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean palindromeDescendant(int number) {
        if (isPalindrome(number)) {
            return true;
        }

        while (String.valueOf(number).length() > 1) {
            number = generateDescendant(number);
            if (isPalindrome(number)) {
                return true;
            }
        }

        return false;
    }

    private static int generateDescendant(int number) {
        String str = String.valueOf(number);
        StringBuilder descendant = new StringBuilder();

        for (int i = 0; i < str.length(); i += 2) {
            int sum = Character.getNumericValue(str.charAt(i)) + Character.getNumericValue(str.charAt(i + 1));
            descendant.append(sum);
        }

        return Integer.parseInt(descendant.toString());
    }

    public static boolean formula(String input) {
        String[] parts = input.split("=");

        if (parts.length != 2) {
            return false;
        }

        String left = parts[0];
        String right = parts[1];
        String operator = "";
        double result = 0;

        for (int i = 0; i < left.length(); i++) {
            char currentChar = left.charAt(i);
            if (currentChar == '+' || currentChar == '-' || currentChar == '*' || currentChar == '/') {
                String leftPart = left.substring(0, i);
                String rightPart = left.substring(i + 1);
                operator = String.valueOf(currentChar);

                switch (operator) {
                    case "+":
                        result = Double.parseDouble(leftPart) + Double.parseDouble(rightPart);
                        break;
                    case "-":
                        result = Double.parseDouble(leftPart) - Double.parseDouble(rightPart);
                        break;
                    case "*":
                        result = Double.parseDouble(leftPart) * Double.parseDouble(rightPart);
                        break;
                    case "/":
                        result = Double.parseDouble(leftPart) / Double.parseDouble(rightPart);
                        break;
                    default:
                        break;
                }
                if (result == Double.parseDouble(right)) {
                    return true;
                }
            }
        }

        return false;

    }
}
