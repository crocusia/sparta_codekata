#include <string>
#include <vector>

using namespace std;

int solution(vector<vector<int>> sizes) {
    int answer = 0;
    int max_width = 0;
    int max_height = 0;
    for (auto& size : sizes) {
    // 가로와 세로 중 더 큰 값을 가로로, 작은 값을 세로로 설정
        int width = max(size[0], size[1]);
        int height = min(size[0], size[1]);

        max_width = max(max_width, width);  // 최대 가로 길이
        max_height = max(max_height, height);  // 최대 세로 길이
    }
    answer = max_width * max_height;
    
    return answer;
}