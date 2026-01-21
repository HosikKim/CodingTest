import java.util.Scanner;

public class Main {
    static int N;
    static int Result = 0;

    static boolean[] C;
    static boolean[] D1; // ↗
    static boolean[] D2; // ↘

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        C = new boolean[N];
        D1 = new boolean[2 * N];
        D2 = new boolean[2 * N];

        backtracking(0);

        System.out.println(Result);
    }

    static void backtracking(int row) {
        if (row == N) {
            Result++;
            return;
        }
        for (int col = 0; col < N; col++) {
            if (!C[col] && !D1[row - col + N] && !D2[row + col]) {
                C[col] = true;
                D1[row - col + N] = true;
                D2[row + col] = true;
                backtracking(row + 1);
                C[col] = false;
                D1[row - col + N] = false;
                D2[row + col] = false;
            }
        }
    }
}