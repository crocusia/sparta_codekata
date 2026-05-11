import java.util.*; 

class Solution {
    public int[] solution(String s) {
        
        int[] answer = {0, 0};
        
        int len = s.length();
        while(s.length() > 1) {
            s = s.replaceAll("0","");
            System.out.println(s);
            answer[1] += len - s.length();
            answer[0]++;
            s = Integer.toBinaryString(s.length());
            len = s.length();
        }
        
        return answer;
    }
}