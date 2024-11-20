package tasks;

import java.util.HashMap;

public class task5 {
    public static void main(String[] args) {
        System.out.println("--Задача 1--");
        System.out.println(sameLetterPattern("ABAB", "CDCD"));
        System.out.println(sameLetterPattern("ABCBA", "BCDCB"));
        System.out.println(sameLetterPattern("FFGG", "CDCD"));
        System.out.println(sameLetterPattern("FFFF", "ABCD"));

        System.out.println("--Задача 2--");
        System.out.println(memeSum(26, 39));
        System.out.println(memeSum(122, 81));
        System.out.println(memeSum(1222, 30277));

        System.out.println("--Задача 3--");
        System.out.println(digitsCount(4666));
        System.out.println(digitsCount(544));
        System.out.println(digitsCount(121317));
        System.out.println(digitsCount(0));
        System.out.println(digitsCount(12345));
        System.out.println(digitsCount(1289396387328L));

        System.out.println("--Задача 5--");
        System.out.println(longestRun(new int[] {1, 2, 3, 10, 11, 15}));
        System.out.println(longestRun(new int[] {5, 4, 2, 1}));
        System.out.println(longestRun(new int[] {3, 5, 7, 10, 15}));

        System.out.println("--Задача 6--");
        System.out.println(takeDownAverge(new String[] {"95%", "83%", "90%", "87%", "88%", "93%"}));
        System.out.println(takeDownAverge(new String[] {"10%"}));
        System.out.println(takeDownAverge(new String[] {"53%", "79%"}));

        System.out.println("--Задача 7--");
        System.out.println(canMove("пешка", "D5", "C5")); // -> true
        System.out.println(canMove("конь", "D5", "C3")); // -> true
        System.out.println(canMove("слон", "D5", "G8")); // -> true
        System.out.println(canMove("ладья", "D5", "H7")); // -> false
        System.out.println(canMove("ферзь", "D5", "C8")); // -> false
        System.out.println(canMove("король", "D5", "E4")); // -> true
        System.out.println(canMove("ладья", "A8", "H8"));
        System.out.println(canMove("слон", "A7", "G1"));
        System.out.println(canMove("ферзь", "C4", "D6"));

    }

    public static boolean sameLetterPattern(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        return getPattern(str1).equals(getPattern(str2));
    }

    private static String getPattern(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder pattern = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            map.putIfAbsent(c, map.size());
            pattern.append(map.get(c));
        }
        return pattern.toString();
    }

    public static int memeSum(int a, int b) {
        String strA = Integer.toString(a);
        String strB = Integer.toString(b);

        int maxLen = Math.max(strA.length(), strB.length());
        strA = String.format("%" + maxLen + "s", strA).replace(' ', '0');
        strB = String.format("%" + maxLen + "s", strB).replace(' ', '0');

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < maxLen; i++) {
            int sumDigits = Character.getNumericValue(strA.charAt(i)) + Character.getNumericValue(strB.charAt(i));
            result.append(sumDigits);
        }

        return Integer.parseInt(result.toString());
    }

    public static int digitsCount(long x) {
        if (x / 10 == 0) {
            return 1;
        }
        return 1 + digitsCount(x/10);
    }

    public static int longestRun(int[] args){
        int  maxLenght = 1;
        int currentLenght = 1;

        for (int i = 1; i < args.length; i++) {

            if (Math.abs(args[i] - args[i - 1]) == 1) {
                currentLenght++;
            } else {
                maxLenght = Math.max(maxLenght, currentLenght);
                currentLenght = 1;
            }
        }
        return maxLenght;
    }

    public static int takeDownAverge(String[] args) {
        int sum = 0;
        int len_args = args.length;
        for (String arg : args) {
            int len_arg = arg.length();
            sum += Integer.parseInt(arg.substring(0,len_arg - 1));
        }
        double avg = (double) sum / len_args;

        int needAvg = (int) (avg - 5);

        return needAvg * (len_args + 1) - sum;
    }

    public static boolean canMove(String name, String start, String finish) {
        int startX = start.charAt(0) - 'A';
        int startY = start.charAt(1) - '1';
        int finishX = finish.charAt(0) - 'A';
        int finishY = finish.charAt(1) - '1';

        int dx = Math.abs(finishX - startX);
        int dy = Math.abs(finishY - startY);

        if (name.toLowerCase().equals("пешка")) {
            return ((dx == 0 && dy == 1) || (dx == 1 && dy == 0) );

        } else if (name.toLowerCase().equals("конь")) {
            return ((dx == 1 && dy == 2) || (dx == 2 && dy == 1));

        } else if (name.toLowerCase().equals("слон")) {
            return (dx == dy);

        } else if (name.toLowerCase().equals("ладья")) {
            return ((dx == 0 && (dy > 0 && dy <= 8)) || (dy == 0 && (dx > 0 && dx <= 8)));

        } else if (name.toLowerCase().equals("ферзь")) {
            return dx == dy || dx == 0 && dy <= 8 || dy == 0 && dx > 0 && dx <= 8;

        } else if (name.toLowerCase().equals("король")) {
            return (dx <= 1 && dy <= 1);

        } else {
            throw new IllegalArgumentException("Unknown chess piece: " + name);
        }

    }

//    public static String maxPossible(int first, int second) {
//        String firstStr = Integer.toString(first);
//        return firstStr;
//    }
}
