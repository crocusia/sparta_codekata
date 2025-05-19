#include <string>
#include <vector>
#include <algorithm>
using namespace std;

string solution(string s, string skip, int index) {
    string answer = "";
    
    vector<int> alphabet(26, 0);
    for(char c : skip){
        alphabet[c-'a'] = 1;
    }
    
    for(int i = 0; i < s.size(); i++){
        int start = s[i] - 'a';
        int count = index;
        while(count > 0){
            start = (start+1)%26;
            if(alphabet[start] == 1){
                count++;
            }
            count--;
        }
        answer+= (start%26) + 'a';
    }
    return answer;
}