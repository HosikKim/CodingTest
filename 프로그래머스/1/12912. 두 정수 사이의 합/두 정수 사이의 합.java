class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        int max = 0,min = 0;
        // a와 b가 같을경우
        if(a == b){
            answer = a;
            return answer;
        }
        
        // a와 b의 크기를 이용해 min,max값 구하기
        if(a > b){
            max = a;
            min = b;
        }else{
            max = b;
            min = a;
        }
        
        for(int i=min; i<=max; i++){
            answer += i;
        }
        return answer;
    }
}