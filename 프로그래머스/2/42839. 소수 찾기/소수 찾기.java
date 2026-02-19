import java.io.*;
import java.util.*;

class Solution {
    //결과 집합
    Set<Integer> result = new HashSet<>();
    public int solution(String numbers) {
        boolean[] use = new boolean[numbers.length()];
        int cnt = 0;
        backtracking(numbers, use, "");
        for(int num : result){
            if(isPrime(num)){
                cnt++;
            }
        }
        return cnt;
    }
    
    void backtracking(String numbers, boolean[] use, String now){
        if(!now.isEmpty()){
            result.add(Integer.parseInt(now));
        }
        for(int i=0; i<numbers.length(); i++){
            if(!use[i]){
                use[i] = true;
                backtracking(numbers, use, now+numbers.charAt(i));
                use[i] = false;
            }
        }
    }
    
    boolean isPrime(int n){
        if(n <= 1) return false;
        //n의 제곱근까지만 나누기
        for(int i=2; i <= Math.sqrt(n); i++){
            if(n%i == 0) return false;
        }
        return true;
    }
}