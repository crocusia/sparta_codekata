#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(int N, vector<int> stages) {
    vector<int> answer;
    vector<int> usersAtStage(N + 2, 0);
    int totalPlayers = stages.size();

    for (int stage : stages) {
        usersAtStage[stage]++;
    }

    vector<pair<int, double>> failureRates;

    int playersRemaining = totalPlayers;

    for (int i = 1; i <= N; ++i) {
        int fail = usersAtStage[i];
        double failureRate = 0.0;

        if (playersRemaining != 0) {
            failureRate = (double)fail / playersRemaining;
        }

        failureRates.push_back({i, failureRate});
        playersRemaining -= fail;
    }

    sort(failureRates.begin(), failureRates.end(), [](pair<int, double>& a, pair<int, double>& b) {
        if (a.second == b.second) return a.first < b.first;
        return a.second > b.second;
    });

    for (auto& p : failureRates) {
        answer.push_back(p.first);
    }

    return answer;
}
