import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] result = new int[commands.length];
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < commands.length; i++) {
            // 2부터 5까지
            for (int j = commands[i][0]; j <= commands[i][1]; j++) {
                temp.add(array[j - 1]);
            }
            Collections.sort(temp);
            result[i] = temp.get(commands[i][2]-1);
            temp.clear();
        }

        return result;
    }
}