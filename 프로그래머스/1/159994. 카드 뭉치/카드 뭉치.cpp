#include <string>
#include <vector>
#include <queue>

using namespace std;

string solution(vector<string> cards1, vector<string> cards2, vector<string> goal) {
    string answer = "Yes";
    
    queue<string> q1, q2;
    
    for (const auto& word : cards1) q1.push(word);
    for (const auto& word : cards2) q2.push(word);
    
      for (const auto& target : goal) {
        if (!q1.empty() && q1.front() == target) {
            q1.pop();
        } else if (!q2.empty() && q2.front() == target) {
            q2.pop();
        } else {
            return "No";
        }
    }
    
    return answer;
}