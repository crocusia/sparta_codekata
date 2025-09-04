#include <string>
#include <vector>
#include <cmath>
using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;
    for(int i = 0; i < progresses.size(); i++){
        if(progresses[i] < 100){
            int remain = 100 - progresses[i];
            int need = (remain + speeds[i] - 1) / speeds[i];
            progresses[i] = need;
        }
    }
    
    
    int cur = progresses[0];
    int cnt = 1;

    for (int i = 1; i < progresses.size(); i++) {
        if (progresses[i] <= cur) {
            cnt++;
        } else {
            answer.push_back(cnt);
            cur = progresses[i];
            cnt = 1;
        }
    }
    answer.push_back(cnt);
    return answer;
}