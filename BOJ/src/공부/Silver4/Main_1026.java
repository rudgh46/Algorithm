package 공부.Silver4;

import java.util.*;

public class Main_1026 { //보물

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int A_arr[] = new int[N];
		Integer B_arr[] = new Integer[N];
		for(int i=0; i<N; i++) {
			A_arr[i] = sc.nextInt();
		}
		Arrays.sort(A_arr);
		for(int i=0; i<N; i++) {
			B_arr[i] = sc.nextInt();
		}
		Arrays.sort(B_arr,Collections.reverseOrder());
		
		int ans = 0;
		
		for(int i=0; i<N; i++) {
			ans += A_arr[i] * B_arr[i]; 
		}
		System.out.println(ans);
	}

}
