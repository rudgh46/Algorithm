package _05_1차원_배열.Bronze3;

import java.util.Arrays;
import java.util.Scanner;

public class Main_10818 {//최소, 최대

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
//		int arr[] = new int[N];
		
		for(int i=0; i<N; i++) {
			int a = sc.nextInt();
			if(max<a) max = a;
			if(min>a) min = a;
		}
//		Arrays.sort(arr);
		
		System.out.println(min + " " + max);

	}

}
