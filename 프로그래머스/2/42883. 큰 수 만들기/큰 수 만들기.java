import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Deque<Character> stack = new ArrayDeque();
        
        int length = number.length();
        
        for(int i = 0; i < length; i++){
            char c = number.charAt(i);
            while(!stack.isEmpty() && k > 0 && stack.peek() < c){
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        
        StringBuilder answer = new StringBuilder();
        
        for(char c : stack){
            answer.append(c);
        }
        answer.reverse();
        while(k > 0){
            answer.deleteCharAt(answer.length()-1);
            k--;
        }
        return answer.toString();
    }
}