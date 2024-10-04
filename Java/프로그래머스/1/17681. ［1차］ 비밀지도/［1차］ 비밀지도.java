import java.util.Arrays;
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for(int i=0;i<n;i++){
            String binaryA = Integer.toBinaryString(arr1[i]|arr2[i]);
            binaryA = String.format("%" + n + "s", binaryA);
            answer[i] = binaryA.replace("1", "#").replace("0", " ");
//            System.out.println(binaryA);
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }
}