package 공부.Gold4;

import java.util.Scanner;

public class Main_2096 {//내려가기

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int dp[][] = new int[N+1][3];
		int dp2[][] = new int[N+1][3];
		
		for(int i=1; i<=N; i++) {
			int red = sc.nextInt();
			int green = sc.nextInt();
			int blue = sc.nextInt();
			
			dp[i][0] = Math.min(dp[i-1][0], dp[i-1][1]) + red; 
			dp[i][1] = Math.min(dp[i-1][0],Math.min(dp[i-1][1], dp[i-1][2])) + green; 
			dp[i][2] = Math.min(dp[i-1][1], dp[i-1][2]) + blue;  
			dp2[i][0] = Math.max(dp2[i-1][0], dp2[i-1][1]) + red; 
			dp2[i][1] = Math.max(dp2[i-1][0],Math.max(dp2[i-1][1], dp2[i-1][2])) + green;
			dp2[i][2] = Math.max(dp2[i-1][1], dp2[i-1][2]) + blue;  
		}
		
		System.out.print(Math.max(dp2[N][0], Math.max(dp2[N][1], dp2[N][2]))+ " ");
		System.out.print(Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2])));
	}

}
