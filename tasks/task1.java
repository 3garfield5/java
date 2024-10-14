package tasks;

public class task1 {
    
    public static void main(String[] args) {

        System.out.println("1 задача");
        System.out.println(convert(5));
        System.out.println(convert(3));
        System.out.println(convert(8));

        System.out.println("2 задача");
        System.out.println(fitCalc(15, 1));
        System.out.println(fitCalc(24, 2));
        System.out.println(fitCalc(41, 3));

        System.out.println("3 задача");
        System.out.println(containers(3, 4, 2));
        System.out.println(containers(5, 0, 2));
        System.out.println(containers(4, 1, 4));

        System.out.println("4 задача");
        System.out.println(triangleType(5,5,5));
        System.out.println(triangleType(5, 4, 5));
        System.out.println(triangleType(3,4,5));
        System.out.println(triangleType(5,1,1));

        System.out.println("5 задача");
        System.out.println(ternaryEvaluation(8,4));
        System.out.println(ternaryEvaluation(1,11));
        System.out.println(ternaryEvaluation(5,9));

        System.out.println("6 задача");
        System.out.println(howManyItems(22, 1.4, 2));
        System.out.println(howManyItems(45, 1.8, 1.9));
        System.out.println(howManyItems(100,2, 2));

        System.out.println("7 задача");
        System.out.println(factorial(3));
        System.out.println(factorial(5));
        System.out.println(factorial(7));

        System.out.println("8 задача");
        System.out.println(gcd(48,18));
        System.out.println(gcd(52,8));
        System.out.println(gcd(259, 28));

        System.out.println("9 задача");
        System.out.println(ticketSaler(70, 1500));
        System.out.println(ticketSaler(24, 950));
        System.out.println(ticketSaler(53, 1250));

        System.out.println("10 задача");
        System.out.println(tables(5, 2));
        System.out.println(tables(31, 20));
        System.out.println(tables(123, 58));
    }

    public static double convert(int x) {
        return (x * 3.785);
    }

    public static int fitCalc(int x, int y) {
        return (x * y);
    }

    public static int containers(int x, int y, int z) {
        return (x * 20 + y * 50 + z * 100);
    }

    public static String triangleType(int x, int y, int z) {

        if (x + y <= z || x + z <= y || y + z <= x) {
            return "not a triangle";
        }

        else if (x == y && y == z) {
            return "isosceles";
        }
        
        else if (x == y || x == z || y == z) {
            return "equilateral";
        }
        else {
            return "different-sided";
        }
    }

    public static int ternaryEvaluation(int x, int y) {
        return (x > y) ? (x):(y);
    }

    public static double howManyItems(int x, double y, double z) {
        double sq = y * z;
        return (Math.floor((x / z) / sq));
    }

    public static int factorial(int x) {
        int fact = 1;
        for (int i = 1; i <= x; i ++) {
            fact = fact * i;
        }
        return fact;
    }

    public static int gcd(int x, int y) {
        while (y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        return x;
    }

    public static double ticketSaler(int x, int y) {
        return (x * y) * 0.72;
    }

    public static int tables(int x, int y) {
        int need = (int) Math.ceil((double) x / 2);
        int miss = need - y;
        if (miss < 0) {
            return 0;
        }
        else {
            return miss;
        }
    }
}
