package _04_while문.Bronze3;

import java.util.Scanner;

public class Main_10951 {

	public static void main(String[] args) { //A+B - 4
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNextInt()) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			System.out.println(A+B);
		}sc.close();
		

	}

}
