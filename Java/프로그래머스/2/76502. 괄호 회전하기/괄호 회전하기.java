import java.util.Stack;
class Solution {
    public int solution(String s) {
        int answer = 0;
        for(int i=0;i<s.length();i++){
            String rotationS = s.substring(i) + s.substring(0,i);
//            System.out.println(rotationS);
            if(checkStr(rotationS)){
                answer++;
            }
        }
//        System.out.println(answer);
        return answer;
    }
    public static boolean checkStr(String str){
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            //스택이 비어있으면 스택에 해당글자 push
            if(stack.isEmpty()){
                stack.push(c);
            }else{
                //닫는 괄호가 나오면
                if(c == ']'){
                    //스택에 해당하는 여는 괄호가 있는지 확인
                    if(stack.peek() == '['){
                        //있으면 스택에 pop
                        stack.pop();
                    }else{
                        //없으면 스택에 push
                        stack.push(c);
                    }
                }else if(c == ')'){
                    if(stack.peek() == '('){
                        stack.pop();
                    }else{
                        stack.push(c);
                    }
                }else if(c == '}'){
                    if(stack.peek() == '{'){
                        stack.pop();
                    }else{
                        stack.push(c);
                    }
                }else{
                    stack.push(c);
                }
            }
        }
        //최종으로 스택이 비어있으면 올바른괄호
        if(stack.isEmpty()){
            return true;
        }else{
            //스택이 남아있으면 꼬인괄호가 있다는뜻
            return false;
        }

    }
}