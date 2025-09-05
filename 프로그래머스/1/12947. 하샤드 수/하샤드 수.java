class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        int num = 0,temp = 0;
        
        temp = x;
        
        while(temp > 0){
            num += temp%10;
            temp /= 10;
        }
        
        if(x % num == 0){
            answer = true;
        }else{
            answer = false;
        }
        
        return answer;
    }
}