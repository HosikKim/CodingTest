class Solution {
    public int[] solution(String s) {
        int cnt = 0;
        int removeZero = 0;
        
        while(!s.equals("1")){
            // 0의 개수를 세서 removeZero에 더하기
            removeZero += s.length() - s.replace("0", "").length();
            
            // 0을 제거
            s = s.replace("0","");
            
            s = Integer.toBinaryString(s.length());
            cnt++;
            
        }
        return new int[]{cnt, removeZero};
    }
}