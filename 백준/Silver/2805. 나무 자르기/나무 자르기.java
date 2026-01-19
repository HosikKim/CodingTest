import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] trees = new int[N];
        st = new StringTokenizer(br.readLine());

        int maxheight = 0;
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            if (trees[i] > maxheight) {
                maxheight = trees[i];
            }
        }

        // 2. 이진탐색 범위 설정
        long left = 0;
        long right = maxheight;
        long answer = 0;

        // 3. 이진탐색
        while (left <= right) {
            long mid = (left + right) / 2;
            // System.out.println("left=" + left + ", right=" + right + ", mid" + mid);

            long sum = calc(trees, mid);
            // System.out.println("sum=" + sum + ", M=" + M);
            if (sum >= M) {
                answer = mid;
                // System.out.println("조건만족, answer 값: " + answer);
                left = mid + 1;
            } else {
                // System.out.println("sum<M, 높이낮춤");
                right = mid - 1;
            }
        }
        System.out.println(answer);
    }

    static long calc(int[] trees, long height) {
        long sum = 0;

        for (int tree : trees) {
            if (height < tree) {
                sum += tree - height;
            }
        }

        return sum;
    }
}
