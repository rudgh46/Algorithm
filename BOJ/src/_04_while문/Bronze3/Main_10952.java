package _04_while문.Bronze3;

import java.util.Scanner;

public class Main_10952 { //A+B - 5

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		if(A==0 & B==0) break;
		System.out.println(A+B);
		}
	}

}
