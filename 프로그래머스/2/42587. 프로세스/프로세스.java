import java.io.*;
import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0; i<priorities.length;i++){
            queue.offer(new int[]{priorities[i], i});
        }
        
        while(true){
            int[] thread = queue.poll();
            boolean hasHigher = false;
            for(int[] t : queue){
                if(t[0] > thread[0]){
                    hasHigher = true;
                    break;
                }
            }
            
            if(hasHigher){
                queue.offer(thread);
            }else{
                answer++;
                if(thread[1] == location) return answer;
            }
            
        }
    }
}