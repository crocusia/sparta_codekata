import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(int s = 0; s < skill_trees.length; s++){
            String str = skill_trees[s];
            //스킬트리가 필요없는 스킬이 제거된 문자열
            String result = str.replaceAll("[^"+skill+"]", ""); 
            boolean isPossible = true;
            int i = 0;
            while(isPossible && i < result.length()){
                if(skill.charAt(i) != result.charAt(i)){
                    isPossible = false;
                }
                i++;
            }
            if(isPossible){
                answer++;
            }
        }
        return answer;
    }
}
//Deque Array 써서 스택 만들어.
//문자열에서 해당하지 않는 문자가 들어있는 것만 제거 가능?
//만약에 stack에 선행 스킬이 들어가있는데,