#include <string>
#include <vector>

using namespace std;

int solution(int num1, int num2) {
    int answer= 0;
    double result = (double) num1 / (double) num2 * 1000;
    answer = result / 1;
    return answer;
}