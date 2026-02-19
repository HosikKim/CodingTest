import java.io.*;
import java.util.*;
class Solution {
    public int solution(int n, int[][] wires) {
        List<Integer>[] tree = new ArrayList[n+1];
        int result = n;
        
        for(int i=0; i<=n; i++){
            tree[i] = new ArrayList<>();
        }
        
        for(int i=0; i<wires.length; i++){
            tree[wires[i][0]].add(wires[i][1]);
            tree[wires[i][1]].add(wires[i][0]);
        }
        
        
        for(int i=0; i<wires.length; i++){
            boolean[] visited = new boolean[n+1];
            int cnt = dfs(tree, visited, 1, wires[i][0], wires[i][1]);
            int diff = Math.abs(cnt - (n-cnt));
            result = Math.min(result, diff);
        }
        
        return result;
    }
    
    //1번이 속한 그룹만 탐색
    int dfs(List<Integer>[] tree, boolean[] visited, int start, int wire1, int wire2){
        //현재 노드 방문 처리
        visited[start] = true;
        int cnt = 1; // 자기 자신 카운트
        for(int next : tree[start]){
            // 끊을 전선이라면 탐색 안함
            if((start == wire1 && next == wire2) || (start == wire2 && next == wire1)){
                continue;
            }
            if(!visited[next]){
                // 재귀로 개수 누적
                cnt+= dfs(tree,visited,next,wire1,wire2);
            }
        }
        
        return cnt;
    }
}