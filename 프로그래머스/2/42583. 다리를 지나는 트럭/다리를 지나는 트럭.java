import java.io.*;
import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int cross = 0;
        int time = 0;
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i=0; i<bridge_length; i++){
            queue.offer(0);
        }
        
        
        while(cross < truck_weights.length){
            queue.poll();
            int currentWeight = 0;
            for(int w : queue){
                currentWeight += w;
            }
            
            if(currentWeight + truck_weights[cross] <= weight){
                queue.offer(truck_weights[cross]);
                cross++;
            }else{
                queue.offer(0);
            }
                
            time += 1;
        }
        
        // 마지막 차량이 다리에 오르는 순간 끝나니까
        // 다리길이까지 더해주기
        return time + bridge_length;
    }
}