import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String sentence = br.readLine();
            String words[] = sentence.split(" ");

            StringBuilder result = new StringBuilder();

            for (String word : words) {
                StringBuilder reverse = new StringBuilder(word);
                reverse.reverse();

                result.append(reverse).append(" ");
            }
            System.out.println(result.toString());
        }

    }
}