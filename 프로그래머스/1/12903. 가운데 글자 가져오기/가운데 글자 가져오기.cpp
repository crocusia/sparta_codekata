#include <string>
#include <vector>

using namespace std;

string solution(string s) {
    string answer = "";
    int half = s.length()/2;
    if(s.length() % 2 == 0){
        answer = s.substr(half-1, 2);
    }
    else{
        answer = s.substr(half, 1);
    }
    return answer;
}