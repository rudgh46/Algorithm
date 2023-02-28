package 공부.Bronze2;

import java.util.Scanner;

public class Main_10812 { // 바구니 순서 바꾸기

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int arr[] = new int[N+1];
		int temp[] = new int[N+1];
		for(int i=1; i<=N; i++) {
			arr[i] = i;
			temp[i] = i;
		}
		
		for(int i=0; i<M; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			int mid = sc.nextInt();
			
			int idx = start;
			
			for(int j=mid; j<=end; j++) {
				temp[idx++] = arr[j];
			}
			for(int j=start; j<mid; j++) {
				temp[idx++] = arr[j];
			}
			
			arr = temp.clone();
		}
		
		for(int i=1; i<=N; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
