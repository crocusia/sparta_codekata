#include <string>
#include <vector>
#include <cmath>
using namespace std;

int countDivisors(int n) {
    int count = 0;

    // 1부터 n의 제곱근까지 확인
    for (int i = 1; i <= sqrt(n); ++i) {
        if (n % i == 0) {
            if (i == n / i) { 
                count++;
            } else {
                count += 2;
            }
        }
    }
    return count;
}

int solution(int number, int limit, int power) {
    int answer = 0;
    
    for(int i = 1; i <= number; i++){
        int num = countDivisors(i);
        if(num > limit){
            answer += power;
        }
        else{
            answer += num;
        }
    }
    return answer;
}