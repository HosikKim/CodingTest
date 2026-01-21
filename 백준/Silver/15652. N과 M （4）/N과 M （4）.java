import java.util.Scanner;

public class Main {
    static int N, M;
    static int[] S;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        S = new int[M];

        backtracking(0, 1);
    }

    static void backtracking(int len, int start) {
        if (len == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(S[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = start; i <= N; i++) {
            S[len] = i;
            backtracking(len + 1, i);
        }
    }
}