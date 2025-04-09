#include <string>
#include <vector>

using namespace std;

vector<int> solution(string s) {
    vector<int> answer;
    int array[26];
    fill(begin(array), end(array), -1);
    
    for(int i = 0; i < s.length(); i++){
        int num = static_cast<int>(s[i])-97;
        if(array[num] == -1){
            answer.push_back(-1);
        }
        else{
            answer.push_back(i-array[num]);
        }
        array[num] = i;
    }
    return answer;
}