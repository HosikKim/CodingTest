class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            
            if(ch==' '){
                answer += ch;
                continue;
            }
            //알파벳이 26자인점을 이용해 순환하면서 n만큼 다음 알파벳 구하기
            
            // ch가 소문자인 경우
            if(ch >= 'a' && ch <= 'z'){
                answer += (char) ((ch-'a'+n) % 26 + 'a');
            }else{ // ch가 대문자인 경우
                answer += (char) ((ch-'A'+n) % 26 + 'A');
            }
        }
        return answer;
    }
}