package 공부.Bronze4;

import java.util.Scanner;

public class Main_1330 { //두 수 비교하기

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		if(A>B) System.out.print(">");
		if(A<B) System.out.println("<");
		if(A==B) System.out.println("==");
	}

}
