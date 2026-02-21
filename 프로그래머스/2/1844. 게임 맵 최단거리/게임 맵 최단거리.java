import java.io.*;
import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        int[] dr = {0, 0, 1, -1};
        int[] dc = {1, -1, 0, 0};
        
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        
        // 행, 열, 거리
        queue.offer(new int[]{0, 0, 1});
        visited[0][0] = true;
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int row = cur[0], col = cur[1], distance = cur[2];
                
            if(row == n-1 && col == m-1){
                return distance;
            }
            
            for(int i=0; i<4; i++){
                int nextRow = row + dr[i];
                int nextCol = col + dc[i];
                
                if(nextRow < n && nextRow >= 0 && nextCol < m && nextCol >= 0 && maps[nextRow][nextCol] == 1 && !visited[nextRow][nextCol]){
                    visited[nextRow][nextCol] = true;
                    queue.offer(new int[]{nextRow, nextCol, distance+1});
                }
            }
        }
        
        return -1;
    }
}