import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answerList = new ArrayList<>();
        
        int tDate[] = turnInteger(today, "\\.");
        
        Map<String, Integer> termsData = new HashMap();
        
        for(String term : terms){
            String data[] = term.split(" ");
            String key = data[0];
            int value = Integer.parseInt(data[1]);
            termsData.put(key, value);
        }
        
        for(int i = 0; i < privacies.length; i++){
            String[] data = privacies[i].split(" ");
            int[] date = turnInteger(data[0], "\\.");
            String type = data[1];
            
            date[2] -= 1;
            if (date[2] == 0) {
                date[2] = 28;   
                date[1] -= 1;
                if (date[1] == 0) {
                    date[1] = 12;
                    date[0] -= 1;
                }
            }
            
            int month = termsData.get(type);
            int expire = date[1] + month;
            
            if(expire > 12){
                date[0] += (expire - 1) / 12; 
                date[1] = expire % 12; 
                if (date[1] == 0) date[1] = 12;
            } else {
                date[1] = expire;  
            }
                
            if(isExpire(tDate, date)){
                answerList.add(i+1);
            }
        }
        
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i); 
        }
        
        return answer;
    }
    
    int[] turnInteger(String data, String s){
        String datas[] = data.split(s);
        
        int[] result = new int[datas.length];
        
        for(int i = 0; i < datas.length; i++){
            result[i] = (Integer.parseInt(datas[i]));
        }
        return result;
    }
        
    boolean isExpire(int[] tDate, int[] eDate){
        if(tDate[0] > eDate[0]) return true;
        if(tDate[0] == eDate[0] && tDate[1] > eDate[1]) return true;
        if(tDate[0] == eDate[0] && tDate[1] == eDate[1] && tDate[2] > eDate[2]) return true;
        return false;
    }
}