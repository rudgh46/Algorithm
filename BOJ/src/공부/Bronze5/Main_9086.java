package Bronze5;

import java.util.Scanner;

public class Main_9086 { //문자열

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=0; tc<T; tc++) {
			String str = sc.next();
			String ans =str.charAt(0) + ""+ str.charAt(str.length()-1);
			
			System.out.println(ans);
		}
		
		
	}

}
