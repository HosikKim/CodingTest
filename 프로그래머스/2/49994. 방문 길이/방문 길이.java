import java.util.*;
class Solution {
    public int solution(String dirs) {
        // 현재 위치
        int x = 0;
        int y = 0;
        
        // 지나간 길 저장 (중복 제거 위해 Set 사용)
        HashSet<String> visitedPaths = new HashSet<>();
        
        for(int i=0; i<dirs.length(); i++){
            char command = dirs.charAt(i);
            
            //다음 위치 계산
            int nextX = x;
            int nextY = y;
            
            if(command == 'U'){
                nextY++;
            }else if(command == 'D'){
                nextY--;
            }else if(command == 'R'){
                nextX++;
            }else if(command == 'L'){
                nextX--;
            }
            
            // 경계 체크 (-5 ~ 5 범위)
            if(nextX > 5 || nextX < -5 || nextY > 5 || nextY < -5){
                continue;
            }
            
            // 길 정보를 문자열로 만들기
            // x,y -> nextX,nextY
            // 방향이 달라도 같은 길이니 두가지 방향의 길 모두 저장
            String path1 = x + "," + y + "," + nextX + "," + nextY;
            String path2 = nextX + "," + nextY + "," + x + "," + y;
            
            if(!visitedPaths.contains(path1)){
                visitedPaths.add(path1);
                visitedPaths.add(path2);
            }
            
            // 현재 위치 업데이트
            x = nextX;
            y = nextY;
        }
        
        // Set에는 양방향 둘다 저장되니까 / 2 해주기
        return visitedPaths.size() / 2;
    }
}