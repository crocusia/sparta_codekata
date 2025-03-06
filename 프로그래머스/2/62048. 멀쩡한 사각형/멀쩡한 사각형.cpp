using namespace std;

typedef long long ll;

ll calcGCD(ll num1, ll num2){
    while(num2 != 0){
        ll temp = num2;
        num2 = num1%num2;
        num1 = temp;
    }
    return num1;
}
long long solution(int w,int h) {
    long long answer = 1;
    ll width = (ll) w;
    ll height = (ll) h;
    ll gcd;
    gcd = calcGCD(width, height);
    answer = width * height - (width + height - gcd);
    return answer;
}