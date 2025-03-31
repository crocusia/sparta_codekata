#include <string>
#include <vector>

using namespace std;

string solution(string s) {
    string answer = "";
    
    int wordPos = 0;
    for(int i = 0; i < s.length(); i++){
        if(s[i] == ' '){
            answer += ' ';
            wordPos = 0;
        }
        else{
            if(wordPos%2 == 0){
                answer += toupper(s[i]);
            }
            else{
                answer += tolower(s[i]);    
            }
            wordPos++;
        }
    }
    return answer;
}