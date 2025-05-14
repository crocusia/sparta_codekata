#include <string>
#include <vector>
#include <algorithm> 
using namespace std;

int solution(int n, vector<int> lost, vector<int> reserve) {
    int answer = 0;
    
    sort(reserve.begin(), reserve.end());
    sort(lost.begin(), lost.end());
    
    vector<int> newLost;

    //안 가져왔지만 본인의 여분이 있는 경우 제외
    for (int l : lost) {
        auto f = find(reserve.begin(), reserve.end(), l);
        if (f == reserve.end()) {
            newLost.push_back(l);
        } else {
            reserve.erase(f);
        }
    }
    
    answer = n - newLost.size();
    vector<int> borrows(reserve.size(), 0);
        
    for(int nl : newLost){
        for(int i = 0; i < reserve.size(); i++){
            if(borrows[i] == 0){
                if(reserve[i] == nl-1){
                    answer++;
                    borrows[i] = 1;
                    break;
                }
                if(reserve[i] == nl+1){
                    answer++;
                    borrows[i] = 1;
                    break;
                }
            }
        }
    }

    return answer;
}