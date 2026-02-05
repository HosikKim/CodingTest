import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        // 배열
        int[][] array = new int[n + 1][n + 1];
        // 누적합 배열
        int[][] S = new int[n + 1][n + 1];

        // 기존 배열 입력
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 2차원 누적합 생성
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                // 위쪽 + 왼쪽 - 겹친부분 + 자기자신
                S[i][j] = S[i - 1][j] + S[i][j - 1] - S[i - 1][j - 1] + array[i][j];
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            // 1,1부터 x2,y2까지의 전체합에서 - 위쪽 부분 - 왼쪽 부분 + 겹친 부분
            int sum = S[x2][y2] - S[x1 - 1][y2] - S[x2][y1 - 1] + S[x1 - 1][y1 - 1];
            System.out.println(sum);
        }

    }
}