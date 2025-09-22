#include<string>
#include <iostream>

using namespace std;

bool solution(string s)
{
    bool answer = true;
    int n = 0;
    int open = 0;
    int close = 0;
    
    for(int i = 0; i < s.length(); i++){
        if(s[i] == '('){
            n++;
            open++;
        }
        else if(s[i] == ')'){
            n--;
            close++;
            if(close > open){
                return false;
            }
        }
    }
    if(n!=0){
        answer = false;
    }
    return answer;
}