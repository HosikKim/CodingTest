import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static StringBuilder dfsResult = new StringBuilder();
    static StringBuilder bfsResult = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 정점 개수
        int m = Integer.parseInt(st.nextToken()); // 간선 개수
        int v = Integer.parseInt(st.nextToken()); // 시작 정점

        // 그래프 초기화
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 정보 입력(문제조건)
        // "양방향"
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }
        // 간선 정렬(문제조건)
        // "단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고"
        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);
        }

        visited = new boolean[n + 1];
        dfs(v);

        visited = new boolean[n + 1];
        bfs(v);

        System.out.println(dfsResult);
        System.out.println(bfsResult);
    }

    static void dfs(int node) {
        visited[node] = true;
        dfsResult.append(node).append(" ");
        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            bfsResult.append(node).append(" ");
            for (int next : graph[node]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
}
