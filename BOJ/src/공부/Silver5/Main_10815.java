package 공부.Silver5;

import java.util.Arrays;
import java.util.Scanner;

public class Main_10815 { //숫자카드

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int arr[] = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		
		int M = sc.nextInt();
		
		for(int i=0; i<M; i++) {
			int num = sc.nextInt();
			if(binarySearch(arr,num) >= 0) {
				System.out.print(1 + " ");
			} else {
				System.out.print(0 + " ");
			}
		}
		
		
	}

	private static int binarySearch(int[] arr, int num) {
		int left = 0;
		int right = arr.length-1;
		
		while(left<=right) {
			int mid = (left + right)/2;
			
			if(num < arr[mid]) {
				right = mid-1;
			} else if(num > arr[mid]) {
				left = mid+1;
			} else return mid;
		}
		
		return -1;
	}

}
