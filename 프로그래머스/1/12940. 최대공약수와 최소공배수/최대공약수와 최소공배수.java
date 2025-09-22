class Solution {
    public int[] solution(int n, int m) {
        int a = Math.max(n, m);
        int b = Math.min(n, m);
        
        // 유클리드 호제법
        while(b != 0){
            int r = a % b;
            a = b;
            b = r;
        }
        
        // 최소 공배수 * 최대 공약수 = a * b
        // 따라서 최소공배수 = a * b / 최대 공약수
        return new int[] {a, n*m/a};
    }
}