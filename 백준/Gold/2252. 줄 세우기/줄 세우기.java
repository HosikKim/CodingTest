import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static List<Integer>[] graph;
    static int[] indegree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        indegree = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph[A].add(B);
            indegree[B]++;
        }

        sort();
    }

    static void sort() {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            // 진입차수가 0이라면 큐에 담기
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        // List는 문자열 변환 과정이 필요하고 메모리를 더 사용 함
        // 출력만 하면 되기에 StringBuilder가 빠름
        StringBuilder result = new StringBuilder();

        while (!queue.isEmpty()) {
            int now = queue.poll();
            result.append(now).append(" ");

            for (int next : graph[now]) {
                // 선택된 노드가 가리키는 진입 차수를 1씩 뺌
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        System.out.println(result);
    }
}
