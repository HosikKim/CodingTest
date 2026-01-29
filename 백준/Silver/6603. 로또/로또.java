//백트래킹을 사용한 조합문제
import java.util.*;
import java.io.*;

public class Main {
    static int k;
    static int[] S;
    static int[] selected;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean isFirst = true;

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());

            if (k == 0)
                break;

            S = new int[k];
            selected = new int[6];
            for (int i = 0; i < k; i++) {
                S[i] = Integer.parseInt(st.nextToken());
            }

            //맨처음의 앞이나 맨마지막의 뒤는 빈줄이 필요가 없음
            if (!isFirst) {
                sb.append("\n");
            }
            isFirst = false;

            Combi(0, 0);

        }

        System.out.print(sb);
    }

    static void Combi(int start, int selectedCount) {
        //6개가 조합되면 StringBuilder에 추가
        if (selectedCount == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i < k; i++) {
            selected[selectedCount] = S[i];
            //중복 방지를 위해 다음 인덱스(+1)부터 시작, 선택개수 1증가
            Combi(i + 1, selectedCount + 1);
        }
    }

}