#include <string>
#include <vector>

using namespace std;

vector<string> nums = { "zero","one","two","three","four","five","six","seven","eight","nine"};

int solution(string s) {
    int answer = 0;
    for(int i = 0; i < nums.size(); i++){
        size_t pos = 0;
        while ((pos = s.find(nums[i], pos)) != string::npos) {
            s.replace(pos, nums[i].length(), to_string(i));
        }
    } 
    answer = stoi(s);
    return answer;
}