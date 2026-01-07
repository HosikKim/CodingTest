import java.util.Arrays;
class Solution {
    public int solution(int[] people, int limit) {
        // 1. 몸무게 순으로 정렬
        Arrays.sort(people);
        
        int boat = 0;
        int light = 0; // 시작 인덱스
        int heavy = people.length - 1; // 끝 인덱스
        
        // 2. 모든 사람 태울때까지 반복
        while(light <= heavy){
            // 3. 가장 가벼운 사람과 가장 무거운 사람이 같이 탈수 있나?
            if(people[light] + people[heavy] <= limit){
                light++;
            }
            heavy--;
            boat++;
        }
        return boat;
    }
}