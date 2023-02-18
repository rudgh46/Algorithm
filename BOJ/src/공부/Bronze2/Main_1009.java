package 공부.Bronze2;

import java.util.*;

public class Main_1009 { //분산처리

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=0; tc<T; tc++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int ans = 1;
			for(int i=0; i<b; i++) {
				ans = (ans*a)%10;
			}
			if(ans == 0) ans=10;
			System.out.println(ans);
		}
		
	}

}
