import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] complete = new int[progresses.length];
        int cnt = 1;
        
        List<Integer> answer = new ArrayList<>();
        
        for(int i=0; i<progresses.length;i++){
            complete[i] = (int)Math.ceil((double)(100 - progresses[i]) / speeds[i]);
            
            // 정수트릭을 사용해도 해결 가능
            // (100-progreeses[i] + speeds[i] - 1) / speeds[i]
            // (a + b - 1) / b => a/b의 올림을 정수로 구하는 공식
        }
        
        int flag = complete[0];
        
        for(int i=1; i<complete.length; i++){
            if(complete[i] <= flag){
                cnt++;
            }else{
                answer.add(cnt);
                cnt = 1;
                flag = complete[i];
            }
        }
        
        //마지막 그룹 추가
        answer.add(cnt);
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}