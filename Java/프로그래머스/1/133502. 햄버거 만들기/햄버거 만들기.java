class Solution {
    public int solution(int[] ingredient) {
        int[] newingre = new int[ingredient.length];
        int i=0,answer=0;
        for(int num : ingredient){
            newingre[i] = num;
            i++;

            if(i>=4){
                if(newingre[i-4] == 1 && newingre[i-3] == 2 && newingre[i-2] == 3 && newingre[i-1] == 1){
                    i -= 4;
                    answer++;
                }
            }
        }
        //배열 -4 -3 -2 -1 인덱스 비교해서 맞으면 i-=4,answer++
        return answer;
    }
}