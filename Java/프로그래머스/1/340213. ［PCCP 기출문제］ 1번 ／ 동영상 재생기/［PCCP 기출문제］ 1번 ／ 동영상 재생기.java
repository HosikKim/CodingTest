class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        int video = Integer.parseInt(video_len.split(":")[0])*60 + Integer.parseInt(video_len.split(":")[1]);
        int nowPos = Integer.parseInt(pos.split(":")[0])*60 + Integer.parseInt(pos.split(":")[1]);
        int opStart = Integer.parseInt(op_start.split(":")[0])*60 + Integer.parseInt(op_start.split(":")[1]);
        int opEnd = Integer.parseInt(op_end.split(":")[0])*60 + Integer.parseInt(op_end.split(":")[1]);
        if(nowPos >= opStart && nowPos <= opEnd){
            nowPos = opEnd;
        }

        for(int i=0; i<commands.length; i++){
            if(commands[i].equals("prev")){
//                System.out.println("prev감지");
                if(nowPos < 10){
                    nowPos = 0;
                }else{
                    nowPos -= 10;
                }
            }else if(commands[i].equals("next")){
//                System.out.println("next감지");
                nowPos += 10;
                if(video - nowPos < 10){
                    nowPos = video;
                }
            }
            if(nowPos >= opStart && nowPos <= opEnd){
                nowPos = opEnd;
            }
//            System.out.println(nowPos);
        }


        answer = String.format("%02d:%02d", nowPos / 60, nowPos % 60);
//        System.out.println(answer);
        return answer;
    }
        
}