import java.io.*;
import java.util.*;
class Solution {
    int max = 0;
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        backtracking(dungeons, visited, k, 0);
        
        return max;
    }
    
    void backtracking(int[][] dungeons, boolean[] visited, int k, int cnt){
        max = Math.max(max, cnt);
        for(int i=0; i<dungeons.length; i++){
            if(!visited[i] && k >= dungeons[i][0]){
                visited[i] = true;
                backtracking(dungeons, visited, k-dungeons[i][1], cnt+1);
                visited[i] = false;
            }
        }
    }
}