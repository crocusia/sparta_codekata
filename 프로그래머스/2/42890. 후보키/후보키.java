import java.util.*;
class Solution {
    public int solution(String[][] relation) {
        int rowL = relation.length;
        int colL = relation[0].length;
        
        //조합
        List<Integer> candidates = new ArrayList<>();
        for(int i = 0; i < (1<<colL); i++){
            candidates.add(i);
        }
        candidates.sort((a, b) -> Integer.bitCount(a) - Integer.bitCount(b));
        
        List<Integer> selected = new ArrayList<>();
        
        for(int cd : candidates){
            //최소성
            boolean isMinimal = true;
            for(int s : selected){
                if((s&cd) == s){
                    isMinimal = false;
                    break;
                }
            }    
            
            if(!isMinimal) continue;
            
            //중복
            Set<String> comp = new HashSet<>();
            for(int r = 0; r < rowL; r++){
                StringBuilder sb = new StringBuilder();
                for(int c = 0; c < colL; c++){
                    if((cd & (1 << c)) != 0){
                        sb.append(relation[r][c]).append("/");
                    }
                }
                comp.add(sb.toString());
            }
            if(comp.size() == rowL){
                selected.add(cd);
            }
        }
        
        return selected.size();
    }
}