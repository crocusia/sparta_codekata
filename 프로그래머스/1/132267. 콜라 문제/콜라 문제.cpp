#include <string>
#include <vector>

using namespace std;

int solution(int a, int b, int n) {
    int answer = 0;
    while(n >= a){
        int num = n/a*b;
        int less = n%a;
        answer += num;
        n = num+less;
    }
    return answer;
}