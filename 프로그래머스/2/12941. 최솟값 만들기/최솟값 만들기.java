import java.util.Arrays;
class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        
        // A와 B를 오름차순으로 정렬
        Arrays.sort(A);
        Arrays.sort(B);

        for(int i=0; i<A.length; i++){
            //A는 순서대로, B는 역순으로 곱하여 answer에 누적
            answer += A[i] * B[B.length-i-1];
        }

        //최솟값은 가장 큰값과 가장 작은값끼리 곱해야하고
        //최댓값은 큰값끼리 곱해야 구할수 있음
        return answer;
    }
}