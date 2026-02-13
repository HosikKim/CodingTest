import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] money = new int[N];

        int max = 0;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            money[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, money[i]);
            sum += money[i];
        }

        int left = max;
        int right = sum;
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            // mid 원으로 인출할때의 인출횟수
            int count = 1; // 첫 인출
            int nowmoney = mid;

            for (int i = 0; i < N; i++) {
                if (nowmoney >= money[i]) {
                    nowmoney -= money[i];
                } else {
                    count++;
                    nowmoney = mid - money[i];
                }
            }

            if (count <= M) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(result);
    }
}