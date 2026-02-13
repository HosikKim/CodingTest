import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 가지고있는 랜선 갯수
        int K = Integer.parseInt(st.nextToken());
        // 만들어야 하는 갯수
        int N = Integer.parseInt(st.nextToken());

        // 랜선의 길이들
        int[] lines = new int[K];
        int max = 0;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            lines[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, lines[i]);
        }

        long left = 1;
        long right = max;
        long result = 0;

        // 이진탐색
        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0;
            for (int i = 0; i < K; i++) {
                count += lines[i] / mid;
            }
            if (count >= N) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(result);
    }
}