package 공부.Bronze5;

import java.math.BigInteger;
import java.util.Scanner;

public class Main_2338 { //긴자리 계산
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		BigInteger a = sc.nextBigInteger();
		BigInteger b = sc.nextBigInteger();
		
		BigInteger plus = a.add(b);
		BigInteger minus = a.subtract(b);
		BigInteger mul = a.multiply(b);
		
		sb.append(plus).append("\n").append(minus).append("\n").append(mul);
		System.out.println(sb);
		
	}
}
