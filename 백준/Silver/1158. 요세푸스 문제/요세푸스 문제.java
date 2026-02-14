import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            queue.add(i + 1);
        }
        List<Integer> result = new ArrayList<>();
        int count = 0;
        while (result.size() < N) {
            count++;
            if (count % K == 0) {
                result.add(queue.poll());
            } else {
                queue.offer(queue.poll());
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for (int num : result) {
            if (num == result.get(result.size() - 1)) {
                sb.append(num);
            } else {
                sb.append(num + ", ");
            }
        }
        sb.append(">");

        System.out.println(sb);

    }
}