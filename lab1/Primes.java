package lab1;
public class Primes {

    public static void main(String[] args) {
        for (int i = 2; i <= 100; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }

        }
    }
    public static boolean isPrime(int n) {
        for (int b = 2; b < n; b++) {
            if (n % b == 0) {
                return false;
            }

        }
        return true;
    }
}
