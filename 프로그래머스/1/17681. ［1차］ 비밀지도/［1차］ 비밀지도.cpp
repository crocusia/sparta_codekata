#include <string>
#include <vector>
#include <math.h>
using namespace std;

vector<string> solution(int n, vector<int> arr1, vector<int> arr2) {
    vector<string> answer;
    
    for(int i = 0; i < n; i++){
        string s = "";
        int a1 = arr1[i];
        int a2 = arr2[i];
        for(int j = pow(2, n-1); j > 0; j/=2){
            if(a1/j == 0 && a2/j == 0){
                s += " ";
            }
            else{
                s += "#";
            }
            a1 = a1 % j;
            a2 = a2 % j;
        }
        answer.push_back(s);
    }
    
    return answer;
}