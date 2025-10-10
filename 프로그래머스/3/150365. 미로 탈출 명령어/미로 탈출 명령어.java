import java.util.*;

class Solution {
    

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
    
        String answer = "";
        
        int[] dirR = {1, 0, 0, -1};
        int[] dirC = {0, -1, 1, 0};
        String[] dir = {"d", "l", "r", "u"};
        
        
        for(int depth = 0; depth < k; depth++){
            for(int i = 0; i < 4; i++){
                int nr = x + dirR[i];
                int nc = y + dirC[i];
                if(nr < 1 || nr > n || nc < 1 || nc > m) continue;
                int save = k - (depth + 1);
                int need = Math.abs(nr-r) + Math.abs(nc-c);
                if(need <= save && ((save - need) % 2) == 0){
                    answer+= dir[i];
                    x = nr; y = nc;
                    break;
                }
            }
        }
        
        if(answer.length() < k){
            return "impossible";
        }
        
        return answer;
    }
}