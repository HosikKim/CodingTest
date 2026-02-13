import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] v = new int[3][2];
        int x = 0, y = 0;
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            v[i][0] = Integer.parseInt(st.nextToken());
            v[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < 3; i++) {
            //xor연산으로 한번만 등장한 값 찾기
            x ^= v[i][0];
            y ^= v[i][1];
        }

        System.out.println(x + " " + y);
    }
}