#include <string>
#include <vector>

using namespace std;

int solution(int num) {
    int answer = 0;
    for(int i = 0; i < 400; i++){
        if(num == 1){
            return answer;
        }
        if(num % 2 == 0){
            num = num / 2;
        }
        else{
            num = num * 3 + 1;
        }
        answer++;
    }
    return -1;
}