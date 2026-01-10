class Solution {
    public String solution(String s) {
        String[] strArr = s.split(" ");
        
        int min = Integer.parseInt(strArr[0]);
        int max = Integer.parseInt(strArr[0]);
        
        for(String str : strArr){
            int num = Integer.parseInt(str);
            
            if(num <= min){
                min = num;
            }
            if(num >= max){
                max = num;
            }
        }
        
        return min + " " + max;
    }
}