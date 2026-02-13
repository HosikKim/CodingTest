import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] request = new int[n];
        int sum = 0;
        int max = 0;

        for (int i = 0; i < n; i++) {
            request[i] = Integer.parseInt(st.nextToken());
            sum += request[i];
            if (max < request[i]) {
                max = request[i];
            }
        }

        Arrays.sort(request);

        int money = Integer.parseInt(br.readLine());
        int nowmoney = money;
        int nowcity = n;
        int sparemoney = 0;
        int result = max;

        if (sum < money) {
            System.out.println(max);
        } else {
            for (int i = 0; i < n; i++) {
                int maxmoney = nowmoney / nowcity;
                if (request[i] <= maxmoney) {
                    nowmoney -= request[i];
                    nowcity--;
                    // 남은 상환액 계산
                    // sparemoney += (money / n) - request[i];
                } else {
                    // result = (money / n) + (sparemoney / (n - i));
                    result = maxmoney;
                    break;
                }
            }
            System.out.println(result);
        }
    }
}