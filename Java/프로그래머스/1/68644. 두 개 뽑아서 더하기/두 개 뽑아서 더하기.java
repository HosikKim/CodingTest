import java.util.Arrays;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[0];
        int cnt=0;

        for(int i=0; i<numbers.length;i++){
            for(int j=i+1; j<numbers.length; j++){
                answer = Arrays.copyOf(answer, answer.length+1);
                answer[cnt] = numbers[i] + numbers[j];
                cnt++;
            }
        }
        Arrays.sort(answer);
        answer = Arrays.stream(answer).distinct().toArray();
        return answer;
    }
}