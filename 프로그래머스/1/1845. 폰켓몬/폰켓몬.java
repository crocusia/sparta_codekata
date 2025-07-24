//가장 많은 종류의 폰켓몬 선택-> 종류 번호의 개수
import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        Map<Integer, Integer> monster = new HashMap<>();
        
        for(int n : nums){
            monster.put(n, monster.getOrDefault(n, 0) + 1);
        }
        
        int n = nums.length / 2;
        int p = monster.size();
        return answer = (n>p) ? p : n;
    }
}