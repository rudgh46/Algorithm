package 공부.Bronze4;

import java.util.Scanner;

public class Main_2525 {//오븐 시계

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt(); //현재 시간
		int B = sc.nextInt(); //현재 분
		int C = sc.nextInt(); //요리에 필요한 시간
		
		if(B+C>=60) {
			A += (B+C)/60;
			if(A>=24) A %= 24;
			int D = (B+C)%60;
			System.out.println(A +" "+ D);
		}
		else if(B+C<60) {
			System.out.println(A +" "+ (B+C));
		}
	}

}
