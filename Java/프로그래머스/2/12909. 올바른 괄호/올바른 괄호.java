class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int cnt=0;
        if(s.charAt(0)==')'){
            answer = false;
//            System.out.println(answer);
            return answer;
        }
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c=='('){
                cnt++;
            }
            if(c==')'){
                if(cnt==0){
                    answer = false;
                    return answer;
                }
                cnt--;
            }
        }
        if(cnt == 0){
            answer = true;
        }else{
            answer = false;
        }
//        System.out.println(answer);
        return answer;
    }
}