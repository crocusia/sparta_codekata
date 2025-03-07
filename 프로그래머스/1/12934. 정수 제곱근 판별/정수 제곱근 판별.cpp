#include <string>
#include <vector>
#include <cmath>
using namespace std;

long long solution(long long n) {
    long long answer = 0;
    auto loot = sqrt(n);
    if(loot == floor(loot)){
        answer = (loot + 1) * (loot + 1);
    }
    else{
        answer = -1;
    }
    return answer;
}