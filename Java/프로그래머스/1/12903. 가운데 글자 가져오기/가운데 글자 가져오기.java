class Solution {
    public String solution(String s) {
        String answer = "";
        if(s.length()%2==0){
            answer = String.copyValueOf(s.toCharArray(),s.length()/2-1,2);
        }else{
            answer = String.copyValueOf(s.toCharArray(),s.length()/2,1);
        }
        return answer;
    }
}