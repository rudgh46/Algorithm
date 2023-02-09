package 공부.Bronze2;

import java.util.Scanner;

public class Main_2675 { //문자열 반복

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc<=T; tc++) {
			int R = sc.nextInt();
			String str = sc.next();

			for(int i=0; i<str.length(); i++) {
				for(int j=0; j<R; j++) {
					System.out.print(str.charAt(i));
				}
			}
			System.out.println();
		}
		
		
	}

}
