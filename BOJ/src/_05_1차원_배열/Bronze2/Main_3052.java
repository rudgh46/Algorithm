package _05_1차원_배열.Bronze2;

import java.util.Scanner;

public class Main_3052 {//나머지

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt =0;
		int arr[] = new int[1000];
		for(int i=0; i<10; i++) {
			int j = sc.nextInt() % 42;
			arr[j] = 1;
		}
		for(int i=0; i<1000; i++) {
			if(arr[i] == 1) cnt++;
			
		}
		System.out.println(cnt);
	}

}
