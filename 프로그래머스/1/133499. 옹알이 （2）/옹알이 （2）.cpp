#include <string>
#include <vector>
#include <algorithm>
using namespace std;

bool isValid(const string& word) {
    vector<string> sounds = {"aya", "ye", "woo", "ma"};
    string prev = "";
    int i = 0;
    while (i < word.length()) {
        bool matched = false;
        for (const auto& sound : sounds) {
            if (word.substr(i, sound.size()) == sound && sound != prev) {
                i += sound.size();
                prev = sound;
                matched = true;
                break;
            }
        }
        if (!matched) return false;
    }
    return true;
}

int solution(vector<string> babbling) {
    int answer = 0;
    for (const string& word : babbling) {
        if (isValid(word)) answer++;
    }
    return answer;
}