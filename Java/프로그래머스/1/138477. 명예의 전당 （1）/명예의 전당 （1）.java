import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        ArrayList<Integer> rank = new ArrayList<Integer>();

        //k의 길이가 score.length보다 긴 상황인 예외처리를 위해 작성한 구문
        k = k> score.length? score.length : k;

        for(int i = 0; i< k;i++){
            rank.add(score[i]);
            answer[i] = Collections.min(rank);
//            System.out.println(rank);
        }
        for(int j = k; j<score.length;j++){
            if(score[j]>Collections.min(rank)){
                if(rank.size()>=k){
                    rank.remove(Collections.min(rank));
                }
                rank.add(score[j]);
            }
            Collections.sort(rank);
//            System.out.println(rank);
            answer[j] = Collections.min(rank);
        }
//        System.out.println(Arrays.toString(answer));
        return answer;
    }
}