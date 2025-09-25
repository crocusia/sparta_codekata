#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<vector<int>> triangle) {
    int answer = 0;

    if(triangle.size() == 1){
        return triangle[0][0];
    }
    
    for(int i = 1; i < triangle.size(); i++){ 
        for(int j = 0; j < triangle[i].size(); j++){
            int current = triangle[i][j];
            int result;
            if(j == 0){
                result = triangle[i-1][j];
            }
            else if(j == triangle[i].size()-1){
                result = triangle[i-1][j-1];
            }
            else{
                result = max(triangle[i-1][j-1], triangle[i-1][j]);
            }
            triangle[i][j] = current + result;
        }
    }
    
    vector<int>& last = triangle[triangle.size() - 1];
    
    return answer = *max_element(last.begin(), last.end()); 
}