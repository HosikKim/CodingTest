import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> temp = new ArrayList<>();
        
        for(int i=0; i<arr.length; i++){
            if(arr[i] % divisor == 0){
                temp.add(arr[i]);
            }
        }
        
        //temp.stream() : Stream<Integer> 값 반환
        //mapToInt : temp의 Integer을 int값으로 언박싱
        //toArray : temp값을 array로 변환
        int[] answer = temp.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(answer);
        
        //divisor로 나누어 떨어지는 element가 하나도 없을때
        if(temp.isEmpty()){
            return new int[]{-1};
        }
        
        return answer;
    }
}