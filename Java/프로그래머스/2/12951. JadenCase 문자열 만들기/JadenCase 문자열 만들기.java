class Solution {
    public String solution(String s) {
        String answer = "";
        //" " 기준 문자열 잘라서 배열에 넣기
        String[] arr = s.split(" ");
        for(int i=0; i<arr.length; i++){
            if(arr[i].length() == 0){
                answer += " ";
            }else{
                String str = arr[i];
                answer += str.substring(0, 1).toUpperCase();
                answer += str.substring(1,str.length()).toLowerCase();
                answer += " ";
            }
        }
        if(s.substring(s.length()-1, s.length()).equals(" ")){
            return answer;
        }
        return answer.substring(0, answer.length() -1);
    }

}