class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        int a = 0;
        for(int i=0; i<10; i++){ 
            for(int j=0;j<numbers.length;j++){
                if(numbers[j] == i){
                    a += numbers[j];
                }
            }
            
        }
        return answer+45-a;
    }
}