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
import java.util.*;
/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
    static int[][] ladders = new int[100][100];
    static int[][] visited = new int[100][100];
    static Queue<int[]> q = new LinkedList<>();
    
	public static void main(String args[]) throws Exception
	{
        //좌우상
        int[] moveR = new int[]{0, 0, -1};
        int[] moveC = new int[]{-1, 1, 0};
		Scanner sc = new Scanner(System.in);
		int T=10;
		//T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int tc = sc.nextInt();
            
            int gr = 0; int gc = 0;
            q.clear();
            for(int i = 0; i < 100; i++){
            	for(int j = 0; j < 100; j++){
                    visited[i][j] = 0;
                    ladders[i][j] = sc.nextInt();
                	if(ladders[i][j] == 2){
                    	gr = i; gc = j;
                    }
                }
            } 
            int answer = 0;
            q.offer(new int[]{gr, gc});
            
            while(!q.isEmpty()){
            	int[] n = q.poll();
                int nowR = n[0]; int nowC = n[1];
                visited[nowR][nowC] = 1;
                if(nowR == 0){  
                    answer = nowC;
                	break;
                }
                
                for(int i = 0; i < 3; i++){
                	int nextR = nowR + moveR[i];
                    int nextC = nowC + moveC[i];
                    if(nextR < 0 || nextR >= 100 || nextC < 0 || nextC >= 100) continue;
                    
                    if(ladders[nextR][nextC] == 1 && visited[nextR][nextC] == 0){
                    	q.offer(new int[]{nextR, nextC});
                        break;	
                    }
                }
            }
            
            System.out.println("#" +tc+" "+answer);   
		}
	}
}