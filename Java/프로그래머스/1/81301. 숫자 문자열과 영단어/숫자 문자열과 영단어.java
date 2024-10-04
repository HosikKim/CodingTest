class Solution {
    public int solution(String s) {
        String []eng = new String[]{"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "zero"};
        String []num = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};

        for(int i=0;i<10;i++){
            s = s.replace(eng[i], num[i]);
        }
        System.out.println(s);
        int answer = Integer.parseInt(s);
        return answer;
    }
}   