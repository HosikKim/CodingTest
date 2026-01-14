import java.util.Scanner;

public class Main {
    public static void main(String[] var0) {
        Scanner sc = new Scanner(System.in);
        int nums = sc.nextInt();
        int prime = 0;

        for (int i = 0; i < nums; i++) {
            int num = sc.nextInt();
            if (isPrime(num)) {
                prime++;
            }
        }
        System.out.println(prime);
    }

    public static boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }

        for (int i = 2; i <= num - 1; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}