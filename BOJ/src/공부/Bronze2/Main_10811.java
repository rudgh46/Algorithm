package 공부.Bronze2;

import java.util.Scanner;

public class Main_10811 { // 바구니 뒤집기

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int arr[] = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			arr[i] = i;
		}
		
		for(int i=0; i<M; i++) {
			int left = sc.nextInt();
			int right = sc.nextInt();
			
			while(left < right) {
				int temp = arr[left];
				arr[left++] = arr[right];
				arr[right--] = temp;
			}
			
		}
		for(int i=1; i<=N; i++) {
			System.out.print(arr[i] + " ");			
		}
		
	}

}
