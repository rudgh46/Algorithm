package 공부.Bronze5;

import java.util.Scanner;

public class Main_2738 { //행렬덧셈

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int arr[][] = new int[N][M];
		
		for(int k=0; k<2; k++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					arr[i][j] += sc.nextInt();
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
	}

}
