import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] numbers = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(numbers);

        int left = 0;
        int right = n - 1;

        long mindiff = Long.MAX_VALUE;
        long answer1 = 0;
        long answer2 = 0;
        while (left < right) {
            long sum = numbers[left] + numbers[right];
            //절댓값 계산
            long diff = Math.abs(sum);
            if (diff < mindiff) {
                mindiff = diff;
                answer1 = numbers[left];
                answer2 = numbers[right];
            }

            if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(answer1 + " " + answer2);
    }
}