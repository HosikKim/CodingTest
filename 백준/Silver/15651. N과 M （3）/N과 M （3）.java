import java.util.Scanner;

public class Main {
    static int N, M;
    static int[] S;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        S = new int[M];

        backtracking(0);
        System.out.print(sb);
    }

    static void backtracking(int len) {
        if (len == M) {
            for (int i = 0; i < M; i++) {
                sb.append(S[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= N; i++) {
            S[len] = i;
            backtracking(len + 1);
        }
    }
}