import java.io.*;
import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        //hashMap으로 종류별 갯수를 세서
        //안입는 선택지까지 +1 후 곱하고
        //모두 안입는 선택지 -1
        Map<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<clothes.length; i++){
            //getOrDefault 함수 활용해서 이미 있으면 카운트 1증가
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }
        int result = 1;
        for(int value : map.values()){
            result *= value+1;
        }
        
        return result-1;
    }
}