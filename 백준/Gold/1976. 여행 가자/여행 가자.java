import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 도시 수
        int N = Integer.parseInt(br.readLine());
        // 여행 계획 도시 수
        int M = Integer.parseInt(br.readLine());

        init(N);

        // union 처리
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int connected = Integer.parseInt(st.nextToken());
                if (connected == 1) {
                    union(i, j);
                }
            }
        }

        // 여행 계획 읽기
        int[] plan = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            plan[i] = Integer.parseInt(st.nextToken());
        }

        boolean possible = true;
        for (int i = 0; i + 1 < M; i++) {
            if (!isSameSet(plan[i], plan[i + 1]))
                possible = false;

        }

        System.out.println(possible ? "YES" : "NO");

    }

    static void init(int n) {
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
    }

    static int find(int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        }
    }

    static boolean isSameSet(int a, int b) {
        return find(a) == find(b);
    }
}
