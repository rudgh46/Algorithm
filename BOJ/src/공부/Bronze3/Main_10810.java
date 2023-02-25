package 공부.Bronze3;

import java.util.Scanner;

public class Main_10810 { //공넣기

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int arr[] = new int[N+1];
		for(int index=0; index<M; index++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			int ball = sc.nextInt();
			
			for(int i = start; i <= end; i++) {
				arr[i] = ball;
			}
		}
		
		for(int i=1; i<=N; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
