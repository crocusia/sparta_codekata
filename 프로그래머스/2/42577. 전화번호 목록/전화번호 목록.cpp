#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool solution(vector<string> phone_book) {
    bool answer = true;
    
    sort(phone_book.begin(), phone_book.end());
    
    for(int i = 0; i < phone_book.size()-1; i++){
        string current = phone_book[i];
        if(phone_book[i+1].compare(0, current.length(), current) == 0){
            answer = false;
            break;
        }
    }
    
    return answer;
}