package D2;

import java.util.Scanner;

public class Solution_1204 {// 최빈수 구하기

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int max = 0;
			int res = 0;
			sc.nextInt();
			int arr[] = new int[101];

			for(int i=0; i<1000; i++) {
				int score = sc.nextInt();
				arr[score]++;
			}
			
			for(int i = 0; i<=100; i++) {
				if(max<=arr[i]) {
					max = arr[i];
					res = i;
				}
			}
			System.out.println("#"+tc+" "+res);
		}
	}

}
