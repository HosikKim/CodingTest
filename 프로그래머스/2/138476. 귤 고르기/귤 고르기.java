import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int sum = 0; // 현재까지 선택한 귤의 총 개수
        int cnt = 0; // 선택한 귤 종류의 개수(최소값)
        
        // 귤 크기별 개수를 저장할 HashMap
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        // 각 귤 크기별 등장 횟수 카운트
        for(int num : tangerine){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        // 귤 개수만 따로 리스트로 추출
        ArrayList<Integer> valueList = new ArrayList<>(map.values());
        
        // 개수가 많은 순서대로 정렬(내림차순)
        Collections.sort(valueList, Collections.reverseOrder());
        
        // 가장 많은 개수부터 선택하면서 k개 이상이 되는 순간까지 반복
        for(int v : valueList){
            if(sum + v >= k){
                cnt++;
                break;
            }else{
                sum += v;
                cnt++;
            }
        }
        return cnt;
    }
}