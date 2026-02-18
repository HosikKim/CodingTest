import java.io.*;
import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] strNumbers = new String[numbers.length];
        
        //int[]는 기본타입이라 comparator 적용 불가능
        //String[] 으로 변환후 정렬
        for(int i=0; i<numbers.length; i++){
            strNumbers[i] = String.valueOf(numbers[i]);
        }
        
        //b+a 보다 a+b가 크면 음수반환
        //a를 b보다 앞으로
        Arrays.sort(strNumbers, (a,b) -> (b+a).compareTo(a+b));  
        StringBuilder result = new StringBuilder();
        for(int i=0; i<strNumbers.length; i++){
            result.append(strNumbers[i]);
        }
        
        //앞자리가 0이면 전체가 0이라는 의미
        if(result.charAt(0) == '0') return "0";
        return result.toString();
    }
}