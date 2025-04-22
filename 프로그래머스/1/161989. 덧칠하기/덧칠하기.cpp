#include <string>
#include <vector>

using namespace std;

int walls[100001];

int solution(int n, int m, vector<int> section) {
    int answer = 0;
    
    for(int i = 0; i <= 100000; i++){
        walls[i] = 1;
    }
    
    for(auto i : section){
        walls[i] = 0;
    }
    
    for(auto i : section){
        if(walls[i] == 0){
            answer++;
            for(int j = 0; j < m; j++){
                if(i + j > n) break;
                walls[i+j] = 1;
            }
        }
    }
    
    return answer;
}