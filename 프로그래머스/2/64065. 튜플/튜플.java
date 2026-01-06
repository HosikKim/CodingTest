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
                // TODO: 여기서 뭐 해야 할까요?
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