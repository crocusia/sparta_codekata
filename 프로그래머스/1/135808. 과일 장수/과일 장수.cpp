#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int solution(int k, int m, vector<int> score) {
    int answer = 0;
    sort(score.begin(), score.end());
    
    int i = score.size()-m;
    while(true){
        if(i < 0){
            break;
        }
        answer += score[i] * m;
        i -= m;
    } 
    return answer;
}