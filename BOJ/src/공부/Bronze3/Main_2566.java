package 공부.Bronze3;

import java.util.Scanner;

public class Main_2566 { //최댓값

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[][] = new int[10][10];
		int max = -1;
		int check[] = new int[2];
		for(int i=1; i<=9; i++) {
			for(int j=1; j<=9; j++) {
				arr[i][j] = sc.nextInt();
				if(arr[i][j] > max) {
					max = arr[i][j];
					check[0] = i;
					check[1] = j;
				}
			}
		}
		System.out.println(max);
		System.out.print(check[0] + " " + check[1]);
	}

}
