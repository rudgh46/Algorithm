package 공부.Bronze4;

import java.util.Scanner;

public class Main_9498 { //시험 성적

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		if(N>=90) {
			System.out.println("A");
		}else if(N>=80) {
			System.out.println("B");
		}else if(N>=70) {
			System.out.println("C");
		}else if(N>=60) {
			System.out.println("D");
		}else {
			System.out.println("F");
		}

	}

}
