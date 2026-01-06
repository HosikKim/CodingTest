import java.util.*;
class Solution {
    public int[] solution(String s) {
        // 1. 바깥쪽 중괄호 제거
        s = s.substring(2, s.length() - 2);
        // 2. 집합 분리
        // ("},{") 로 작성시 정규표현식 해석 에러발생
        String[] sets = s.split("\\},\\{");
        // 3. 집합들을 길이 순으로 정렬
        Arrays.sort(sets, (a,b) -> a.length() - b.length());
        // 4. 등장 숫자 기록
        Set<Integer> appeared = new HashSet<>();
        // 5. 결과 담을 리스트
        List<Integer> result = new ArrayList<>();
        
        for(String set : sets){
            String[] numbers = set.split(",");
            
            for(String numStr : numbers){
                int number = Integer.parseInt(numStr);
                // 여기서 !result.contains(number) 가 아닌 Set 로 비교한 이유
                // Set.contains()는 해시 테이블로 바로 찾음 -> O(1)
                // List.contains()는 처음 부터 끝까지 탐색 -> O(n)
                // 성능 차이가 크기 때문에 Set로 탐색후 list에 추가
                if(!appeared.contains(number)){
                    result.add(number);
                    appeared.add(number);
                }
            }
        }
        
        int[] answer = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}
