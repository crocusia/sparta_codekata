#include <string>
#include <vector>

using namespace std;

int end_days[13] = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
string week[7] = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};

string solution(int a, int b) {
    string answer = "";
    int total_days = 0;
    
    for (int i = 1; i < a; ++i) {
        total_days += end_days[i];
    }

    total_days += (b - 1);
    
    answer = week[total_days % 7];
    return answer;
}