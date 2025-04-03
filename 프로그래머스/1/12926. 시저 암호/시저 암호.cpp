#include <string>
#include <vector>

using namespace std;

string crypt(string s, int n) {
    for (char &c : s) {
        if (isalpha(c)) { // 알파벳만 이동
            char base = islower(c) ? 'a' : 'A';
            c = (c - base + n) % 26 + base;
        }
    }
    return s;
}

string solution(string s, int n) {
    string answer = "";
    answer = crypt(s, n);
    return answer;
}