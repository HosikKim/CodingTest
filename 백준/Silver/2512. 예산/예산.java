import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] request = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0; i < n; i++) {
            request[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, request[i]);
        }

        int M = Integer.parseInt(br.readLine());

        int left = 0;
        int right = max;
        int answer = 0;

        // 상한액을 이분 탐색
        while (left <= right) {
            int mid = (left + right) / 2;
            long sum = 0;

            // 현재 상한액(mid)으로 예산 배정 시 총합 계산
            for (int i = 0; i < n; i++) {
                sum += Math.min(request[i], mid);
            }

            if (sum <= M) {
                // 조건 만족 → 상한액을 더 키워볼 수 있음
                answer = mid;
                left = mid + 1;
            } else {
                // 예산 초과 → 상한액 줄여야 함
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }
}