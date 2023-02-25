package 공부.Bronze4;

import java.util.Scanner;

public class Main_2480 { //주사위 세개

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int sum = 0;
		if(A==B || B==C || A==C) {
			if(A==B && A==C && B==C) {
				sum = 10000 + (A*1000);
			}
			
			else {
				sum = 1000 + (A = A==B? 100*A: 100*C);
			}
		}
		else {
			sum = Math.max(Math.max(A, B),C) * 100;
		}

		System.out.println(sum);
	}

}
