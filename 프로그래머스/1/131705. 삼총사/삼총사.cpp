#include <string>
#include <vector>

using namespace std;

int solution(vector<int> number) {
    int answer = 0;
    int count = 0;
    for(int i = 0; i < number.size()-2; i++){
        int sum = number[i];
        for(int j = i+1; j < number.size()-1; j++){
            sum += number[j];
            for(int k = j+1; k < number.size(); k++){
                sum+= number[k];
                if(sum == 0){
                    count++;
                }
                sum-= number[k];
            }
            sum-= number[j];
        }
        sum-= number[i];
    }
    return answer = count;
}