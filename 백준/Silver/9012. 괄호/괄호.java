import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String ps = br.readLine();
            Stack<Integer> stack = new Stack<>();
            for (int j = 0; j < ps.length(); j++) {
                if (ps.charAt(j) == '(') {
                    stack.push(1);
                } else {
                    if (stack.isEmpty()) {
                        stack.push(1);
                        break;
                    }
                    stack.pop();
                }
            }

            if (stack.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }
}