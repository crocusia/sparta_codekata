import java.util.ArrayList;

class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        //최대 원소 파악
        int max = 0;
        for (int[] e : edges) {
            if (e[0] > max) max = e[0];
            if (e[1] > max) max = e[1];
        }
        int size = max + 1;
        
        //in-out 개수
        int[] in = new int[size];
        int[] out = new int[size];
        for (int[] e : edges) {
            int o = e[0];
            int i = e[1];
            out[o]++; in[i]++;
        }
        
        //생성 정점 판별
        for (int v = 1; v < size; v++) {
            if (in[v] == 0 && out[v] >= 2) {
                answer[0] = v;
                break;
            }
        }
        
        //생성 정점의 out 기반 탐색
        int[] next = new int[size]; 
        ArrayList<Integer> starts = new ArrayList<>(out[answer[0]]);
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            if (u == answer[0]) {
                starts.add(v);           
            }
            if (out[u] == 1) { //out이 1개인 경우 다음 노드
                next[u] = v;            
            }
        }
        
        boolean[] visited = new boolean[size]; 
        int[] mark = new int[size];  
        int compId = 1; 
        
        for (int s : starts) {
            if (visited[s]) continue; 

            int cur = s;
            int kind = 0;
            while (true) {
                if (visited[cur]) {
                     break;
                }
                
                if (mark[cur] == compId) {
                    answer[1]++;
                    break;
                }
                mark[cur] = compId;

                if (out[cur] == 0) {
                    answer[2]++;
                    break;
                }
                
                if (out[cur] >= 2) {
                    answer[3]++;
                    break;
                }

                cur = next[cur];
            }
            
            compId++;
        }
        

        return answer;
    }
}