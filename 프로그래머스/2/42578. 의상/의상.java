import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> typeCount = new HashMap<>();

        for (String[] cloth : clothes) {
            String type = cloth[1];
            typeCount.put(type, typeCount.getOrDefault(type, 0) + 1);
        }

        int answer = 1;
        for (int count : typeCount.values()) {
            answer *= (count + 1);
        }

        return answer - 1;
    }
}