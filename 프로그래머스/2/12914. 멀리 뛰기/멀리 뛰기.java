class Solution {
    public long solution(int n) {
        // n이 1이나 2일 때 예외 처리
        if(n == 1) return 1;
        if(n == 2) return 2;
        
        // 이전 값들을 저장
        long num1 = 1; //이전이전
        long num2 = 2; // 이전
        long now = 0;
        
        for(int i = 3; i <= n; i++){
            now = (num1 + num2) % 1234567;
            
            num1 = num2;
            num2 = now;
        }
    
        return now;
    }
}