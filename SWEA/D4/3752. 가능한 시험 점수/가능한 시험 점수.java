import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

class Solution
{	
	static int[] scores = new int[100];
	static boolean[] reach = new boolean[10001];
    
	public static void main(String args[]) throws Exception
	{
		//System.setIn(new FileInputStream("res/input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = sc.nextInt();
			for(int i = 0; i < n; i++) {
				scores[i] = sc.nextInt();
			}
			
            for(int i = 0; i <= 10000; i++){
            	reach[i] = false;
            }
            reach[0] = true; 
			int maxSum = 0;
            
			for(int i = 0; i < n; i++) {
				for(int j = maxSum; j >= 0; j--) {
					if(!reach[j]) continue;
					reach[j+scores[i]] = true;
				}
                maxSum += scores[i];
			}
			
            int count = 0;
            for(int i = 0; i <= maxSum; i++){
            	if(reach[i]) count++;
            }
			System.out.println("#"+test_case+" "+count);
		}
	}
}