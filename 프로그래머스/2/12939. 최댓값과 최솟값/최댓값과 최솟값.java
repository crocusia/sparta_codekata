import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] strArray = s.split(" ");
        int size = strArray.length;
        
        int[] intArray = new int[size];
        for(int i = 0; i < size; i++){
            intArray[i] = Integer.parseInt(strArray[i]);
        }
        
        Arrays.sort(intArray);
        
        answer = String.valueOf(intArray[0]) + " " + String.valueOf(intArray[size-1]);
        return answer;
    }
}