import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        System.out.println(calc(n));
    }

    public static int calc(int n) {
        for (int five = n / 5; five >= 0; five--) {
            int money = n - (five * 5);
            if (money % 2 == 0) {
                int two = money / 2;
                int total = five + two;
                return total;
            }
        }
        return -1;
    }
}