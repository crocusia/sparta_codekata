#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> arr, int divisor) {
    vector<int> answer;
    for(int i = 0; i < arr.size(); i++){
        if(arr[i] % divisor == 0){
            answer.push_back(arr[i]);
        }
    }
    if(answer.empty()){
        answer.push_back(-1);
    }
    else{
        sort(answer.begin(), answer.end());
    }
    return answer;
}