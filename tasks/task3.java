package tasks;

import java.util.*;

public class task3 {
    public static void main(String[] args) {

        System.out.println("1 задача");
        System.out.println(isStrangePair("sparkling", "groups"));
        System.out.println(isStrangePair("bush", "hubris"));
        System.out.println(isStrangePair("", ""));

        System.out.println("2 задача");
        List<String[]> items = new ArrayList<>();
        items.add(new String[]{"Laptop", "124200"});
        items.add(new String[]{"Phone", "51450"});
        items.add(new String[]{"Headphones", "13800"});

        List<String[]> discountedItems = sale(items, 25);

        for (String[] item : discountedItems) {
            System.out.println(item[0] + ": " + item[1]);
        }

        System.out.println("3 задача");
        System.out.println(sucsessShoot(0, 0, 5, 2, 2));
        System.out.println(sucsessShoot(-2, -3, 4, 5, -6));

        System.out.println("4 задача");
        System.out.println(parityAnalysis(243));
        System.out.println(parityAnalysis(12));
        System.out.println(parityAnalysis(3));

        System.out.println("5 задача");
        System.out.println(rps("rock", "paper"));
        System.out.println(rps("paper", "rock"));
        System.out.println(rps("paper", "scissors"));
        System.out.println(rps("scissors", "scissors"));
        System.out.println(rps("scissors", "paper"));

        System.out.println("6 задача");
        System.out.println(bugger(39));
        System.out.println(bugger(999));
        System.out.println(bugger(4));

        System.out.println("7 задача");
        List<String[]> expensivItems = new ArrayList<>();
        expensivItems.add(new String[]{"Скакалка","550", "8"});
        expensivItems.add(new String[]{"Шлем", "3750", "4"});
        expensivItems.add(new String[]{"Мяч", "2900", "10"});

        System.out.println(mostExpensive(expensivItems));

        System.out.println("8 задача");
        System.out.println(longestUnique("abcba"));
        System.out.println(longestUnique("bbb"));

        System.out.println("9 задача");
        System.out.println(isPrefix("automation", "auto-"));
        System.out.println(isSuffix("arachnophobia", "-phobia"));
        System.out.println(isPrefix("retrospect", "sub-"));
        System.out.println(isSuffix("vocation", "-logy"));

        System.out.println("10 задача");
        System.out.println(doesBrickFit(1, 1, 1, 1, 1));
        System.out.println(doesBrickFit(1, 2, 1, 1, 1));
        System.out.println(doesBrickFit(1, 2, 2, 1, 1));

    }

    public static boolean isStrangePair(String first, String second){
        if (first.isEmpty() && second.isEmpty()){
            return true;
        }
        else return (first.charAt(0) == second.charAt(second.length() - 1)) && (second.charAt(0) == first.charAt(first.length() - 1));
    }

    public static List<String[]> sale(List<String[]> items, int discount) {
        List<String[]> discountedItems = new ArrayList<>();

        for (String[] item : items) {
            String name = item[0];
            int price = Integer.parseInt(item[1]);

            double discountedPrice = price * (1 - discount / 100.0);

            int finalPrice = (int) Math.round(discountedPrice);

            discountedItems.add(new String[]{name, String.valueOf(finalPrice)});
        }

        return discountedItems;
    }

    public static boolean sucsessShoot(int x, int y, int r, int m, int n) {
        double d = Math.sqrt(Math.pow((x - m), 2) + Math.pow((y - n), 2));
        return d < r;
    }

    public static boolean parityAnalysis(int x) {
        int sum = 0, num = x;

        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }

        return ((sum % 2) == (num % 2));
    }

    public static String rps(String player1, String player2) {
        player1 = player1.toLowerCase();
        player2 = player2.toLowerCase();

        if (player1.equals(player2)) {
            return "Tie";
        }

        if ((player1.equals("rock") && player2.equals("scissors")) ||
                (player1.equals("scissors") && player2.equals("paper")) ||
                (player1.equals("paper") && player2.equals("rock"))) {
            return "Player 1 wins";
        }

        return "Player 2 wins";
    }

    public static int bugger(int num) {
        int count = 0;

        while (num >= 10) {
            num = multiplyDigits(num);
            count++;
        }

        return count;
    }

    public static int multiplyDigits(int num) {
        int product = 1;

        while (num > 0) {
            product *= num % 10;
            num /= 10;
        }

        return product;
    }

    public static String mostExpensive(List<String[]> items) {
        int maxPrice = 0;
        String maxItem = "";

        for (String[] item : items) {
            String name = item[0];
            int price = Integer.parseInt(item[1]);
            int count = Integer.parseInt(item[2]);

            if (price * count > maxPrice) {
                maxItem = name;
                maxPrice = price * count;
            }
        }

        return "Наиб. общ. стоимость у предмета " + maxItem + " - " + maxPrice;

    }

    public static String longestUnique(String s) {
        HashSet<Character> uniqueChars = new HashSet<>();

        int start = 0;
        int maxLength = 0;
        int maxStart = 0;

        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);

            while (uniqueChars.contains(currentChar)) {
                uniqueChars.remove(s.charAt(start));
                start++;
            }

            uniqueChars.add(currentChar);

            if (end - start + 1 > maxLength) {
                maxLength = end - start + 1;
                maxStart = start;
            }
        }

        return s.substring(maxStart, maxStart + maxLength);
    }

    public static boolean isPrefix(String word, String prefix) {
        prefix = prefix.substring(0, prefix.length() - 1);
        return word.startsWith(prefix);
    }

    public static boolean isSuffix(String word, String suffix) {
        suffix = suffix.substring(1);
        return word.endsWith(suffix);
    }

    public static boolean doesBrickFit(int a, int b, int c, int w, int h) {
        return (a <= w && b <= h) || (a <= h && b <= w) ||
                (a <= w && c <= h) || (a <= h && c <= w) ||
                (b <= w && c <= h) || (b <= h && c <= w);
    }


}
