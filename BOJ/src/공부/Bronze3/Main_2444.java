package 공부.Bronze3;

import java.util.Scanner;

public class Main_2444 { //별찍기 7

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		for(int i=0; i<N; i++) {
			for(int j=i; j<N-1; j++) {
				System.out.print(" ");
			}for(int j=0; j<i*2+1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i=N-1; i>0; i--) {
			for(int j=0; j<N-i; j++) {
				System.out.print(" ");
			}for(int j=0; j<i*2-1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
