package 공부.Bronze2;

import java.util.*;

public class Main_19532 { //수학은 비대면강의입니다

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		int e = sc.nextInt();
		int f = sc.nextInt();
		
		for(int i=-999; i<1000; i++) {
			for(int j=-999; j<1000; j++) {
				if(a*i + b*j == c && d*i + e*j == f) {
					System.out.println(i + " " + j);
					break;
				}
			}
		}
	}

}
