#include <string>
#include <vector>
#include <algorithm>
using namespace std;
int gcd(int a, int b) {
    while (b != 0) {
        int temp = a % b;
        a = b;
        b = temp;
    }
    return a;
}

bool check(vector<int> array, int gcd){
    for(int i = 0; i < array.size(); i++){
        if(array[i]%gcd == 0){
            return false;
        }
    }
    return true;
}
int solution(vector<int> arrayA, vector<int> arrayB) {
    int answer = 0;
    int gcdA = arrayA[0];
    for (int i = 1; i < arrayA.size(); ++i) {
        gcdA = gcd(gcdA, arrayA[i]);
        if (gcdA == 1) {
            break;
        }
    }
    
    int gcdB = arrayB[0];
    for (int i = 1; i < arrayB.size(); ++i) {
        gcdB = gcd(gcdB, arrayB[i]);
        if (gcdB == 1) {
            break;
        }
    }
    
    if(gcdA > 1 || gcdB > 1){
        bool isA = check(arrayB, gcdA);
        bool isB = check(arrayA, gcdB);
        if(isA && isB){
            answer = max(gcdA, gcdB);
        }
        else if(isA){
            answer = gcdA;
        }
        else if(isB){
            answer = gcdB;
        }
        else{
            answer = 0;
        }
    }
    return answer;
}