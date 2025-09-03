import java.util.*;
class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        // 런타임 에러
        // for(int i=0; i<=t.length()-p.length(); i++){
        //     String temp = "";
        //     for(int j=0; j<p.length(); j++){
        //         char c = t.charAt(i+j);
        //         // System.out.println(c);
        //         temp += c;
        //     }
        //     // System.out.println("비교값: " + temp);
        //     int numT = Integer.parseInt(temp);
        //     int numP = Integer.parseInt(p);
        //     if(numT <= numP){
        //         answer++;
        //     }
        // }
        
        
        String temp = "";
        for(int i=0; i<=t.length()-p.length(); i++){
            temp = t.substring(i, i+p.length());
            
            Long numT = Long.parseLong(temp);
            Long numP = Long.parseLong(p);
            
            if(numT <= numP){
                answer++;
            }
            
            temp = "";
        }
        
        return answer;
    }
}