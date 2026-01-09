class Solution {
    public int solution(int[] arr) {
        // 1. 결과를 저장할 변수
        int result = arr[0];
        
        /// 2. 배열은 순회하며 누적으로 최소공배수 계산
        for(int i=1; i < arr.length; i++){
            // 현재 최소공배수와 다음 수의 최소공배수 구함
            result = LCM(result, arr[i]);
        }
        return result;
    }
    
    // 두 수의 최소공배수를 구하는 메서드
    private int LCM(int a, int b){
        return (a*b) / GCD(a,b);
    }
    
    
    // 최대공약수를 구하는 메서드
    private int GCD(int a, int b){
        if(a % b == 0){
            return b;
        }
        return GCD(b, a%b);
    }
}