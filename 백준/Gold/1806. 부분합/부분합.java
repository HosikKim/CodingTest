import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] numbers = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        int sum = 0;
        int minLength = n + 1;

        // right가 배열끝까지
        while (right < n) {
            sum += numbers[right];

            while (sum >= s) {
                minLength = Math.min(minLength, right - left + 1);
                // left를 오른쪽으로 이동하면서 길이 줄여가면서 가장 짧은 길이 찾기
                sum -= numbers[left];
                left++;
            }
            right++;
        }

        if (minLength == n + 1) {
            System.out.println(0);
        } else {
            System.out.println(minLength);
        }
    }
}