#include <string>
#include <vector>

using namespace std;

int solution(int storey) {
    int answer = 0;
    while(storey > 0){
        int num = storey % 10;
        int next = (storey / 10) % 10;
        if(num > 5 || (num == 5 && next >= 5)){
            storey += (10 - num); 
            answer += (10 - num);
        }
        else{
            storey -= num;
            answer += num;
        }
        storey /= 10;
    }
    return answer;
}