import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> visited = new HashMap<>();
        int index = 0;
        int current = A;

        while (true) {
            if (visited.containsKey(current)) {
                System.out.println(visited.get(current));
                break;
            }
            visited.put(current, index);
            current = nextNumber(current, P);
            index++;
        }

    }

    static int nextNumber(int current, int p) {
        int sum = 0;
        while (current > 0) {
            int digit = current % 10;
            sum += Math.pow(digit, p);
            current = current / 10;
        }

        return sum;
    }
}