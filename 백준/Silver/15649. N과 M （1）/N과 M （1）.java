import java.util.Scanner;

public class Main {
    static int N, M;
    static int[] S;
    static boolean[] V;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        S = new int[M];
        V = new boolean[N + 1];

        backtracking(0);
    }

    static void backtracking(int len) {
        if (len == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(S[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= N; i++) {
            // 백트래킹의 가지치기 기법
            if (V[i] == true) {
                continue;
            } else {
                V[i] = true;
                S[len] = i;
                // 재귀 형식으로 구현
                backtracking(len + 1);
                V[i] = false;
            }
        }
    }
}