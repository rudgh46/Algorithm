package 공부.Bronze5;

import java.util.Scanner;

public class Main_3003 { //킹, 퀸, 룩, 비숍, 나이트, 폰

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int chess[] = {1,1,2,2,2,8};
		int myChess[] = new int[6];
		
		for(int i=0; i<6; i++) {
			myChess[i] = sc.nextInt();
			
			System.out.print(chess[i] - myChess[i] + " ");
		}
		
	}

}
