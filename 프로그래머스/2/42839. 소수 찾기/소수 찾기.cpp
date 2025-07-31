#include <string>
#include <vector>
#include <set>
#include <cmath>

using namespace std;

set<int> results;
vector<bool> visited;
bool is_prime(int num) {
    if (num <= 1) return false;
    for (int i = 2; i <= sqrt(num); i++) {
        if (num % i == 0) return false;
    }
    return true;
}

void generate(string numbers, string current) {
    if (!current.empty()) {
        results.insert(stoi(current));
    }

    for (int i = 0; i < numbers.size(); i++) {
        if (!visited[i]) {
            visited[i] = true;
            generate(numbers, current + numbers[i]);
            visited[i] = false;
        }
    }
}

int solution(string numbers) {
    visited.resize(numbers.size(), false);
    generate(numbers, "");

    int count = 0;
    for (int num : results) {
        if (is_prime(num)) count++;
    }
    return count;
}