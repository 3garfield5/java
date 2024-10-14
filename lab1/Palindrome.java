package lab1;
public class Palindrome {

    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            String ww = args[i];
            System.out.println(isPalindrome(ww, reverseString(ww)));
        }

    }

    public static String reverseString(String ww) {
        String re = "";
        for (int b = 0; b < ww.length(); b++) {
            re = ww.charAt(b) + re;
        }
        return re;
    }

    public static boolean isPalindrome(String f, String s) {
        return f.equals(s);
    }
}
