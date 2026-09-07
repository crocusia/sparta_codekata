class Solution {

    int count0 = 0;
    int count1 = 0;
   
    public void increaseCount(int num){
        if(num == 0) {
            count0++;
        }
        else {
            count1++;
        }
    }
    
    public void dfs(int x, int y, int length, int[][]arr){
        if(length == 1){
            increaseCount(arr[x][y]);
            return;
        }
        else{
            int comp = arr[x][y];
            boolean isEqual = true;
            
            for(int i = x; i < x+length; i++){
                for(int j = y; j < y+length; j++){
                    if(comp != arr[i][j]){
                        isEqual = false;            
                        break;
                    }
                }
            }
            
            if(isEqual){
                increaseCount(comp);   
            }
            else{
                int hl = length/2;
                dfs(x, y, hl, arr);
                dfs(x+hl, y, hl, arr);
                dfs(x, y+hl, hl, arr);
                dfs(x+hl, y+hl, hl, arr);
            }
        }
        return;
    }
    
    public int[] solution(int[][] arr) {
        int[] answer = {0, 0};
        dfs(0, 0, arr.length, arr);
        answer[0] = count0;
        answer[1] = count1;
        return answer;
    }
}

//더 나눠질 수 없을 정도로 쪼개져야지

//전부 동일한가?
//맞으면 동일한 수 반환
//아니면 쪼개기
//언제까지? 더이상 쪼개질 수 없을 때까지
//dfs냐 bfs냐 흠...
//dfs가 좀 더 적합한 것 같다.
//순서쌍으로 반환하거나 글로벌로 카운트 변수에 반영하는게

