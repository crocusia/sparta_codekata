#include <set>
#include <vector>
#include <algorithm> 
using namespace std;

vector<int> solution(vector<int> numbers) {
    vector<int> answer;
    sort(numbers.begin(), numbers.end());
    set<int> sums;
    for (int i = 0; i < numbers.size(); ++i) {
        for (int j = i + 1; j < numbers.size(); ++j) {
            sums.insert(numbers[i] + numbers[j]);
        }
    }
    return answer = vector<int>(sums.begin(), sums.end());
}