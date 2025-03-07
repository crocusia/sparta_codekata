#include <string>
#include <vector>
#include <algorithm>

using namespace std;

long long solution(long long n) {
    long long answer = 0;
    vector<long long> nums;
    while(n%10 != n){
        nums.push_back(n%10);
        n = n/10;
    }
    nums.push_back(n%10);
    
    sort(nums.begin(), nums.end());
    
    int j = 1;
    for(int i = 0; i < nums.size(); i++){
        answer += nums[i] * j;
        j *= 10;
    }
    return answer;
}