class Solution {
    public int[] solution(int n) {
        int[][] data = new int[n][n];
        int row = -1;
        int col = 0;
        int num = 1;
        
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                if(i%3 == 0){
                    row++;
                }
                else if(i%3 == 1){
                    col++;
                }
                else{
                    row--;
                    col--;
                }
                data[row][col] = num;
                num++;
            }
        }
        
        int totalCount = n * (n + 1) / 2;
        int[] answer = new int[totalCount];
        int index = 0;
        
        for (int r = 0; r < n; r++) {
            for (int c = 0; c <= r; c++) { 
                answer[index++] = data[r][c];
            }
        }
        return answer;
    }
}