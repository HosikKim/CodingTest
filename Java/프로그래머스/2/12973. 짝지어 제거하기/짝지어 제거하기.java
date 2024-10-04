import java.util.Stack;
class Solution
{
    public int solution(String s)
    {
        int answer = -1;
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<arr.length;i++){
            char c = arr[i];
            if(stack.isEmpty()){
                stack.push(c);
            }else{
                if(stack.peek() == c){
                    stack.pop();
                }else{
                    stack.push(c);
                }
            }
        }
        answer = stack.isEmpty() ? 1 : 0;
        return answer;
    }
}