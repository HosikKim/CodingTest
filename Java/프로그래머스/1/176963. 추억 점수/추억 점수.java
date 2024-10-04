class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length]; //결과값은 사진수 만큼 생성
        
        for(int i=0; i<photo.length; i++){ // photo.length => 사진의 갯수
            for(int j=0; j<photo[i].length; j++){ // photo[i].length => i번째 사진의 사람수
                for(int k=0; k<name.length; k++){ // name.length => 사람명수 
                    if(name[k].equals(photo[i][j])){ //사람과 사진속 사람의 이름이 같다면
                        answer[i] += yearning[k]; //해당 사진의 인덱스에 그리움 점수 추가
                    }
                }
            }
        }
        
        return answer;
    }
}