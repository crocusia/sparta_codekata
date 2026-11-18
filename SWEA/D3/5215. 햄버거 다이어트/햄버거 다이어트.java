
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;
import java.math.*;

class Solution
{
	static int[] scores = new int[20];
	static int[] cals = new int[20];
	
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
			int l = sc.nextInt();
			
			for(int i = 0; i < n; i++){
				scores[i] = sc.nextInt();
				cals[i] = sc.nextInt();
			}
			
			int dp[][] = new int[n+1][l+1];
			for(int[] row : dp) Arrays.fill(row , -1);
			dp[0][0] = 0;
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j <= l; j++) {
					if(dp[i][j] == -1) continue;
					int now = dp[i][j];
					
					dp[i+1][j] = Math.max(dp[i+1][j], now);
					
					int next = j+cals[i];
					if(next <= l) {
						dp[i+1][next] = Math.max(dp[i+1][next], now + scores[i]);
					}
				}
			}
			
			int answer = 0;
			for(int i = 0; i <= l; i++) {
				answer = Math.max(dp[n][i], answer);
			}
			
			System.out.println("#"+test_case+" "+answer);
		}
	}
}