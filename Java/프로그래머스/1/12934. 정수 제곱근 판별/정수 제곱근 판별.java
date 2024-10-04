class Solution {
    public long solution(long n) {
        long answer = 0;
        while (answer * answer < n) {
            answer++;
            if ((answer * answer) % n == 0){
                answer++;
                return answer*answer;
            }
        }
        return -1;
    }
}