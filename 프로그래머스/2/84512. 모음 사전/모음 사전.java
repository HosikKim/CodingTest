class Solution {
    int cnt = 0;
    String[] alpha = {"A", "E", "I", "O", "U"};
    boolean found = false;
    public int solution(String word) {
        
        backtracking("", word);
        
        return cnt;
    }
    void backtracking(String now, String word){
        if(found){
            return;
        }
        //첫 빈문자열은 cnt증가 안함
        if(!now.isEmpty()){
            cnt++;
        }
        
        //같은 단어 찾으면 found변수 값 바꿔서 모든 for문 종료
        if(now.equals(word)){
            found = true;
            return;
        }
        
        //단어 길이 5가되면 재귀 종료
        if(now.length() == 5){
            return;
        }
        
        //알파벳 string 배열 돌면서 각 단어 추가
        for(String a : alpha){
            backtracking(now+a, word);
        }
    }
}