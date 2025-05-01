#include <string>
#include <vector>
#include <algorithm>
using namespace std;

vector<int> solution(vector<int> lottos, vector<int> win_nums) {
    vector<int> answer;
    int count_zero = 0;
    int count_equal = 0;
    
    for(int i = 0; i < lottos.size(); i++){
        if(lottos[i] == 0){
            count_zero++;
        }
        else{
            for(int j = 0; j < win_nums.size(); j++){
                if(lottos[i] == win_nums[j]){
                    count_equal++;
                    break;
                }
            }
        }
    }
    
    int rank[7] = {6, 6, 5, 4, 3, 2, 1};
    
    answer.push_back(rank[count_equal]);
    answer.push_back(rank[count_equal + count_zero]);
    sort(answer.begin(), answer.end());
    return answer;
}