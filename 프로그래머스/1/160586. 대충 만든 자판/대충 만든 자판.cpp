#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<string> keymap, vector<string> targets) {
    vector<int> answer;
    vector<int> alphabet(26, 101);
    
    for(string k : keymap){
        for(int i = 0; i < k.size(); i++){
            int pos = k[i] - 'A';
            alphabet[pos] = min(alphabet[pos], i+1);
        }
    }
    
    for(string t : targets){
        int count = 0;
        for(int i = 0; i < t.size(); i++){
            int pos = t[i] - 'A';
            if(alphabet[pos] == 101){
                count = -1;
                break;
            }
            count+= alphabet[pos];
        }
        answer.push_back(count);
    }
    return answer;
}