/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
    static char[][] maps = new char[20][20];
    static int[] dirY = new int[]{-1, 1, 0, 0};
    static int[] dirX = new int[]{0, 0, -1, 1};
    static String dirC = "^v<>";
    static String moveC = "UDLR";
    
    static int h = 0;
    static int w = 0;
    
    static void shoot(int px, int py, int dir){
    	//현재위치에서 방향에 따라 탐색 시작, 좌표가 범위 이내일때
        int nextX = px; int nextY = py; 
        while(nextX >= 0 && nextX < w && nextY < h && nextY >= 0){
            if(maps[nextY][nextX] == '*') {
            	maps[nextY][nextX] = '.'; 
            	break;
            }
            if(maps[nextY][nextX] == '#') {
            	break;
            }
            nextX = nextX + dirX[dir];
            nextY = nextY + dirY[dir];
        }
    }   
    public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			h = sc.nextInt();
            w = sc.nextInt();
            
            int dir = 0; int px = 0; int py = 0;
    
            for(int i = 0; i < h; i++){
            	String m = sc.next();
                for(int j = 0; j < w; j++){
                    maps[i][j] = m.charAt(j);
                    for(int d = 0; d < 4; d++){
                    	if(maps[i][j] == dirC.charAt(d)){
                        	px = j;
                            py = i;
                            dir = d;
                            break;
                        }
                    }
                }
            }
            
            int times = sc.nextInt();
            String moves = sc.next();
         	for(int t = 0; t < times; t++){
            	char m = moves.charAt(t);
                if(m == 'S'){
                	shoot(px, py, dir);
                    continue;
                }
                dir = moveC.indexOf(m);
                maps[py][px] = dirC.charAt(dir);
                
                int nextX = px+dirX[dir];
                int nextY = py+dirY[dir];
                if(nextX >= 0 && nextX < w && nextY >= 0 && nextY < h){
                	if(maps[nextY][nextX] == '.'){
                        maps[nextY][nextX] = maps[py][px];
                        maps[py][px] = '.';
                       	px = nextX;
                        py = nextY;
                    }
                }
            }
            
            System.out.print("#"+test_case+" ");
            for(int i = 0; i < h; i++){
            	for(int j = 0; j < w; j++){
                	System.out.print(maps[i][j]);
                }
                System.out.print("\n");
            }
		}
	}
}