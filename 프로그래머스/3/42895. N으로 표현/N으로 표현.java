import java.util.*;

class Solution {
    public int solution(int N, int number) {
        int anstwer = 0;
        List<Set<Integer>> dp = new ArrayList<>();
        dp.add(new HashSet<>());

        for(int k = 1; k <= 8; k++){
            Set<Integer> setK = new HashSet<>();

            setK.add(Integer.parseInt(String.valueOf(N).repeat(k)));

            for(int i = 1; i < k; i++){
                int j = k - i;
                for(int a : dp.get(i)){
                    for(int b : dp.get(j)){
                        setK.add(a+b);
                        setK.add(a-b);
                        setK.add(a*b);
                        if(b != 0) setK.add(a/b);
                        if(a != 0) setK.add(b/a);
                    }
                }   
            }

            dp.add(setK);

            if(setK.contains(number)){
                return k;
            }
        }

        return -1;
    }
}