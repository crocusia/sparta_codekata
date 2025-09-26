#include <string>
#include <vector>

using namespace std;

int dfs(const vector<int>& numbers, int target, int index, int result) {

    if (index == numbers.size()) {
        if (result == target) {
            return 1;
        } else {
            return 0;
        }
    }

    int plus = dfs(numbers, target, index + 1, result + numbers[index]);

    int minus = dfs(numbers, target, index + 1, result - numbers[index]);

    return plus + minus;
}

int solution(vector<int> numbers, int target) {
    int answer = dfs(numbers, target, 0, 0);
    return answer;
}