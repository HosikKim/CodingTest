class Solution {
    public int solution(int n) {
        int answer = 0;
        int prevPrev = 0;
        int prev = 1;

        for(int i=1;i<=n-1;i++){
            answer = (prevPrev + prev)%1234567 ;
            prevPrev = prev;
            prev = answer;
        }
        return answer;
    }
}