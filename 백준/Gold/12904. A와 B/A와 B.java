import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String t = br.readLine();

        while (t.length() > s.length()) {
            char last = t.charAt(t.length() - 1);

            if (last == 'A') {
                t = t.substring(0, t.length() - 1);
            } else {
                t = t.substring(0, t.length() - 1);
                StringBuffer sb = new StringBuffer(t);
                t = sb.reverse().toString();
            }
        }

        if (t.equals(s)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}