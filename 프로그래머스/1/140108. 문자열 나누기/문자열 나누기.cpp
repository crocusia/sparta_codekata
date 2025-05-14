#include <string>
#include <vector>

using namespace std;

int solution(string s) {
    int answer = 0;
    
    vector<int> pos;
    
    int countX = 0;
    int countY = 0;
    char start = s[0];
    bool isStart = true;
    for(int i = 0; i < s.length(); i++){
        char c = s[i];
        if(!isStart){
            start = c;
            isStart = true;
        }
    
        if(start == c){
            countX++;
        }
        else{
            countY++;
        }
        
        if(countX == countY || i == s.length()-1){
            pos.push_back(i);
            isStart = false;
            countX = 0;
            countY = 0;
        }
    }
    
    return answer = pos.size();
}