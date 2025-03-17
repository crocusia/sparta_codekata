#include <string>
#include <vector>
#include <cmath>
using namespace std;
typedef long long ll;
ll solution(int k, int d) {
    ll answer = 0;
    for(ll x = 0; x <= d; x+=k){
        ll maxY = static_cast<int>(sqrt(1LL * d * d - 1LL * x * x));
        answer += maxY/k +1;
    }
    return answer;
}