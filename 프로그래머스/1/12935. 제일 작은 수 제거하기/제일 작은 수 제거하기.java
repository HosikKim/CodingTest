class Solution {
    public int[] solution(int[] arr) {
        
        if(arr.length == 1){
            int[] answer = {-1};
            return answer;
        }
        
        //새로 만들 배열 선언
        int[] answer = new int[arr.length-1];
        int min = arr[0]; // 기준 값 선언
        
        for(int i=0; i<arr.length; i++){
            min = Math.min(min, arr[i]);
        }
        
        int index=0;
        
        for(int i=0; i<arr.length; i++){
            if(arr[i] == min){
                continue;
            }
            answer[index++] = arr[i];
        }
        
        return answer;
    }
}