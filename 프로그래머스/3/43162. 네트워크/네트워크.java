import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        int[] visited = new int[n];
        
        Queue<Integer> q = new LinkedList<>(); 
                 
        for(int i = 0; i < n; i++){
            if(visited[i] == 0){
                q.add(i);
                visited[i] = 1;
                while(!q.isEmpty()){
                    int pop = q.poll();
                    for(int e = 0; e < n; e++){
                        if(computers[pop][e] == 1 && visited[e] == 0){
                            visited[e] = 1;
                            q.add(e);
                        }
                    }
                }
                answer++;
            } 
        }
        return answer;
    }
}