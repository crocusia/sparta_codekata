


#include <string>
#include <vector>
#include <algorithm>

using namespace std;

long long solution(vector<int> weights) {
    long long answer = 0;
    
    sort(weights.begin(), weights.end());
    
    vector<pair<int, int>> ratios = {{1, 1}, {2, 3}, {2, 4}, {3, 4}};
    
     for (int i = 0; i < weights.size(); i++) {
        for (auto &[a, b] : ratios) {
            int w2 = (weights[i] * b) / a;
            if ((weights[i] * b) % a == 0) { //딱 나눠 떨어지면
                auto it = lower_bound(weights.begin() + i + 1, weights.end(), w2);
                while (it != weights.end() && *it == w2) {
                    answer++;
                    it++;
                }
            }
        }
    }
    
    return answer;
}