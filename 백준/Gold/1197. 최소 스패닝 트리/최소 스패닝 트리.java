import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
    int start, end, weight;

    Edge(int s, int e, int w) {
        start = s;
        end = e;
        weight = w;
    }

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(this.weight, o.weight);
    }
}

public class Main {
    static int[] parent; // 유니온 파인드 배열(부모노드를 찾기 위해)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        ArrayList<Edge> edges = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges.add(new Edge(start, end, weight));
        }

        parent = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        Collections.sort(edges);

        int selectedEdges = 0;
        long sumWeight = 0;

        for (Edge edge : edges) {
            if (union(edge.start, edge.end)) {
                selectedEdges++;
                sumWeight += edge.weight;
            }

            if (selectedEdges == V - 1) {
                break;
            }
        }
        System.out.println(sumWeight);
    }

    // x의 부모 찾기
    static int find(int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }

    // a와 b를 같은 집합으로
    static boolean union(int a, int b) {
        // 두 원소의 부모를 찾아서 연결
        a = find(a);
        b = find(b);
        // 부모가 다르면 연결 가능(사이클이 없음)
        if (a != b) {
            parent[b] = a;
            return true;
        }
        return false;
    }
}