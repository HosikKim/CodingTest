import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] numArr = new int[n];
        
        for (int i = 0; i < n; i++) {
            numArr[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(numArr);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(numArr[i]).append('\n');
        }
        System.out.print(sb);
    }
}