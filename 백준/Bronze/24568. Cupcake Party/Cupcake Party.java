import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int student = 28;
        int cake = 0;
        int large = 8;
        int small = 3;

        int l = sc.nextInt();
        int s = sc.nextInt();

        cake = l * large + s * small;

        System.out.println(cake - student);

    }
}