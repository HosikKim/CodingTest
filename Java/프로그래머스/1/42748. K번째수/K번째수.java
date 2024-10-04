import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        //answer의 크기는 작업량으로 결정
        int[] answer = new int[commands.length];

        //자른 array 값을 임시로 담기위해 리스트 생성
        ArrayList<Integer> list = new ArrayList<>();

        //작업량 만큼 for 반복
        for(int i=0;i<commands.length;i++) {
            //배열 자르는 부분
            for (int j = commands[i][0]-1; j < commands[i][1]; j++) {
                list.add(array[j]); //자른 배열을 list에 담기
            }
            Collections.sort(list); //list 정렬
//            System.out.println(list); //리스트 확인
            answer[i] = list.get(commands[i][2]-1); //리스트에서 k번째수 배열에 담기
//            System.out.println(answer[i]); //배열 확인
            list.clear(); //새로 list에 담기위해 리스트 clear()
        }
        return answer;
    }
}