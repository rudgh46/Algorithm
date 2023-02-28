package 공부.Bronze2;

import java.util.Scanner;

public class Main_10988 { //팰린드롬 확인하기

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		StringBuilder sb = new StringBuilder(sc.next());
		
		System.out.println(((sb.toString().equals(sb.reverse().toString())) ? 1: 0) + "\n");
	}

}
