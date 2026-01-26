import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    int edge;
    int cost;

    Node(int v, int c) {
        this.edge = v;
        this.cost = c;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }

}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        ArrayList<Node>[] graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int city = Integer.parseInt(st.nextToken());
            int edge = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[city].add(new Node(edge, cost));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int result = dijkstra(graph, start, end);
        System.out.println(result);
    }

    public static int dijkstra(ArrayList<Node>[] graph, int start, int end) {
        int[] distance = new int[graph.length];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[distance.length];

        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (visited[now.edge])
                continue;
            visited[now.edge] = true;

            for (Node next : graph[now.edge]) {
                if (distance[next.edge] > distance[now.edge] + next.cost) {
                    distance[next.edge] = distance[now.edge] + next.cost;
                    pq.offer(new Node(next.edge, distance[next.edge]));
                }
            }
        }

        return distance[end];

    }
}
