import java.util.List;
import java.util.ArrayList;
class Solution {
    public int[] solution(int[] answers) {
        int[] one = {1,2,3,4,5}; // 5개마다 반복
        int oneScore = 0;
        int[] two = {2,1,2,3,2,4,2,5}; // 8개마다 반복
        int twoScore = 0;
        int[] three = {3,3,1,1,2,2,4,4,5,5}; // 10개마다 반복
        int threeScore = 0;

        for(int i=0; i<answers.length; i++){
            if(answers[i] == one[i%5])oneScore++;
            if(answers[i] == two[i%8])twoScore++;
            if(answers[i] == three[i%10])threeScore++;
        }
        //최대값 찾기
        int maxScore = Math.max(oneScore,Math.max(twoScore,threeScore));
        List<Integer> winner = new ArrayList<>();
        //최댓값과 비교하여 점수가 가장높은 사람들을 리스트에 추가
        if(oneScore == maxScore) winner.add(1);
        if(twoScore == maxScore) winner.add(2);
        if(threeScore == maxScore) winner.add(3);

        //리스트의 사이즈와 같은 answer 배열 생성
        int[] answer = new int[winner.size()];
        //리스트의 값을 배열에 담기
        for(int j=0; j<winner.size(); j++){
            answer[j] = winner.get(j);
        }
        //테스트 출력
//        System.out.println(winner);
//        System.out.println(maxScore);
//        System.out.println(oneScore + " " + twoScore + " " + threeScore);
//        System.out.println(Arrays.toString(answer));
        return answer;
    }
}