#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool compare(string a, string b) {
    return a + b > b + a;
}

string solution(vector<int> numbers) {
    string answer = "";
    
    vector<string> strNums;
    for (int num : numbers) {
        strNums.push_back(to_string(num));
    }
    
    sort(strNums.begin(), strNums.end(), compare);
   
    if (strNums[0] == "0") return "0";

    for (string s : strNums) {
        answer += s;
    }
    
    return answer;
}

