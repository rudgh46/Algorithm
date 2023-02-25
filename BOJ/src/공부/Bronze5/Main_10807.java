package 공부.Bronze5;

import java.util.Arrays;
import java.util.Scanner;

public class Main_10807 { //개수 세기

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int arr[] = new int[201];
		Arrays.fill(arr, 0);
		for(int i=0; i<N; i++) {
			int num = sc.nextInt()+100;
			arr[num]++;
		}
		int v = sc.nextInt()+100;
		System.out.println(arr[v]);
	}

}
