import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        int gcd = GCD(num1, num2);
        int lcm = (num1 * num2) / gcd;

        System.out.println(gcd);
        System.out.println(lcm);
    }

    public static int GCD(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }
}