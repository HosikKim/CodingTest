import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int start, end, weight;

        Edge(int s, int e, int w) {
            start = s;
            end = e;
            weight = w;
        }
    }

    static int N, M;
    static List<Edge> edges;
    static long[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edges = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edges.add(new Edge(s, e, w));
        }
        BellmanFord(1);
    }

    public static void BellmanFord(int start) {
        dist = new long[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        // N-1번 반복하며 최단거리 갱신
        for (int i = 0; i < N - 1; i++) {
            for (Edge edge : edges) {
                if (dist[edge.start] != Integer.MAX_VALUE &&
                        dist[edge.start] + edge.weight < dist[edge.end]) {
                    dist[edge.end] = dist[edge.start] + edge.weight;
                }
            }
        }

        // 음수 사이클 확인
        for (Edge edge : edges) {
            if (dist[edge.start] != Integer.MAX_VALUE &&
                    dist[edge.start] + edge.weight < dist[edge.end]) {
                System.out.println(-1);
                return;
            }
        }

        // 출력
        for (int i = 2; i <= N; i++) {
            // 경로가 없다면
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(dist[i]);
            }
        }
    }
}