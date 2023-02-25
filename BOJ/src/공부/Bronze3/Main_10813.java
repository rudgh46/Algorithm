package 공부.Bronze3;

import java.util.Scanner;

public class Main_10813 { //공 바꾸기

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N  = sc.nextInt();
		int arr[] = new int[N+1];
		int M = sc.nextInt();
		
		for(int i=0; i<=N; i++) {
			arr[i] = i;
		}
		
		for(int i=0; i<M; i++) {
			int first = sc.nextInt();
			int second = sc.nextInt();
			
			int temp = arr[first];
			arr[first] = arr[second];
			arr[second] = temp;
		}
		
		for(int i=1; i<=N; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
