import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        // 시작시간, 끝시간을 담을 2차원 배열
        int[][] meets = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meets[i][0] = Integer.parseInt(st.nextToken());
            meets[i][1] = Integer.parseInt(st.nextToken());
        }

        // 정렬
        // 끝 시간을 기준으로 오름차순
        // 끝 시간이 같다면 시작시간을 기준으로 오름차순
        Arrays.sort(meets, (a, b) -> {
            if (a[1] != b[1]) {
                return a[1] - b[1];
            } else {
                return a[0] - b[0];
            }
        });

        // 회의 선택
        int count = 0;
        int endTime = 0;

        for (int i = 0; i < n; i++) {
            int start = meets[i][0];
            int end = meets[i][1];

            if (start >= endTime) {
                endTime = end;
                count++;
            }
        }

        System.out.println(count);
    }
}
