class Solution {
    int maxUser = 0;
    int maxPrice = 0;
    int[] discounts = {10, 20, 30, 40};
    
    private boolean isMax(int users, int total){
        if(maxUser< users){
            return true;
        }
        if(maxUser == users && maxPrice < total){
            return true;
        }
        return false;
    }
    
    private void compute(int[] setDiscount, int[][]users, int[] emoticons){
        int[] totalPrice = new int[users.length];
        for(int i = 0; i < emoticons.length; i++) {
            for(int j = 0; j < users.length; j++){
                if(users[j][0] <= setDiscount[i]){
                    totalPrice[j] += emoticons[i] / 100 * (100 - setDiscount[i]);
                }
            }
        }
        
        int sumUsers = 0;
        int sumTotalPrices = 0;
        
        for(int i = 0; i < users.length; i++){
            if(totalPrice[i] >= users[i][1]){
                sumUsers++;
            } else{
                sumTotalPrices += totalPrice[i];
            }
        }
        
        if(isMax(sumUsers, sumTotalPrices)){
            maxUser = sumUsers;
            maxPrice = sumTotalPrices;
        }
        
    }
    private void dfs(int depth, int[] setDiscount, int[][] users, int[] emoticons){
        if(depth == emoticons.length){
            compute(setDiscount, users, emoticons);
            return;
        }
        
        for(int ratio : discounts){
            setDiscount[depth] = ratio;
            dfs(depth+1, setDiscount, users, emoticons);
        }
    }
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = {0, 0};
        int[] setDiscount = new int[emoticons.length];
        dfs(0, setDiscount, users, emoticons);
        answer[0] = maxUser;
        answer[1] = maxPrice;
        return answer;
    }
}